package ShoppingCartApp.dao;

import ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCartDAOImpl2 implements ShoppingCartDAO {

    @Override
    public void populateMap() {
        System.out.println("I am running from 2nd implementation");
    }

    @Override
    public void addItem(int itemId) {

    }

    @Override
    public boolean deleteItem(Integer itemId) {
        return false;
    }

    @Override
    public ArrayList<Integer> cartList() {
        return null;
    }

    @Override
    public List<ShoppingItems> getAllItems() {
        return null;
    }

    @Override
    public HashMap<Integer, ShoppingItems> getHash() {
        return null;
    }
}
