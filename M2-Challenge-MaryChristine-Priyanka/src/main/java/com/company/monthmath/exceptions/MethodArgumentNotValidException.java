package com.company.monthmath.exceptions;

public class MethodArgumentNotValidException extends RuntimeException {
    public MethodArgumentNotValidException() {
        super();
    }

    public MethodArgumentNotValidException(String msg) {
        super(msg);
    }
}


