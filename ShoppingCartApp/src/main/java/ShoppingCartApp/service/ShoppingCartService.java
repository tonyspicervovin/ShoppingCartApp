package main.java.ShoppingCartApp.service;

import main.java.ShoppingCartApp.controller.ShoppingCartController;
import main.java.ShoppingCartApp.dao.ShoppingCartDAO;
import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;

public class ShoppingCartService {


    ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();

    public void menuInput(int selection){

        ShoppingCartController shoppingCartController = new ShoppingCartController();

        if (selection == 1) {
            ShoppingItems item = shoppingCartController.buildItem();
            shoppingCartDAO.addItem(item);
        }else if (selection == 2) {
            ArrayList<ShoppingItems> itemList = shoppingCartDAO.ItemList();
            int itemId = shoppingCartController.getUserItem(itemList);
            ShoppingItems item = matchItem(itemId);
            shoppingCartDAO.deleteItem(item);
        }else if (selection == 3) {
            ArrayList<ShoppingItems> itemList = shoppingCartDAO.ItemList();
            shoppingCartController.displayItem(itemList);
        }else if (selection == 4) {
            ArrayList<ShoppingItems> itemList = shoppingCartDAO.ItemList();
            shoppingCartController.calculateTotal(itemList);
        }else if (selection == 5) {
            ArrayList<ShoppingItems> itemList = shoppingCartDAO.ItemList();
            int itemId = shoppingCartController.getUserItem(itemList);
            ShoppingItems oldItem = matchItem(itemId);
            ShoppingItems newItem = shoppingCartController.editItem(oldItem.getName());
            shoppingCartDAO.updateItem(newItem, oldItem);
        } else if (selection == 6){

        }
    }

    private ShoppingItems matchItem(int itemId) {
        ArrayList<ShoppingItems> itemList = shoppingCartDAO.ItemList();
        for (int i = 0; i < itemList.size(); i++) {//looping through items, if item id matches we remove it and let user know if deleted or not found
            if (itemList.get(i).getId() == itemId) {
                return itemList.get(i);
            }
        }
    return null;
    }
}
