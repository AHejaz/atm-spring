package com.brehon.week_10_practice_java_atm_spring.exceptions;

import com.brehon.week_10_practice_java_atm_spring.dto.ExceptionResponseDto;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Locale;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {


    private  final MessageSource messageSource;

    public ExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ExceptionResponseDto> handleBaseException(BaseException exception){
        return new ResponseEntity<>(new ExceptionResponseDto()
                .setMessage(messageSource.getMessage(exception.getMessage(), null, Locale.ENGLISH))
                .setTimeStamp(LocalDateTime.now())
                .setStatus(exception.httpStatus().value()),exception.httpStatus());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionResponseDto> globalException(BaseException exception){
        return new ResponseEntity<>(new ExceptionResponseDto()
                .setMessage(messageSource.getMessage(exception.getMessage(), null, Locale.ENGLISH))
                .setTimeStamp(LocalDateTime.now())
                .setStatus(exception.httpStatus().value()),exception.httpStatus());
    }

}
