package com.brehon.week_10_practice_java_atm_spring.exceptions;

import com.brehon.week_10_practice_java_atm_spring.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ResponseDto> handleBaseException(BaseException exception){
        return new ResponseEntity<>(new ResponseDto()
                .setMessage(exception.getMessage())
                .setCreateResponse(LocalDateTime.now())
                .setStatus(exception.httpStatus().value()),exception.httpStatus());
    }

}
