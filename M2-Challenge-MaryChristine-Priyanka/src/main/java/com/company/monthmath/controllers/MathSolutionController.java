package com.company.monthmath.controllers;

import com.company.monthmath.models.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MathSolutionController {
    private static int mathId = 1;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution addTwoNumbers(@RequestBody MathSolution mathSolution) {
        if (mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {
            throw new IllegalArgumentException("Missing operands or operands are not both numbers");
        }
        if (Character.isDigit(mathSolution.getOperand1()) || Character.isDigit(mathSolution.getOperand2()) {
            throw new HttpMessageNotReadableException("operands are not both numbers");
        }

        mathSolution.setId(mathId++);
        mathSolution.setOperation("add");
        mathSolution.setAnswer(mathSolution.getOperand1() + mathSolution.getOperand2());

        return mathSolution;
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution subtractTwoNumbers(@RequestBody MathSolution mathSolution) {
        if (mathSolution.getOperand1() == null || mathSolution.getOperand2() == null
                || Character.isDigit(mathSolution.getOperand1()) || Character.isDigit(mathSolution.getOperand2())) {
            throw new IllegalArgumentException("Missing operands or operands are not both numbers");
        }

        mathSolution.setId(mathId++);
        mathSolution.setOperation("subtract");
        mathSolution.setAnswer(mathSolution.getOperand1() - mathSolution.getOperand2());

        return mathSolution;
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution multiplyTwoNumbers(@RequestBody MathSolution mathSolution) {
        if (mathSolution.getOperand1() == null || mathSolution.getOperand2() == null
                || Character.isDigit(mathSolution.getOperand1()) || Character.isDigit(mathSolution.getOperand2())) {
            throw new IllegalArgumentException("Missing operands or operands are not both numbers");
        }

        mathSolution.setId(mathId++);
        mathSolution.setOperation("multiply");
        mathSolution.setAnswer(mathSolution.getOperand1() * mathSolution.getOperand2());

        return mathSolution;
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution divideTwoNumbers(@RequestBody MathSolution mathSolution) {
        if (mathSolution.getOperand1() == null || mathSolution.getOperand2() == null || mathSolution.getOperand2() == 0
                || Character.isDigit(mathSolution.getOperand1()) || Character.isDigit(mathSolution.getOperand2())) {
            throw new IllegalArgumentException("Missing operands or operands are not both numbers");
        }

        mathSolution.setId(mathId++);
        mathSolution.setOperation("divide");
        mathSolution.setAnswer(mathSolution.getOperand1() / mathSolution.getOperand2());

        return mathSolution;
    }
}
