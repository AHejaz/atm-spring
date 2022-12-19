package com.brehon.week_10_practice_java_atm_spring.exceptions;


import org.springframework.http.HttpStatus;

public class AgeException extends BaseException{
//    public static final String Message = "you are underage!";
    public static final String MESSAGE = "age.illegal";
    public AgeException(){
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
