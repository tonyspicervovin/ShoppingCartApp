package main.java.ShoppingCartApp.service;

import main.java.ShoppingCartApp.controller.ShoppingCartController;
import main.java.ShoppingCartApp.dao.ShoppingCartDAO;
import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartService {


    ShoppingCartDAO     shoppingCartDAO = new ShoppingCartDAO();

    public void menuInput(int selection) {

        List<ShoppingItems> itemList =  shoppingCartDAO.getAllItems();
        ArrayList<Integer>  cartListIds = shoppingCartDAO.cartList();

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

        List<ShoppingItems> itemList =  shoppingCartDAO.getAllItems();
        int itemChosen = shoppingCartController.displayItems(itemList);
        shoppingCartDAO.addItem(itemChosen);
        shoppingCartController.message(itemList.get(itemChosen -1).getName() + " added");
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
        List<ShoppingItems> itemList =  shoppingCartDAO.getAllItems();
        ArrayList<Integer>  cartListIds = shoppingCartDAO.cartList();
        //showing user items in their cart
        shoppingCartController.displayCart(cartListIds, itemList);
        //getting user input for which item they want to delete, by id
        int deleteId = shoppingCartController.getUserItem();
        System.out.println(deleteId);
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
