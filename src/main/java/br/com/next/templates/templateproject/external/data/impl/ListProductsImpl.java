package br.com.next.templates.templateproject.external.data.impl;

import br.com.next.templates.templateproject.entity.Product;
import br.com.next.templates.templateproject.external.data.ListProducts;
import br.com.next.templates.templateproject.external.data.adapter.ProductModelAdapter;
import br.com.next.templates.templateproject.external.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ListProductsImpl implements ListProducts {

    private final ProductRepository productRepository;

    @Override
    public List<Product> execute() {
        return productRepository.findAll().stream()
                .map(ProductModelAdapter::toEntity)
                .collect(Collectors.toList());
    }
}
