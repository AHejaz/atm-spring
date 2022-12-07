package com.brehon.week_10_practice_java_atm_spring.exceptions;


import com.brehon.week_10_practice_java_atm_spring.file.MessageLoader;

public class AgeException extends RuntimeException{
//    public static final String Message = "you are underage!";
    public static final String message = MessageLoader.getMessage("AGE");
    public AgeException(){
        super(message);
    }
}
