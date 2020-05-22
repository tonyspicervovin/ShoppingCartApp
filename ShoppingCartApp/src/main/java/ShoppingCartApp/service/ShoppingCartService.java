package main.java.ShoppingCartApp.service;

import main.java.ShoppingCartApp.dao.ShoppingCartDAO;
import main.java.ShoppingCartApp.dao.ShoppingCartDAOImpl;
import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCartService {

    ShoppingCartDAO shoppingCartDAOImpl = new ShoppingCartDAOImpl();

    public boolean addItem(int itemChosen) {

        HashMap<Integer, ShoppingItems> itemMap = shoppingCartDAOImpl.getHash();
        boolean isAdded = false;
        if(itemMap.containsKey(itemChosen)) {
            shoppingCartDAOImpl.addItem(itemChosen);
            isAdded = true;
        }
        return isAdded;
    }

    public boolean deleteItem(int deleteId) {

        //deleting item from cart by id, return true if it was deleted and displaying relevant information to the user
        boolean isDeleted = shoppingCartDAOImpl.deleteItem(deleteId);
        return isDeleted;
    }
    public List<ShoppingItems> getItemList() {
        return shoppingCartDAOImpl.getAllItems();
    }

    public ArrayList<Integer> getCartList() {
        return shoppingCartDAOImpl.cartList();
    }

    public HashMap<Integer,ShoppingItems> getHash() {
        return shoppingCartDAOImpl.getHash();
    }

    public void populateItems(){
        //populating data for available items
        shoppingCartDAOImpl.populateMap();
    }
}
