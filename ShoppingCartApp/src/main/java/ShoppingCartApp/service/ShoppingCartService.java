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
                shoppingCartController.calculateTotal(cartListIds, itemList);
                break;
            case 5:
                shoppingCartController.message("Goodbye");
                break;
        }
    }

    protected void addItem(ShoppingCartController shoppingCartController) {

        int itemChosen = shoppingCartController.displayItems(itemList);
        if (itemList.containsKey(itemChosen)){
            shoppingCartDAO.addItem(itemChosen);
            shoppingCartController.message(itemList.get(itemChosen).getName() + " added");
        }else {
            shoppingCartController.message("Item with id: " + itemChosen + " not found");
        }
    }

    protected void editItem(ShoppingCartController shoppingCartController) {
        //unused method for future implementation

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

        //showing user items in their cart
        shoppingCartController.displayCart(cartListIds, itemList);
        //getting user input for which item they want to delete, by id
        int deleteId = shoppingCartController.getUserItem();
        //deleting item from cart by id, return true if it was deleted and displaying relevant information to the user
        boolean isDeleted = shoppingCartDAO.deleteItem(deleteId);
        if(isDeleted) {
            shoppingCartController.message(itemList.get(deleteId).getName() + " was removed");
        }else {
            shoppingCartController.message("No item with that ID found");
        }
    }

    public void populateItems(){
        //populating data for available items
        shoppingCartDAO.populateMap();
    }
}
