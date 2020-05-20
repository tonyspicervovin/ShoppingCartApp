package main.java.ShoppingCartApp.view;

import main.java.ShoppingCartApp.model.ShoppingItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    public int displayMenu() {
        int selection;
        while (true) {
            //Printing menu for application, scanning user input and verifying it's an int 1-5
            try {
                System.out.println("***Shopping Cart Application*** \n1.Add item \n2.Delete item\n3.Display cart\n4.Calculate Total\n5.Edit Item\n6.Exit");
                System.out.println("Enter a selection 1-6");
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                selection = myObj.nextInt();
            } catch (Exception e) {
                System.out.println("Please make a selection 1-6");
                continue;
            }
            if (selection >= 1 && selection <= 6) {
                return selection;
            }
        }
    }

    public void displayCart(ArrayList<ShoppingItems> items) {
        for (ShoppingItems item : items) {   // printing each shopping item
            System.out.println(String.format("id: %d name: %s price: %.2f qty: %d", item.getId(), item.getName(), item.getPrice(), item.getQty()));
        }
        if (items.size() == 0) {  //show user a message if no items are in list
            System.out.println("List is empty");
        }
    }

    public void calculateTotal(ArrayList<ShoppingItems> items) {
        double totalPrice = 0; //looping through list of objects and calculating total cost
        for (ShoppingItems x : items) {
            totalPrice = totalPrice + (x.getPrice() * x.getQty());
        }
        System.out.println(String.format("Order total: %.2f$", totalPrice));
    }

    public ShoppingItems editItem(String oldItemName) {
        Scanner myObj = new Scanner(System.in);
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
        }
    }

    public int getUserItem(ArrayList<ShoppingItems> itemList) {
        displayCart(itemList);//displaying items and asking user for id they would like to delete
        System.out.println("Enter the id of the item you would like to delete/edit");
        Scanner myObj = new Scanner(System.in);
        int deleteId = 0;
        while(true){
            try {
                deleteId = myObj.nextInt();
                break;
            }catch (Exception e ){
                System.out.println("Please an integer");
            }
        }
        return deleteId;
    }



    public int displayItem(HashMap<Integer, ShoppingItems> itemList) {

        System.out.println("Enter the id of the item you would like");
        Scanner myObj = new Scanner(System.in);
        int itemChosen = 0;
        for (Integer i : itemList.keySet()) {
            System.out.println("id: " + i + " item: " + itemList.get(i).getName() + " price " + itemList.get(i).getPrice());
        }
        while (true) {
            try {
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