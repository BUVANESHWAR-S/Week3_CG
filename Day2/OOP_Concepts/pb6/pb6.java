package Day2.OOP_Concepts.pb6;

import java.util.ArrayList;
import java.util.List;

interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

abstract class FoodItem implements Discountable {
    private String itemName;
    private double price;
    private int quantity;

    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemDetails() {
        return itemName + " x " + quantity + " @ " + price;
    }

    abstract double calculateTotalPrice();
}

class VegItem extends FoodItem {
    private double discount;

    VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public void applyDiscount(double percentage) {
        discount = (getPrice() * percentage / 100);
        setPrice(getPrice() - discount);
    }

    public String getDiscountDetails() {
        return "Veg item discount: " + discount;
    }
}

class NonVegItem extends FoodItem {
    private double discount;

    NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 20;
    }

    public void applyDiscount(double percentage) {
        discount = (getPrice() * percentage / 100);
        setPrice(getPrice() - discount);
    }

    public String getDiscountDetails() {
        return "Non-Veg item discount: " + discount;
    }
}

class OrderProcessor {
    void processOrder(List<FoodItem> items) {
        for (FoodItem item : items) {
            item.applyDiscount(10);
            System.out.println(item.getItemDetails());
            System.out.println(item.getDiscountDetails());
            System.out.println("Total: " + item.calculateTotalPrice());
            System.out.println();
        }
    }
}

public class pb6 {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala", 120, 2));
        order.add(new NonVegItem("Chicken Biryani", 150, 1));
        order.add(new VegItem("Dal Fry", 80, 3));

        OrderProcessor processor = new OrderProcessor();
        processor.processOrder(order);
    }
}

