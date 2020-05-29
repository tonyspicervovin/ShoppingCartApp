package ShoppingCartApp.view;

import ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public int displayMenu() {
        int selection = 0;
        boolean stillGoing = true;
        do {
            try {
                System.out.println("***Shopping Cart Application*** \n1.Add item to cart\n2.Delete item\n3.Display cart\n4.Calculate Total\n5.Exit");
                System.out.println("Enter a selection 1-5");
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                selection = myObj.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter an integer");
                continue;
            }
            if (selection >= 1 && selection <= 6) {
                break;
            }
        }
        while (stillGoing);
        return selection;
    }
    public int displayCartWithChoice(ArrayList<Integer> itemsId, List<ShoppingItems> availableItems) {
        int itemChosen = 0;
        boolean stillGoing = true;
        Scanner myObj = new Scanner(System.in);
        while (stillGoing) {
            try {
                for (Integer id : itemsId) {   // printing each shopping item
                    ShoppingItems item = availableItems.get(id);
                    System.out.println(String.format("id: %d name: %s price: %.2f", id, item.getName(), item.getPrice()));
                }
                System.out.println("Enter the id of the item you would like to delete");
                itemChosen = myObj.nextInt();
                stillGoing = false;
            }catch (Exception e){
                System.out.println("Please an integer " + e.getMessage());
                String nada = myObj.nextLine();
            }
        }
        return itemChosen;
    }
    public void displayCart(ArrayList<Integer> itemsId, List<ShoppingItems> availableItems){

        for (Integer id : itemsId) {   // printing each shopping item
            ShoppingItems item = availableItems.get(id-1);
            System.out.println(String.format("id: %d name: %s price: %.2f", id, item.getName(), item.getPrice()));
        }
    }

    public void calculateTotal(ArrayList<Integer> itemIds, List<ShoppingItems> itemList) {
        //calculating total price for items in cart
        double cartTotal = 0;
        for(Integer id : itemIds) {
            cartTotal = cartTotal + (itemList.get(id).getPrice());
        }
        System.out.println(String.format("Order total: %.2f$", cartTotal));
    }
    public ArrayList<Integer> addItem(List<ShoppingItems> itemList) {
        ArrayList<Integer> itemIdList = new ArrayList<>();
        //displaying available items and asking user which they would like to add
        boolean stillGoing = true;
        Scanner myObj = new Scanner(System.in);
        int itemChosen = 1;
        for (ShoppingItems item : itemList) {
            System.out.println(item.toString());
        }
        while (stillGoing) {
            try {
                System.out.println("Enter the ids of the items you would like to add to cart, enter 0 to exit");
                while (itemChosen != 0) {
                    itemChosen = myObj.nextInt();
                    if(itemChosen != 0){
                        itemIdList.add(itemChosen);
                    }
                }
                stillGoing = false;
            }catch (Exception e){
                System.out.println("Please an integer " + e.getMessage());
                String nada = myObj.nextLine();
            }
        }
        return itemIdList;
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}