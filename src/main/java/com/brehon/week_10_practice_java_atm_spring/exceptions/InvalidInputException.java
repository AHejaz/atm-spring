package com.brehon.week_10_practice_java_atm_spring.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidInputException extends BaseException {


    public InvalidInputException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    protected HttpStatus httpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
