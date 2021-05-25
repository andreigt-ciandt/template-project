package br.com.next.templates.templateproject.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(ApplicationClients.class)
public class AuthenticationManagerConfig extends GlobalAuthenticationConfigurerAdapter {

    private static final int BCRYPT_ROUNDS = 4;

    private final ApplicationClients application;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        for (ApplicationClient client : application.getClients()) {
            auth.inMemoryAuthentication()
                    .withUser(client.getUsername())
                    .password(passwordEncoder().encode(client.getPassword()))
                    .roles(client.getRoles());
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(BCRYPT_ROUNDS);
    }
}