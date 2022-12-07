package com.brehon.week_10_practice_java_atm_spring.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
