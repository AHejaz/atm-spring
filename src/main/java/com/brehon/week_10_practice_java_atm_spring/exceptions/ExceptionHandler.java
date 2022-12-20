package com.brehon.week_10_practice_java_atm_spring.exceptions;

import com.brehon.week_10_practice_java_atm_spring.dto.ResponseDto;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Locale;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {


    private  final MessageSource messageSource;

    public ExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ResponseDto> handleBaseException(BaseException exception){
        return new ResponseEntity<>(new ResponseDto()
                .setMessage(messageSource.getMessage(exception.getMessage(), null, Locale.ENGLISH))
                .setCreateResponse(LocalDateTime.now())
                .setStatus(exception.httpStatus().value()),exception.httpStatus());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ResponseDto> globalException(BaseException exception){
        return new ResponseEntity<>(new ResponseDto()
                .setMessage(messageSource.getMessage(exception.getMessage(), null, Locale.ENGLISH))
                .setCreateResponse(LocalDateTime.now())
                .setStatus(exception.httpStatus().value()),exception.httpStatus());
    }

}
