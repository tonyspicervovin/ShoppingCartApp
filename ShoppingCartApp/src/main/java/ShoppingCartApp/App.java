/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ShoppingCartApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    @Configuration
    @ComponentScan(basePackageClasses = App.class)
    public class Config {
    }

    //initializing list for shopping item objects
    public ArrayList<ShoppingItems> itemList = new ArrayList<>();

    public int selection;



    public static void main(String[] args) {

        App app = new App();

        ApplicationContext context = app.init();
        App cart = context.getBean("shoppingCart", App.class);
        cart.calculateTotal();
        app.displayMenu();

    }
    private ApplicationContext init() {
        return new AnnotationConfigApplicationContext(Config.class);
    }

    public void displayMenu() {

        while(true) {
            //Printing menu for application, scanning user input and verifying it's an int 1-5
            try{
                System.out.println("***Shopping Cart Application*** \n1.Add item \n2.Delete item\n3.Display cart\n4.Calculate Total\n5.Edit Item\n6.Exit");
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                selection = myObj.nextInt();

            }catch (Exception e) {
                System.out.println("Please make a selection 1-6");
                continue;
            }
            if (selection == 1) {
                ShoppingItems item = buildItem();
                addItem(item);
            }else if (selection == 2) {
                ShoppingItems matchingItem = findItem();
                deleteItem(matchingItem);
            }else if (selection == 3) {
                displayItem();
            }else if (selection == 4) {
                double totalPrice  = calculateTotal();
                System.out.println(String.format("Order total: %.2f$", totalPrice));
            }else if (selection == 5) {
                ShoppingItems matchingItem = findItem();
                editItem(matchingItem);
            } else if (selection == 6){
                System.out.println("Goodbye");
                break;
            }
            else {
                System.out.println("Please enter a number 1-6");
            }
        }
    }

    public ShoppingItems buildItem() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String itemName;
        double price;
        int qty;
        String nada;
        outerLoop:
        while(true) {
            try {
                // Read user input
                System.out.println("Enter item name");
                itemName = myObj.nextLine();
                System.out.println("Enter item price");
                price = myObj.nextDouble();
                System.out.println("Enter item qty");
                qty = myObj.nextInt();
                for (ShoppingItems x : itemList) {
                    if (x.getName().equals(itemName)){
                        System.out.println("You already entered " + x.getName() + " at a price of " + x.getPrice() + "\nHow many more would you like?");
                        qty = myObj.nextInt();
                        x.setQty(x.getQty() + qty);
                        System.out.println("Great your item has been updated");
                        break outerLoop; // breaking out of while loop so we don't add the item we are updating
                    }
                }
                return new ShoppingItems(itemName, price, qty);
            } catch (Exception e) {
                nada = myObj.nextLine(); // just to clear the non read qty, not used
                System.out.println("Please enter a name, price and qty");
            }
        }
        return null;
    }

    public void editItem(ShoppingItems matchingItem) {
        Scanner myObj = new Scanner(System.in);
        if (matchingItem != null){
            System.out.println("Enter a new price for " + matchingItem.getName());
            while(true) {
                try{
                    double price = myObj.nextDouble();
                    System.out.println("Enter a new qty for " + matchingItem.getName());
                    int qty = myObj.nextInt();
                    matchingItem.setQty(qty);
                    matchingItem.setPrice(price);
                    System.out.println("Your item has been updated");
                    break;
                }catch(Exception e) {
                    System.out.println("Please enter a price and qty");
                }
            }
        }else{
            System.out.println("No item found with that ID");
        }
    }

    public double calculateTotal() {

        double totalPrice = 0; //looping through list of objects and calculating total cost
        for (ShoppingItems x : itemList) {
            totalPrice = totalPrice + (x.getPrice() * x.getQty());
        }
        return totalPrice;
    }
    public ShoppingItems findItem() {
        displayItem();//displaying items and asking user for id they would like to delete
        System.out.println("Enter the id of the item you would like to delete/edit");
        Scanner myObj = new Scanner(System.in);
        int deleteID = 0;
        boolean foundOne = false;
        try {
            deleteID = myObj.nextInt();
        }catch (Exception e ){
            System.out.println("Please an integer");
        }
        for (int i = 0; i < itemList.size() ; i++) {//looping through items, if item id matches we remove it and let user know if deleted or not found
            if (itemList.get(i).getId() == deleteID) {
                return itemList.get(i);
            }
        }
        return null;
    }

    public void deleteItem(ShoppingItems matchingItem) {

        if (matchingItem != null){
            itemList.remove(matchingItem);
            System.out.println(matchingItem.getName() + " removed");
        }else{
            System.out.println("No item found with that ID");
        }
    }

    public void addItem(ShoppingItems item) {
        try{
            itemList.add(item);
    }catch (Exception e ){
            System.out.println(e);
        }
    }

    public void displayItem() {
        for (ShoppingItems x : itemList) {   // printing each shopping item
            System.out.println(String.format("id: %d name: %s price: %.2f qty: %d", x.getId(), x.getName(), x.getPrice(), x.getQty()));
        }
        if (itemList.size() == 0){  //show user a message if no items are in list
            System.out.println("List is empty");
        }
    }


}
