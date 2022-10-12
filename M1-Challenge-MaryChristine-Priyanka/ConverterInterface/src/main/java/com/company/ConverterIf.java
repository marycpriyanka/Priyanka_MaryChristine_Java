package com.company;

public class ConverterIf implements Converter {
    @Override
    public String convertMonth(int monthNumber) {
        String monthName = "";

        if (monthNumber == 1) {
            monthName = "January";
        } else if (monthNumber == 2) {
            monthName = "February";
        } else if (monthNumber == 3) {
            monthName = "March";
        } else if (monthNumber == 4) {
            monthName = "April";
        } else if (monthNumber == 5) {
            monthName = "May";
        } else if (monthNumber == 6) {
            monthName = "June";
        } else if (monthNumber == 7) {
            monthName = "July";
        } else if (monthNumber == 8) {
            monthName = "August";
        } else if (monthNumber == 9) {
            monthName = "September";
        } else if (monthNumber == 10) {
            monthName = "October";
        } else if (monthNumber == 11) {
            monthName = "November";
        } else if (monthNumber == 12) {
            monthName = "December";
        } else {
            monthName = "Wrong month number";
        }

        return monthName;
    }

    // This method converts the given number into its corresponding day of the week.
    public String convertDay(int dayNumber) {
        String dayName = "";

        if (dayNumber == 1) {
            dayName = "Sunday";
        } else if (dayNumber == 2) {
            dayName = "Monday";
        } else if (dayNumber == 3) {
            dayName = "Tuesday";
        } else if (dayNumber == 4) {
            dayName = "Wednesday";
        } else if (dayNumber == 5) {
            dayName = "Thursday";
        } else if (dayNumber == 6) {
            dayName = "Friday";
        } else if (dayNumber == 7) {
            dayName = "Saturday";
        } else {
            dayName = "Wrong day number";
        }

        return dayName;
    }
}
