package br.com.next.templates.templateproject.external.data.adapter;

import br.com.next.templates.templateproject.entity.Product;
import br.com.next.templates.templateproject.external.data.entity.ProductModel;

public class ProductModelAdapter {

    public static Product toEntity(final ProductModel productModel) {
        return Product.builder()
                .id(productModel.getId())
                .name(productModel.getName())
                .quantity(productModel.getQuantity())
                .build();
    }

}
