package com.brehon.week_10_practice_java_atm_spring.exceptions;


import org.springframework.http.HttpStatus;

public class AccountNotFindException extends BaseException{

//    public static final String message = "model.Account not found";
    public static final String MESSAGE ="account.not.found";

    public AccountNotFindException() {
        super(MESSAGE);
    }

    @Override
    protected HttpStatus httpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
