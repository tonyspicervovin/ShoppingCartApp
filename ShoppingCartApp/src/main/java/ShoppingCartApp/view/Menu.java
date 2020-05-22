package main.java.ShoppingCartApp.view;

import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public int displayMenu() {
        int selection;
        while (true) {
            //Printing menu for application, scanning user input and verifying it's an int 1-5
            try {
                System.out.println("***Shopping Cart Application*** \n1.Add item \n2.Delete item\n3.Display cart\n4.Calculate Total\n5.Exit");
                System.out.println("Enter a selection 1-5");
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                selection = myObj.nextInt();
            } catch (Exception e) {
                System.out.println("Please make a selection 1-5");
                continue;
            }
            if (selection >= 1 && selection <= 6) {
                return selection;
            }
        }
    }

    public void displayCart(ArrayList<Integer> itemsId, List<ShoppingItems> availableItems) {

        for (Integer id : itemsId) {   // printing each shopping item
            ShoppingItems item = availableItems.get(id);
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

    public ShoppingItems editItem(String oldItemName) {
        //unused method for future implementation
        /*Scanner myObj = new Scanner(System.in);
        double price;
        int qty;
        System.out.println("Enter a new price for " + oldItemName);
        while (true) {
            try {
                price = myObj.nextDouble();
                System.out.println("Enter a new qty for " + oldItemName);
                qty = myObj.nextInt();
                return new ShoppingItems(oldItemName, price);
            } catch (Exception e) {
                System.out.println("Please enter a price/qty");
                String nada = myObj.nextLine();
            }
        }*/
        return null;
    }
    public int displayItem(List<ShoppingItems> itemList) {
        //displaying available items and asking user which they would like to add
        System.out.println("Enter the id of the item you would like");
        Scanner myObj = new Scanner(System.in);
        int itemChosen = 0;
        for (ShoppingItems item : itemList) {
            System.out.println(item.toString());
        }
        while (true) {
            try {
                itemChosen = myObj.nextInt();
                itemChosen = myObj.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Please an integer");
            }
        }
        return itemChosen;
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}