package br.com.next.templates.templateproject.external.data.adapter

import br.com.next.templates.templateproject.external.data.entity.ProductModel
import spock.lang.Specification

class ProductModelAdapterTest extends Specification {

    def "should create a product from a model"() {
        given: "a product model"
        def productModel = new ProductModel()
        productModel.with {
            id = 1
            name = "product test"
            quantity = 100
        }

        when: "is adpated to entity"
        def product = ProductModelAdapter.toEntity(productModel)

        then: "a valid product is created"
        product != null
        product.id == productModel.id
        product.name == productModel.name
        product.quantity == productModel.quantity
    }

}
