package com.brehon.week_10_practice_java_atm_spring.exceptions;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException{

    public BaseException(String message) {
        super(message);
    }

    protected abstract HttpStatus httpStatus();
}
