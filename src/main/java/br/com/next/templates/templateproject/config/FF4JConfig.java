package br.com.next.templates.templateproject.config;

import javax.sql.DataSource;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.ff4j.FF4j;
import org.ff4j.cache.FF4JCacheManager;
import org.ff4j.cache.FF4jCacheManagerRedis;
import org.ff4j.mongo.store.EventRepositoryMongo;
import org.ff4j.mongo.store.FeatureStoreMongo;
import org.ff4j.mongo.store.PropertyStoreMongo;
import org.ff4j.redis.RedisConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FF4JConfig {

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String jdbcUserName;

    @Value("${spring.datasource.password}")
    private String jdbcPassword;

    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;

    @Value("${spring.redis.host}")
    private String redisHostname;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.password}")
    private String redisPassword;

    @Value("${spring.data.mongodb.database}")
    private String mongoDatabaseName;

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    private static final String MONGO_FEATURES_COLLECTION = "ff4j_features";
    private static final String MONGO_PROPERTIES_COLLECTION = "ff4j_properties";
    private static final String MONGO_EVENTS_COLLECTION = "ff4j_events";

    @Bean
    public FF4j getFF4j(DataSource dataSource) {
        FF4j ff4j = new FF4j();

//        usePostgresDatabase(dataSource, ff4j);
        useMongoDatabase(ff4j);
        useRedisCache(ff4j);
        ff4j.audit(true);
        return ff4j;
    }

    private void useRedisCache(final FF4j ff4j) {
        RedisConnection redisConnection = new RedisConnection(redisHostname, redisPort, redisPassword);
        FF4JCacheManager ff4jCache = new FF4jCacheManagerRedis(redisConnection);
        ff4j.cache(ff4jCache);
    }

    private void usePostgresDatabase(final DataSource dataSource, final FF4j ff4j) {
//        ff4j.setFeatureStore(new FeatureStoreSpringJdbc(dataSource));
//        ff4j.setPropertiesStore(new PropertyStoreSpringJdbc(dataSource));
//        ff4j.setEventRepository(new EventRepositorySpringJdbc(dataSource));
    }

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource jdbc = new DriverManagerDataSource();
//        jdbc.setDriverClassName(jdbcDriver);
//        jdbc.setUrl(jdbcUrl);
//        jdbc.setPassword(jdbcPassword);
//        jdbc.setUsername(jdbcUserName);
//        return jdbc;
//    }

    private void useMongoDatabase(final FF4j ff4j) {
        MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoUri));
        MongoDatabase mongoDatabase = mongoClient.getDatabase(mongoDatabaseName);
        ff4j.setFeatureStore(new FeatureStoreMongo(mongoDatabase.getCollection(MONGO_FEATURES_COLLECTION)));
        ff4j.setPropertiesStore(new PropertyStoreMongo(mongoDatabase.getCollection(MONGO_PROPERTIES_COLLECTION)));
        ff4j.setEventRepository(new EventRepositoryMongo(mongoDatabase.getCollection(MONGO_EVENTS_COLLECTION)));
    }
}