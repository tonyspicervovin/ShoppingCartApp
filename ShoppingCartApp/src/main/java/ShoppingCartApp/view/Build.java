package main.java.ShoppingCartApp.view;

import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.Scanner;

public class Build {

    public ShoppingItems UserInputBuildItem() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String itemName;
        double price;
        int qty;
        String nada;
        while(true) {
            try {
                // Read user input
                System.out.println("Enter item name");
                itemName = myObj.nextLine();
                System.out.println("Enter item price");
                price = myObj.nextDouble();
                System.out.println("Enter item qty");
                qty = myObj.nextInt();
                return new ShoppingItems(itemName, price, qty);
            } catch (Exception e) {
                nada = myObj.nextLine(); // just to clear the non read qty, not used
                System.out.println("Please enter a name, price and qty");
            }
        }
    }
}
