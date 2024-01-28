package model;
public class Item {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Item(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters (you can generate them using your IDE)

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
    }
}

