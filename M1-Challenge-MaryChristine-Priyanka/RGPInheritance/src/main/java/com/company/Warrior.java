package com.company;

public class Warrior extends Character {
    private int shieldStrength = 100;

    public Warrior(String name) {
        super(name, 75, 100, 100, 50, 10, false, false);
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }
}
