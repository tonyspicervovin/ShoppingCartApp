package ShoppingCartApp.model;

//model for shopping item objects

public class ShoppingItems {
    private String name;
    private double price;
    private int qty;
    private int id;

    public ShoppingItems(String name, double price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }
    public ShoppingItems() {

    }

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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", price=" + price +
                ", id =" + id;
    }
}
