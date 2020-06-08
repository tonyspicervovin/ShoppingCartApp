package com.tgt.shoppingcart.test

import ShoppingCartApp.dao.ShoppingCartDAOImpl
import spock.lang.Specification

class ShoppingCartDaoImplSpec extends Specification{

    ShoppingCartDAOImpl shoppingCartDAOImpl =  new ShoppingCartDAOImpl()

    def 'test add item' () {

        when:
        shoppingCartDAOImpl.addItem(2)

        then:
        shoppingCartDAOImpl.cartList().contains(2)

    }

    def 'test delete item' () {

        when:
        shoppingCartDAOImpl.addItem(2)

        def isDeleted = shoppingCartDAOImpl.deleteItem(2)

        then:
        isDeleted == true
    }
}
