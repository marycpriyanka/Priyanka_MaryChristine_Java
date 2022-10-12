package com.company;

public class Constable extends Character {
    private String jurisdiction;

    // Constructor
    public Constable(String name, String jurisdiction) {
        super(name, 60, 100, 60, 20, 5, false, false);
        this.jurisdiction = jurisdiction;
    }

    /**
     * Method to arrest another character
     * @param character - character to be arrested
     */
    public void arrestAnotherCharacter(Character character) {
        character.setArrested(true);
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}
