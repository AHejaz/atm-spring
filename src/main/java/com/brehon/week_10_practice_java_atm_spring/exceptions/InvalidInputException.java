package com.brehon.week_10_practice_java_atm_spring.exceptions;

public class InvalidInputException extends RuntimeException {


    public InvalidInputException(String message) {
        super(message);
    }
}
