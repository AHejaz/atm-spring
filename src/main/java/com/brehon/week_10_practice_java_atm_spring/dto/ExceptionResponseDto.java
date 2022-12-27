package com.brehon.week_10_practice_java_atm_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ExceptionResponseDto {

    private LocalDateTime timeStamp;

    private Integer status;

    private String error;

    private String message;
}
