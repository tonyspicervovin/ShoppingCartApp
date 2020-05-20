package main.java.ShoppingCartApp.service;

import main.java.ShoppingCartApp.controller.ShoppingCartController;
import main.java.ShoppingCartApp.dao.ShoppingCartDAO;
import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;

public class ShoppingCartService {


    ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();

    public void menuInput(int selection) {

        ShoppingCartController shoppingCartController = new ShoppingCartController();
        ArrayList<ShoppingItems> itemList = shoppingCartDAO.itemList();


        switch(selection) {
            case 1:
                ShoppingItems item = shoppingCartController.buildItem();
                shoppingCartDAO.addItem(item);
                break;
            case 2:
                deleteItem(shoppingCartController);
                break;
            case 3:
                shoppingCartController.displayItem(itemList);
                break;
            case 4:
                shoppingCartController.calculateTotal(itemList);
                break;
            case 5:
                editItem(shoppingCartController);
                break;
            case 6:
                shoppingCartController.message("Goodbye");
                break;
        }
    }
    protected void editItem(ShoppingCartController shoppingCartController) {
        ArrayList<ShoppingItems> itemList = shoppingCartDAO.itemList();
        int itemId = shoppingCartController.getUserItem(itemList);
        if (itemList.size() != 0) {
            ShoppingItems oldItem = matchItem(itemId);
            ShoppingItems newItem = shoppingCartController.editItem(oldItem.getName());
            shoppingCartDAO.updateItem(newItem, oldItem);
        }

    }

    protected void deleteItem(ShoppingCartController shoppingCartController) {
        ArrayList<ShoppingItems> itemList = shoppingCartDAO.itemList();
        int itemId = shoppingCartController.getUserItem(itemList);
        ShoppingItems item = matchItem(itemId);
        shoppingCartDAO.deleteItem(item);
    }

    private ShoppingItems matchItem(int itemId) {
        ArrayList<ShoppingItems> itemList = shoppingCartDAO.itemList();
        for (int i = 0; i < itemList.size(); i++) {//looping through items, if item id matches we remove it and let user know if deleted or not found
            if (itemList.get(i).getId() == itemId) {
                return itemList.get(i);
            }
        }
    return null;
    }
    public void populateItems(){
        shoppingCartDAO.populateMap();
    }
}
