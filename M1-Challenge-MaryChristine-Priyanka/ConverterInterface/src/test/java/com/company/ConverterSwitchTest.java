package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterSwitchTest {
    private Converter converterSwitch;

    @Before
    public void setUp() {
        converterSwitch = new ConverterSwitch();
    }

    @Test
    public void shouldConvertMonthNumberToMonthName() {
        String actualMonth = converterSwitch.convertMonth(2);
        String expectedMonth = "February";

        assertEquals(expectedMonth, actualMonth);
    }

    @Test
    public void shouldReturnErrorOnInvalidMonthName() {
        String expectedMonth = "Wrong month number";
        String actualMonth = converterSwitch.convertMonth(34);

        assertEquals(expectedMonth, actualMonth);
    }

    @Test
    public void shouldConvertDayNumberToDayName() {
        String actualDay = converterSwitch.convertDay(5);
        String expectedDay = "Thursday";

        assertEquals(expectedDay, actualDay);
    }

    @Test
    public void shouldReturnErrorOnInvalidDayName() {
        String actualDay = "Wrong day number";
        String expectedDay = converterSwitch.convertDay(0);

        assertEquals(expectedDay, actualDay);
    }
}