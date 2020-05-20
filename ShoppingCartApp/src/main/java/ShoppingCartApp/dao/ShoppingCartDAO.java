package main.java.ShoppingCartApp.dao;

import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;

public class ShoppingCartDAO {
    //initializing list for shopping item objects
    public ArrayList<ShoppingItems> itemList = new ArrayList<>();

    public void addItem(ShoppingItems item) {
        try{
            itemList.add(item);
        }catch (Exception e ){
        }
    }

    public void deleteItem(ShoppingItems item) {
        itemList.remove(item);
    }

    public ArrayList<ShoppingItems> itemList() {
        return itemList;
    }

    public void updateItem(ShoppingItems newItem, ShoppingItems oldItem) {
        oldItem.setPrice(newItem.getPrice());
        oldItem.setQty(newItem.getQty());
    }
}
