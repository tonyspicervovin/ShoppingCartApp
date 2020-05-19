package main.java.ShoppingCartApp.model;

public class ShoppingItems {
    private String name;
    private double price;
    private int qty;
    private static int idCount = 1;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", id =" + id +
                '}';
    }

    public ShoppingItems(String name, double price, int qty)
    {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.id = idCount;
        idCount++;
    }
}
