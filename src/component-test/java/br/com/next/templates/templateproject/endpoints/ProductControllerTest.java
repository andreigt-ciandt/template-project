package br.com.next.templates.templateproject.endpoints;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testGetProductsWillReturnProducts() {
        RestAssuredMockMvc.
                given()
                .webAppContextSetup(webApplicationContext)
                .when()
                .get("/products/")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .body("id", contains(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13))
                .body("name", hasItems("teste produto", "teste produto 2", "teste produto 3"))
                .body("quantity", hasItems(100));
    }

    @Test
    public void testGetProductsWillReturnPayloadWithValidSchema() {
        RestAssuredMockMvc.
                given()
                .webAppContextSetup(webApplicationContext)
                .when()
                .get("/products/")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema/get-products-schema.json"));
    }
}
