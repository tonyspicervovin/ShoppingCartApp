package ShoppingCartApp.controller;

import ShoppingCartApp.model.ShoppingItems;
import ShoppingCartApp.service.ShoppingCartService;
import ShoppingCartApp.view.Menu;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
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
                    itemList = service.getItemList();
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
        int deleteId = displayCartWithChoice(cartListIds, itemList);
        boolean isDeleted = service.deleteItem(deleteId);
        if (isDeleted) {
            message(itemList.get(deleteId).getName() + " was removed");
        }else {
            menu.showMessage("No item with that ID found");
        }
    }

    public void addItem(List<ShoppingItems> itemList) {
        HashMap<Integer, ShoppingItems> shoppingItemsHashMap = service.getHash();
        ArrayList<Integer> itemsChosen = displayItems(itemList);
        boolean isAdded = service.addItem(itemsChosen);
        if (isAdded) {
            for (int i = 0; i < itemsChosen.size(); i++) {
                menu.showMessage(shoppingItemsHashMap.get(itemsChosen.get(i)).getName() +  " added");
            }
        }else {
            menu.showMessage("Item/s not found");
        }
    }

    public int displayCartWithChoice(ArrayList<Integer> itemsIds, List<ShoppingItems> availableItems) {
        message("Cart Contents:");
        int itemChosen = menu.displayCartWithChoice(itemsIds, availableItems);
        if (itemsIds.size() == 0){
            menu.showMessage("Cart is empty");
        }
        return itemChosen;
    }
    public void displayCart(ArrayList<Integer> itemsIds, List<ShoppingItems> availableItems) {
        message("Cart Contents:");
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
    public ArrayList<Integer> displayItems(List<ShoppingItems> itemList) {
       return menu.addItem(itemList);
    }
}
