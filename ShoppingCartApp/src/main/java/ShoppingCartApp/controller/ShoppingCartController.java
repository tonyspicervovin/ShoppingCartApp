package main.java.ShoppingCartApp.controller;

import main.java.ShoppingCartApp.model.ShoppingItems;
import main.java.ShoppingCartApp.service.ShoppingCartService;
import main.java.ShoppingCartApp.view.Build;
import main.java.ShoppingCartApp.view.Menu;

import java.util.ArrayList;

public class ShoppingCartController {

    Menu menu = new Menu();
    Build build = new Build();
    ShoppingCartService service = new ShoppingCartService();

    public void run() {
        while (true){
            int selection = menu.displayMenu();
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

    public void displayItem(ArrayList<ShoppingItems> items) {
        menu.displayItems(items);
    }

    public void calculateTotal(ArrayList<ShoppingItems> items) {
        menu.calculateTotal(items);
    }

    public ShoppingItems editItem(String oldItemName) {
        return menu.editItem(oldItemName);
    }

    public int getUserItem(ArrayList<ShoppingItems> itemList) {
        return menu.getUserItem(itemList);
    }

    public void message(String msg) {
        menu.showMessage(msg);
    }
}
