package main.java.ShoppingCartApp.dao;

import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ShoppingCartDAO {
    public void populateMap();
    public void addItem(int itemId);
    public boolean deleteItem(Integer itemId);
    public ArrayList<Integer> cartList();
    public List<ShoppingItems> getAllItems();
    public HashMap<Integer, ShoppingItems> getHash();
}
