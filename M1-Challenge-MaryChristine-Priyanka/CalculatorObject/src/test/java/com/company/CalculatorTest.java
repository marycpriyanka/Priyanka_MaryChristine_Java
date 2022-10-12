package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void shouldAddTwoIntegers() {
        assertEquals(2, Calculator.add(1, 1));
    }

    @Test
    public void shouldAddTwoDoubles() {
        Assert.assertEquals(5.7, Calculator.add(3.4, 2.3), 0.01);
    }

    @Test
    public void shouldSubtractTwoIntegers() {
        Assert.assertEquals(-29, Calculator.subtract(23, 52));
    }

    @Test
    public void shouldSubtractTwoDoubles() {
        Assert.assertEquals(5, Calculator.subtract(5.5, 0.5), 0.01);
    }

    @Test
    public void shouldMultiplyTwoIntegers() {
        Assert.assertEquals(68, Calculator.multiply(34, 2));
    }

    @Test
    public void shouldMultiplyTwoDoubles() {
        Assert.assertEquals(29.48, Calculator.multiply(6.7, 4.4), 0.01);
    }

    @Test
    public void shouldDivideTwoIntegers() {
        Assert.assertEquals(4, Calculator.divide(12, 3));
    }

    @Test
    public void shouldDivideTwoDoubles() {
        Assert.assertEquals(4.9, Calculator.divide(10.8, 2.2), 0.01);
    }
}