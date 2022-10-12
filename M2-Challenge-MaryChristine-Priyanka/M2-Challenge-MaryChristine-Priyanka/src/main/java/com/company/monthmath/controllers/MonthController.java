package com.company.monthmath.controllers;

import com.company.monthmath.models.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MonthController {
    private int currentId = 1;

    private List<Month> months = new ArrayList<>(Arrays.asList(
            new Month(1, "January", currentId++),
            new Month(2, "February", currentId++),
            new Month(3, "March", currentId++),
            new Month(4, "April", currentId++),
            new Month(5, "May", currentId++),
            new Month(6, "June", currentId++),
            new Month(7, "July", currentId++),
            new Month(8, "August", currentId++),
            new Month(9, "September", currentId++),
            new Month(10, "October", currentId++),
            new Month(11, "November", currentId++),
            new Month(12, "December", currentId++)
    ));

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Month getMonthByNumber(@PathVariable int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("Input must be between 1 and 12");
        }

        for (int i = 0; i < months.size(); i++) {
            if (months.get(i).getNumber() == monthNumber) {
                return months.get(i);
            }
        }

        return null;
    }

    @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Month getRandomMonth() {
        Random rand = new Random();
        return months.get(rand.nextInt(12));
    }
}
