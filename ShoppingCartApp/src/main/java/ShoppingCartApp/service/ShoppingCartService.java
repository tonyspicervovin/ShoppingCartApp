package main.java.ShoppingCartApp.service;

import main.java.ShoppingCartApp.controller.ShoppingCartController;
import main.java.ShoppingCartApp.dao.ShoppingCartDAO;
import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCartService {

    ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();

    public boolean addItem(int itemChosen) {
        HashMap<Integer, ShoppingItems> itemMap = shoppingCartDAO.getHash();
        boolean isAdded = false;
        if(itemMap.containsKey(itemChosen)) {
            shoppingCartDAO.addItem(itemChosen);
            isAdded = true;
        }
        return isAdded;
    }

    public void editItem(ShoppingCartController shoppingCartController) {
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

    public boolean deleteItem(int deleteId) {

        //deleting item from cart by id, return true if it was deleted and displaying relevant information to the user
        boolean isDeleted = shoppingCartDAO.deleteItem(deleteId);
        return isDeleted;
    }
    public List<ShoppingItems> getItemList() {
        return shoppingCartDAO.getAllItems();
    }

    public ArrayList<Integer> getCartList() {
        return shoppingCartDAO.cartList;
    }

    public HashMap<Integer,ShoppingItems> getHash() {
        return shoppingCartDAO.getHash();
    }

    public void populateItems(){
        //populating data for available items
        shoppingCartDAO.populateMap();
    }
}
