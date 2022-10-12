package com.company;

public class Farmer extends Character {
    private boolean plowing = false;
    private boolean harvesting = false;

    // Constructor
    public Farmer(String name) {
        super(name, 75, 100, 75, 10, 1, false, false);
    }

    public boolean isPlowing() {
        return plowing;
    }

    public void setPlowing(boolean plowing) {
        this.plowing = plowing;
    }

    public boolean isHarvesting() {
        return harvesting;
    }

    public void setHarvesting(boolean harvesting) {
        this.harvesting = harvesting;
    }
}
