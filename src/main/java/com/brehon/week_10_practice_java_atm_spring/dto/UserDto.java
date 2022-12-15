package com.brehon.week_10_practice_java_atm_spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserDto {
    private Long id;
    private String name;
    private String family;
    private Integer age;
    private String nationalCode;
    private LocalDate birthday;
}
