package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IcecreamApplication {
    public static void main(String[] args) {
        List<String> ingredients = new ArrayList<String>();
        ingredients.add("cocoa powder");
        ingredients.add("milk");
        ingredients.add("sugar");
        ingredients.add("chocolate chips");

        com.company.factory.IceCream factoryIcecream = new com.company.factory.IceCream("chocolate", 10, 5, 4, ingredients);
        System.out.println("Factory Ice cream class: " + factoryIcecream.toString());
        factoryIcecream.addIngredient("eggs");
        factoryIcecream.makeIcecream();
        factoryIcecream.increaseSalePrice();
        System.out.println("Factory Ice cream class after the changes: " + factoryIcecream.toString());

        com.company.pointofsale.IceCream saleIcecream = new com.company.pointofsale.IceCream("vanilla", 12, 2);
        System.out.println("Point of sale Ice cream class: " + saleIcecream.toString());;
        saleIcecream.displayOrder();
        saleIcecream.calculateTotalPrice();
        saleIcecream.printBill();
    }
}
