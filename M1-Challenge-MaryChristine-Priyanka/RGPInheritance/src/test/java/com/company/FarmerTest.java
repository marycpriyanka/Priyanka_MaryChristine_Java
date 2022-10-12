package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmerTest {
    private Farmer farmer;
    private Warrior warrior;

    @Before
    public void setUp() {
        farmer = new Farmer("Cob");
        warrior = new Warrior("Knight");
    }

    @Test
    public void shouldReduceAttackedCharacterStrengthAndIncreaseFarmerStrengthOnAttackAnotherCharacter() {
        // Arrange
        int expectedFarmerStrengthValue = 76;
        int expectedWarriorStrengthValue = 74;

        // Act
        farmer.attackAnotherCharacter(warrior);
        int actualFarmerStrengthValue = farmer.getStrength();
        int actualWarriorStrengthValue = warrior.getStrength();

        // Assert
        assertEquals(expectedFarmerStrengthValue, actualFarmerStrengthValue);
        assertEquals(expectedWarriorStrengthValue, actualWarriorStrengthValue);
    }
}