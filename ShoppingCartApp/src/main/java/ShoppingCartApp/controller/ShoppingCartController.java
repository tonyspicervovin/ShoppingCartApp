package main.java.ShoppingCartApp.controller;

import main.java.ShoppingCartApp.model.ShoppingItems;
import main.java.ShoppingCartApp.service.ShoppingCartService;
import main.java.ShoppingCartApp.view.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCartController {

    //initializing objects
    Menu menu = new Menu();
    //Build build = new Build();
    ShoppingCartService service = new ShoppingCartService();

    public void run() {
        boolean keepGoing = true;
        service.populateItems();
        List<ShoppingItems> itemList = service.getItemList();

        while (keepGoing){
            int selection = menu.displayMenu();
            switch(selection) {
                case 1:
                    addItem(itemList);
                    break;
                case 2:
                    deleteItem(itemList);
                    break;
                case 3:
                    ArrayList<Integer> cartListIds = service.getCartList();
                    displayCart(cartListIds, itemList);
                    break;
                case 4:
                    cartListIds = service.getCartList();
                    calculateTotal(cartListIds, itemList);
                    break;
                case 5:
                    message("Goodbye");
                    break;
            }
            if (selection == 5){
                keepGoing = false;
            }
        }
    }

    private void deleteItem(List<ShoppingItems> itemList) {
        ArrayList<Integer>  cartListIds = service.getCartList();
        int deleteId = displayItems(itemList);
        boolean isDeleted = service.deleteItem(deleteId);
        if (isDeleted) {
            message(itemList.get(deleteId).getName() + " was removed");
        }else {
            System.out.println("No item with that ID found");
        }
    }

    public void addItem(List<ShoppingItems> itemList) {
        HashMap<Integer, ShoppingItems> shoppingItemsHashMap = service.getHash();
        int itemChosen = displayItems(itemList);
        boolean isAdded = service.addItem(itemChosen);
        if (isAdded) {
            menu.showMessage(shoppingItemsHashMap.get(itemChosen).getName() + " added");
        }else {
            menu.showMessage("Item not found");
        }
    }

    public void displayCart(ArrayList<Integer> itemsIds, List<ShoppingItems> availableItems) {
        message("Cart Contents");
        menu.displayCart(itemsIds, availableItems);
        if (itemsIds.size() == 0){
            menu.showMessage("Cart is empty");
        }
    }

    public void calculateTotal(ArrayList<Integer> itemIds, List<ShoppingItems> itemList) {
        menu.calculateTotal(itemIds, itemList);
    }
    public void message(String msg) {
        menu.showMessage(msg);
    }
    public int displayItems(List<ShoppingItems> itemList) {
       return menu.displayItem(itemList);
    }
}
