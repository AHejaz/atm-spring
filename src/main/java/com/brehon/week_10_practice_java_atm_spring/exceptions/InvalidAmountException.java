package com.brehon.week_10_practice_java_atm_spring.exceptions;

import org.springframework.http.HttpStatus;


public class InvalidAmountException extends BaseException{
    public static final String MESSAGE = "invalid.amount";

    public InvalidAmountException() {
        super(MESSAGE);
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    @Override
    protected HttpStatus httpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
