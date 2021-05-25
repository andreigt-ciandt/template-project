package br.com.next.templates.templateproject;

import br.com.next.templates.templateproject.entity.Product;
import br.com.next.templates.templateproject.usecase.ListProducts;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TemplateProjectApplicationTests {

	@Autowired
	ListProducts listProducts;

	@Test
	void contextLoads() {
	}

	@Test
	void fetchProductsFromDatabase() {
		List<Product> products =  listProducts.execute();
		Assert.assertNotNull(products);
	}

}
