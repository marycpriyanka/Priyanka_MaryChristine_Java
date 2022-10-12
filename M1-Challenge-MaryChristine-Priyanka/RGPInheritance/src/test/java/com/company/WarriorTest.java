package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WarriorTest {
    private Warrior warrior;
    private Constable constable;

    @Before
    public void setUp() {
        warrior = new Warrior("Knight");
        constable = new Constable("Lightning", "Seattle");
    }
    @Test
    public void shouldReduceAttackedCharacterStrengthAndIncreaseFarmerStrengthOnAttackAnotherCharacter() {
        // Arrange
        int expectedWarriorStrengthValue = 85;
        int expectedConstableStrengthValue = 50;

        // Act
        warrior.attackAnotherCharacter(constable);
        int actualWarriorStrengthValue = warrior.getStrength();
        int actualConstableStrengthValue = constable.getStrength();

        // Assert
        assertEquals(expectedWarriorStrengthValue, actualWarriorStrengthValue);
        assertEquals(expectedConstableStrengthValue, actualConstableStrengthValue);
    }
}