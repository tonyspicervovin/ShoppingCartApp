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
        while (true){
            //populate data
            service.populateItems();
            //display menu
            int selection = menu.displayMenu();
            //get user input
            service.menuInput(selection);
            //end program when user chooses 5
            if (selection == 5){
                break;
            }
        }
    }

    //methods to relay from service to view
    public void buildItem(){
        /*ShoppingItems item = build.UserInputBuildItem();
        return item;*/

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
