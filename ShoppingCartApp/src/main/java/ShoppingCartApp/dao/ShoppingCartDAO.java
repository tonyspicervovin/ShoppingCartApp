package main.java.ShoppingCartApp.dao;

import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCartDAO {
    //initializing list for shopping item objects
    public ArrayList<Integer> cartList = new ArrayList<>();

    HashMap<Integer, ShoppingItems> itemList = new HashMap<>();

    public void populateMap() {
        ShoppingItems bread = new ShoppingItems("bread", 3.99);
        ShoppingItems milk = new ShoppingItems("milk", 2.49);
        ShoppingItems eggs = new ShoppingItems("eggs", 4.50);
        ShoppingItems pasta = new ShoppingItems("pasta", 2.25);
        ShoppingItems grapes = new ShoppingItems("grapes", 3.49);

        itemList.put(1, bread);
        itemList.put(2, milk);
        itemList.put(3, eggs);
        itemList.put(4, pasta);
        itemList.put(5,grapes);
    }

    public boolean addItem(int item) {
        try{
            cartList.add(item);
            return true;
        }catch (Exception e ){
            return false;
        }
    }

    public boolean deleteItem(Integer itemId) {

        return cartList.remove(itemId);

    }

    public ArrayList<Integer> cartList() {
        return cartList;
    }
    public HashMap<Integer, ShoppingItems> itemList() {
        return itemList;
    }

    public void updateItem(ShoppingItems newItem, ShoppingItems oldItem) {
        oldItem.setPrice(newItem.getPrice());
        oldItem.setQty(newItem.getQty());
    }
}
