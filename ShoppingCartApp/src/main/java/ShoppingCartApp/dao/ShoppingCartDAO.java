package main.java.ShoppingCartApp.dao;

import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCartDAO {
    //initializing list for shopping item ids, this is the users cart
    public ArrayList<Integer> cartList = new ArrayList<>();
    //initializing map for available items, this is what the user has to choose from
    HashMap<Integer, ShoppingItems> itemList = new HashMap<>();

    public void populateMap() {
        //creating our shopping objects and populating map
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

    public void addItem(int itemId) {
        //adding an item to cart by id
        cartList.add(itemId);
    }

    public boolean deleteItem(Integer itemId) {
        //deleting an item from cart by id
        return cartList.remove(itemId);

    }

    public ArrayList<Integer> cartList() {
        //returning list of item ids in user cart
        return cartList;
    }
    public HashMap<Integer, ShoppingItems> itemList() {
        //returning list of available items
        return itemList;
    }

    public void updateItem(ShoppingItems newItem, ShoppingItems oldItem) {
        //unused method for future implementation
        oldItem.setPrice(newItem.getPrice());
        oldItem.setQty(newItem.getQty());
    }
}
