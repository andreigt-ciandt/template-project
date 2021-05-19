package br.com.next.templates.templateproject.endpoints;

import br.com.next.templates.templateproject.entity.Product;
import br.com.next.templates.templateproject.external.data.ListProducts;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ListProducts listProducts;

    @GetMapping("/")
    public List<Product> allProducts() {
        return listProducts.execute();
    }
}
