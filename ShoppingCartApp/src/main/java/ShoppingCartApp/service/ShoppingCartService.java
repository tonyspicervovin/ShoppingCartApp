package main.java.ShoppingCartApp.service;

import main.java.ShoppingCartApp.controller.ShoppingCartController;
import main.java.ShoppingCartApp.dao.ShoppingCartDAO;
import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCartService {


    ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
    ArrayList<Integer> cartListIds = shoppingCartDAO.cartList();
    HashMap<Integer, ShoppingItems> itemList =  shoppingCartDAO.itemList();

    public void menuInput(int selection) {

        ShoppingCartController shoppingCartController = new ShoppingCartController();

        switch(selection) {
            case 1:
                addItem(shoppingCartController);
                break;
            case 2:
                deleteItem(shoppingCartController);
                break;
            case 3:
                shoppingCartController.displayCart(cartListIds, itemList);
                break;
            case 4:
                shoppingCartController.calculateTotal(cartListIds);
                break;
            case 5:
                editItem(shoppingCartController);
                break;
            case 6:
                shoppingCartController.message("Goodbye");
                break;
        }
    }

    protected void addItem(ShoppingCartController shoppingCartController) {
        int itemChosen = shoppingCartController.displayItems(itemList);
        boolean added = shoppingCartDAO.addItem(itemChosen);
        if (added) {
            shoppingCartController.message(itemList.get(itemChosen).getName() + " added");
        }else{
            shoppingCartController.message("Item not added");
        }
    }

    protected void editItem(ShoppingCartController shoppingCartController) {
        /*ArrayList<Integer> itemList = shoppingCartDAO.cartList();
        int itemId = shoppingCartController.getUserItem(itemList);
        if (itemList.size() != 0) {
            ShoppingItems oldItem = matchItem(itemId);
            ShoppingItems newItem = shoppingCartController.editItem(oldItem.getName());
            shoppingCartDAO.updateItem(newItem, oldItem);
        }
*/
    }

    protected void deleteItem(ShoppingCartController shoppingCartController) {
        shoppingCartController.displayCart(cartListIds, itemList);
        int deleteId = shoppingCartController.getUserItem();
        System.out.println(deleteId);
        boolean isDeleted = shoppingCartDAO.deleteItem(deleteId);
        if(isDeleted) {
            shoppingCartController.message(itemList.get(deleteId).getName() + " was removed");
        }else {
            shoppingCartController.message("No item with that ID found");
        }
        /*ArrayList<Integer> itemList = shoppingCartDAO.cartList();
        int itemId = shoppingCartController.getUserItem(itemList);
        Integer item = matchItem(itemId);
        shoppingCartDAO.deleteItem(item);*/
    }

    private Integer matchItem(int itemId) {
       /* ArrayList<Integer> itemList = shoppingCartDAO.cartList();
        for (int i = 0; i < itemList.size(); i++) {//looping through items, if item id matches we remove it and let user know if deleted or not found
            if (itemList.get(i).getId() == itemId) {
                return itemList.get(i);
            }
        }*/
    return null;
    }
    public void populateItems(){
        shoppingCartDAO.populateMap();
    }
}
