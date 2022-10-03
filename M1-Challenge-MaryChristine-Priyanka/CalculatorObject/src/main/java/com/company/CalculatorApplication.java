package com.company;

public class CalculatorApplication {
    public static void main(String[] args) {
        System.out.println("1 + 1 = " + Calculator.add(1, 1));
        System.out.println("23 - 52 = " + Calculator.subtract(23, 52));
        System.out.println("34 * 2 = " + Calculator.multiply(34, 2));
        System.out.println("12 / 3 = " + Calculator.divide(12, 3));
        System.out.println("12 / 7 = " + Calculator.divide(12, 7));
        System.out.println("3.4 + 2.3 = " + Calculator.add(3.4, 2.3));
        System.out.println("6.7 * 4.4 = " + Calculator.multiply(6.7, 4.4));
        System.out.println("5.5 - 0.5 = " + Calculator.subtract(5.5, 0.5));
        System.out.println("10.8 / 2.2 = " + Calculator.divide(10.8, 2.2));
    }
}
