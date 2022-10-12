package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterIfTest {
    private Converter converterIf;

    @Before
    public void setUp() {
        converterIf = new ConverterIf();
    }

    @Test
    public void shouldConvertMonthNumberToMonthName() {
        String actualMonth = converterIf.convertMonth(2);
        String expectedMonth = "February";

        assertEquals(expectedMonth, actualMonth);
    }

    @Test
    public void shouldReturnErrorOnInvalidMonthName() {
        String expectedMonth = "Wrong month number";
        String actualMonth = converterIf.convertMonth(34);

        assertEquals(expectedMonth, actualMonth);
    }

    @Test
    public void shouldConvertDayNumberToDayName() {
        String actualDay = converterIf.convertDay(5);
        String expectedDay = "Thursday";

        assertEquals(expectedDay, actualDay);
    }

    @Test
    public void shouldReturnErrorOnInvalidDayName() {
        String actualDay = "Wrong day number";
        String expectedDay = converterIf.convertDay(0);

        assertEquals(expectedDay, actualDay);
    }
}