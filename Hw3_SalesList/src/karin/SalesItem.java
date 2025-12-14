package karin;

public class SalesItem {

    private String name;
    private double price;
    private int quantity;

    public SalesItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Calculation method
    public double getItemTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + " | $" + String.format("%.2f", price) +
               " | Qty: " + quantity +
               " | Subtotal: $" + String.format("%.2f", getItemTotal());
    }
}
