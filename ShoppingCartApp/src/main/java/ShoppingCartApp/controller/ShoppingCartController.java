package main.java.ShoppingCartApp.controller;

import main.java.ShoppingCartApp.model.ShoppingItems;
import main.java.ShoppingCartApp.service.ShoppingCartService;
import main.java.ShoppingCartApp.view.Build;
import main.java.ShoppingCartApp.view.Menu;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCartController {

    Menu menu = new Menu();
    Build build = new Build();
    ShoppingCartService service = new ShoppingCartService();

    public void run() {
        while (true){
            //populate data
            service.populateItems();
            //display menu
            int selection = menu.displayMenu();
            //get user input
            service.menuInput(selection);
            if (selection == 6){
                break;
            }
        }
    }

    public ShoppingItems buildItem(){
        ShoppingItems item = build.UserInputBuildItem();
        return item;
    }

    public void displayCart(ArrayList<Integer> itemsIds, HashMap<Integer, ShoppingItems> availableItems) {
        menu.displayCart(itemsIds, availableItems);
    }

    public void calculateTotal(ArrayList<Integer> items) {
        menu.calculateTotal(items);
    }

    public ShoppingItems editItem(String oldItemName) {
        return menu.editItem(oldItemName);
    }

    public int getUserItem(ArrayList<Integer> itemList) {
        return menu.getUserItem(itemList);
    }

    public void message(String msg) {
        menu.showMessage(msg);
    }
    public int displayItems(HashMap<Integer, ShoppingItems> itemList) {
       return menu.displayItem(itemList);
    }
}
