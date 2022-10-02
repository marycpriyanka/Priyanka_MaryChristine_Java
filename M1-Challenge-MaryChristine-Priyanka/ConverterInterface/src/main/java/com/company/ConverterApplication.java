package com.company;

public class ConverterApplication {
    public static void main(String[] args) {
        Converter converterIf = new ConverterIf();
        String monthIf = converterIf.convertMonth(3);
        System.out.println("Month 3: " + monthIf);

        String dayIf = converterIf.convertDay(5);
        System.out.println("Day 5: " + dayIf);

        Converter converterSwitch = new ConverterSwitch();
        String monthSwitch = converterSwitch.convertMonth(11);
        System.out.println("Month 11: " + monthSwitch);

        String daySwitch = converterSwitch.convertDay(1);
        System.out.println("Day 1: " + daySwitch);
    }
}
