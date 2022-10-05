package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstableTest {
    private Constable constable;
    private Farmer farmer;

    @Before
    public void setUp() {
        constable = new Constable("Lightning", "Seattle");
        farmer = new Farmer("Cob");
    }

    @Test
    public void shouldReduceAttackedCharacterStrengthAndIncreaseConstableStrengthOnAttackAnotherCharacter() {
        // Arrange
        int expectedConstableStrengthValue = 65;
        int expectedFarmerStrengthValue = 70;

        // Act
        constable.attackAnotherCharacter(farmer);
        int actualConstableStrengthValue = constable.getStrength();
        int actualFarmerStrengthValue = farmer.getStrength();

        // Assert
        assertEquals(expectedConstableStrengthValue, actualConstableStrengthValue);
        assertEquals(expectedFarmerStrengthValue, actualFarmerStrengthValue);
    }

    @Test
    public void shouldArrestAnotherCharacter() {
        boolean expectedValue = true;

        constable.arrestAnotherCharacter(farmer);
        boolean actualValue = farmer.isArrested();

        assertEquals(expectedValue, actualValue);
    }
}