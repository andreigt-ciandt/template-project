package br.com.next.templates.templateproject.external.message.dto;

import br.com.next.templates.templateproject.entity.Product;

public class ProductDtoAdapter {

    public static ProductDto fromEntity(final Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .quantity(product.getQuantity())
                .build();
    }

}
