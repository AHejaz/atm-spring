package com.brehon.week_10_practice_java_atm_spring.dto;


import jakarta.validation.constraints.*;
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

    @NotNull
    @NotBlank
    @Size(min = 3,max = 20)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 3,max = 30)
    private String family;

    @NotNull
    @Min(value = 18)
    private Integer age;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{11}")
    private String nationalCode;

    @NotNull
    private LocalDate birthday;
}
