package br.com.next.templates.templateproject.endpoints;

import br.com.next.templates.templateproject.entity.Product;
import br.com.next.templates.templateproject.usecase.ListProducts;
import br.com.next.templates.templateproject.usecase.RegisterProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ListProducts listProducts;
    private final RegisterProduct registerProduct;

    @GetMapping("/")
    public List<Product> allProducts() {
        return listProducts.execute();
    }

    @PostMapping("/")
    public ResponseEntity registerProduct(@RequestBody Product product) {
        registerProduct.execute(product);
        return  ResponseEntity.created(URI.create("http://localhost:8080/products/")).build();
    }
}


