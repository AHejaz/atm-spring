package com.brehon.week_10_practice_java_atm_spring.exceptions;


import org.springframework.http.HttpStatus;

public class AccountNotFindException extends BaseException{

//    public static final String message = "model.Account not found";
    public static final String MESSAGE ="";

    public AccountNotFindException() {
        super(MESSAGE);
    }

    @Override
    protected HttpStatus httpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
