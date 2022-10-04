package com.company.factory;

import java.util.List;

public class IceCream {
    private String flavor;
    private float salePrice;
    private float productionCost;
    private float productionTime;
    private List<String> ingredients;

    public IceCream(String flavor, float salePrice, float productionCost, float productionTime, List<String> ingredients) {
        this.flavor = flavor;
        this.salePrice = salePrice;
        this.productionCost = productionCost;
        this.productionTime = productionTime;
        this.ingredients = ingredients;
    }

    /**
     * Adds an ingredient to the ingredient list
     * @param ingredient - ingredient to be added
     */
    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    /**
     * Increases the sales price by 10%
     */
    public void increaseSalePrice() {
        this.salePrice += this.salePrice * 0.1;
    }

    /**
     * Method to make ice cream
     */
    public void makeIcecream() {
        System.out.println(this.getFlavor() + " ice cream is made with ingredients " + this.getIngredients() + ". The production time is " + this
                .getProductionTime() + " hours");
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(float productionCost) {
        this.productionCost = productionCost;
    }

    public float getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(float productionTime) {
        this.productionTime = productionTime;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "flavor='" + flavor + '\'' +
                ", salePrice=" + salePrice +
                ", productionCost=" + productionCost +
                ", productionTime=" + productionTime +
                ", ingredients=" + ingredients +
                '}';
    }
}
