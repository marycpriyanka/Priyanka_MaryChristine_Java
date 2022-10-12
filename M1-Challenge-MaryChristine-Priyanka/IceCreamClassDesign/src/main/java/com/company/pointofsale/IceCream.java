package com.company.pointofsale;

public class IceCream {
    private String flavor;
    private float price;
    private int quantity;

    public IceCream(String flavor, float price, int quantity) {
        this.flavor = flavor;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Calculates the total price
     * @return float - total price
     */
    public float calculateTotalPrice() {
        return this.getPrice() * this.getQuantity();
    }

    /**
     * Displays the bill
     */
    public void printBill() {
        System.out.println("Your bill for " + this.getFlavor() + " ice cream, " + this.getQuantity() + " scoops is " + this.calculateTotalPrice());
    }

    /**
     * Displays the order
     */
    public void displayOrder() {
        System.out.println("You ordered " + this.getQuantity() + " scoops of " + this.getFlavor() + " ice cream");
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "flavor='" + flavor + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
