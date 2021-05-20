package br.com.next.templates.templateproject.external.data.impl;

import br.com.next.templates.templateproject.entity.Product;
import br.com.next.templates.templateproject.external.data.ListProducts;
import br.com.next.templates.templateproject.external.data.adapter.ProductModelAdapter;
import br.com.next.templates.templateproject.external.data.repository.ProductRepository;
import com.microsoft.azure.spring.cloud.feature.manager.FeatureManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ListProductsImpl implements ListProducts {

    private final ProductRepository productRepository;
    private final FeatureManager featureManager;

    @Override
    public List<Product> execute() {
        List<Product> products = productRepository.findAll().stream()
                .map(ProductModelAdapter::toEntity)
                .collect(Collectors.toList());
        if (featureManager.isEnabledAsync("show-new-product").block()) {
            products.add(Product.builder()
                    .id(2L)
                    .name("produto 2")
                    .quantity(200)
                    .build());
        }
        return products;
    }
}
