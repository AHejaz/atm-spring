package com.brehon.week_10_practice_java_atm_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseDto {
    private String message;
    private LocalDateTime createResponse;
    private Integer status;
}
