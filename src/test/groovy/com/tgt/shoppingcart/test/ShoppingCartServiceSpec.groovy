package com.tgt.shoppingcart.test
import ShoppingCartApp.dao.ShoppingCartDAOImpl
import ShoppingCartApp.model.ShoppingItems
import ShoppingCartApp.service.ShoppingCartService
import spock.lang.Specification

class ShoppingCartServiceSpec extends Specification {

    ShoppingCartDAOImpl shoppingCartDAOImpl = Mock(ShoppingCartDAOImpl)
    ShoppingCartService shoppingCartService = new ShoppingCartService(shoppingCartDAOImpl)

    def 'hello world'() {
        given:
        def i = 4

        expect:
        i % 2 == 0
    }

    def 'test item added' () {
        when:
        def isAdded = shoppingCartService.addItem([2] as ArrayList<Integer>)

        then:
        0*_

        1* shoppingCartDAOImpl.getHash()>>[2:new ShoppingItems("milk",2.5,2)]

        1* shoppingCartDAOImpl.addItem(_)
        isAdded == true
    }

    def 'test delete item' () {

        when:
        def isAdded = shoppingCartService.addItem([2] as ArrayList<Integer>)
        def isDeleted = shoppingCartService.deleteItem(2)

        then:
        1* shoppingCartDAOImpl.getHash()>>[2:new ShoppingItems("milk",2.5,2)]
        1* shoppingCartDAOImpl.addItem(_)
        shoppingCartDAOImpl.deleteItem()>> true
        isDeleted == true

    }
}