package com.brehon.week_10_practice_java_atm_spring.exceptions;


import com.brehon.week_10_practice_java_atm_spring.file.MessageLoader;

public class InvalidPasswordException extends RuntimeException {
    public static final String message = MessageLoader.getMessage("INVALID_PASSWORD");

    public InvalidPasswordException() {
        super(message);
    }
}
