package main.java.ShoppingCartApp.controller;

import main.java.ShoppingCartApp.model.ShoppingItems;
import main.java.ShoppingCartApp.service.ShoppingCartService;
import main.java.ShoppingCartApp.view.Menu;

import java.util.ArrayList;
import java.util.List;

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

    public ShoppingItems editItem(String oldItemName) {
        return menu.editItem(oldItemName);
    }

    public int getUserItem() {
        return menu.getUserItem();
    }

    public void message(String msg) {
        menu.showMessage(msg);
    }
    public int displayItems(List<ShoppingItems> itemList) {
       return menu.displayItem(itemList);
    }
}
