package br.com.next.templates.templateproject.usecase;

import br.com.next.templates.templateproject.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterProduct {

    private final InsertProduct insertProduct;
    private final ExposeProduct exposeProduct;

    public void execute(final Product product) {
        Product createdProduct = insertProduct.insert(product);
        exposeProduct.publish(createdProduct);
    }
}
