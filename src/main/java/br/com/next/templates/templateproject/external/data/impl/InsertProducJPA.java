package br.com.next.templates.templateproject.external.data.impl;

import br.com.next.templates.templateproject.entity.Product;
import br.com.next.templates.templateproject.external.data.adapter.ProductModelAdapter;
import br.com.next.templates.templateproject.external.data.entity.ProductModel;
import br.com.next.templates.templateproject.external.data.repository.ProductRepository;
import br.com.next.templates.templateproject.usecase.InsertProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertProducJPA implements InsertProduct {

    private final ProductRepository productRepository;

    @Override
    public Product insert(Product product) {
        ProductModel productModel = ProductModel.builder()
                .name(product.getName())
                .quantity(product.getQuantity())
                .build();
        ProductModel model = productRepository.save(productModel);
        return ProductModelAdapter.toEntity(model);
    }
}
