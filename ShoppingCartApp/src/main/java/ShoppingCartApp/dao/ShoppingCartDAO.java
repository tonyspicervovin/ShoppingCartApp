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

        itemList.put(1, createItem("bread", 1, 3.50));
        itemList.put(2, createItem("milk", 2, 2.50));
        itemList.put(3, createItem("eggs", 3, 4.50));
        itemList.put(4, createItem("banana", 4, 3.50));
        itemList.put(5, createItem("grapes", 5, 3.50));
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
        ArrayList<ShoppingItems> items = itemList.;
        return itemList.values();
    }

    public void updateItem(ShoppingItems newItem, ShoppingItems oldItem) {
        //unused method for future implementation
        oldItem.setPrice(newItem.getPrice());
        oldItem.setQty(newItem.getQty());
    }

    private ShoppingItems createItem(String itemName, int id, double price) {
        ShoppingItems item = new ShoppingItems();
        item.setName(itemName);
        item.setId(id);
        item.setPrice(price);
        return item;
    }
}
