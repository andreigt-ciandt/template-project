package br.com.next.templates.templateproject.usecase;

import br.com.next.templates.templateproject.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterProduct {

    private final InsertProduct insertProduct;

    public void execute(final Product product) {
        insertProduct.insert(product);
    }
}
