package main.java.ShoppingCartApp.controller;

import main.java.ShoppingCartApp.model.ShoppingItems;
import main.java.ShoppingCartApp.service.ShoppingCartService;
import main.java.ShoppingCartApp.view.Menu;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCartController {

    //initializing objects
    Menu menu = new Menu();
    //Build build = new Build();
    ShoppingCartService service = new ShoppingCartService();

    public void run() {

        boolean keepGoing = true;
        service.populateItems();
        while (keepGoing){
            int selection = menu.displayMenu();
            service.menuInput(selection);
            if (selection == 5){
                keepGoing = false;
            }
        }
    }

    public void displayCart(ArrayList<Integer> itemsIds, HashMap<Integer, ShoppingItems> availableItems) {
        message("Cart Contents");
        menu.displayCart(itemsIds, availableItems);
    }

    public void calculateTotal(ArrayList<Integer> itemIds, HashMap<Integer, ShoppingItems> itemList) {
        menu.calculateTotal(itemIds, itemList);
    }

    public ShoppingItems editItem(String oldItemName) {
        return menu.editItem(oldItemName);
    }

    public int getUserItem() {
        return menu.getUserItem();
    }

    public void message(String msg) {
        menu.showMessage(msg);
    }
    public int displayItems(HashMap<Integer, ShoppingItems> itemList) {
       return menu.displayItem(itemList);
    }
}
