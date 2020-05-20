package main.java.ShoppingCartApp.dao;

import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCartDAO {
    //initializing list for shopping item objects
    public ArrayList<ShoppingItems> cartList = new ArrayList<>();

    HashMap<Integer, ShoppingItems> itemList = new HashMap<>();

    public void populateMap() {
        ShoppingItems bread = new ShoppingItems("bread", 3.99);
        ShoppingItems milk = new ShoppingItems("milk", 2.49);
        ShoppingItems eggs = new ShoppingItems("eggs", 4.50);
        itemList.put(1, bread);
        itemList.put(2, milk);
        itemList.put(3, eggs);
        System.out.println("data is populated");
    }

    public void addItem(ShoppingItems item) {
        try{
            cartList.add(item);
        }catch (Exception e ){
        }
    }

    public void deleteItem(ShoppingItems item) {
        cartList.remove(item);
    }

    public ArrayList<ShoppingItems> cartList() {
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
