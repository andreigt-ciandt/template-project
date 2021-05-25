package br.com.next.templates.templateproject.entity

import spock.lang.Specification

class ProductSpec extends Specification {

    def "create a product"() {
        given: "a name and quantity"
        def id = 1L
        def name = "teste"
        def quantity = 100

        when: "a new product is created"
        def product = new Product(id, name, quantity)

        then: "the values are all set"
        product.name == name
        product.quantity == quantity
    }

}
