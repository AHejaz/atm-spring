package com.brehon.week_10_practice_java_atm_spring.exceptions;


import com.brehon.week_10_practice_java_atm_spring.file.MessageLoader;
import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends BaseException {
    public static final String MESSAGE = MessageLoader.getMessage("INVALID_PASSWORD");

    public InvalidPasswordException() {
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
