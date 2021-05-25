package br.com.next.templates.templateproject.endpoints;

import br.com.next.templates.templateproject.entity.Product;
import br.com.next.templates.templateproject.usecase.ListProducts;
import br.com.next.templates.templateproject.usecase.RegisterProduct;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;

public class ProductControllerTest {
    private final ListProducts listProducts = Mockito.mock(ListProducts.class);
    private final RegisterProduct registerProduct = Mockito.mock(RegisterProduct.class);
    private ProductController controller;

    @Before
    public void init() {
        this.controller = new ProductController(listProducts, registerProduct);
    }

    @Test
    public void testAllProductsWithProductsWillSuccessfully() {
        List<Product> productList = Arrays.asList(
                Product.builder()
                        .id(1L)
                        .name("product 1 name")
                        .quantity(3)
                        .build(),
                Product.builder()
                        .id(2L)
                        .name("product 2 name")
                        .quantity(2)
                        .build());
        Mockito.when(listProducts.execute()).thenReturn(productList);

        RestAssuredMockMvc.
                given()
                .standaloneSetup(controller)
                .when()
                .get("/products/")
                .then()
                .assertThat()
                .statusCode(200)
                .body("id", hasItems(1, 2))
                .body("name", hasItems("product 1 name", "product 2 name"))
                .body("quantity", hasItems(3, 2));
    }
}
