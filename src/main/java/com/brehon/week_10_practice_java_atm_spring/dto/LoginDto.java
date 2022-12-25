package com.brehon.week_10_practice_java_atm_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{16}$")
    private String cardNumber;

    @NotNull
    @NotBlank
    private String password;
}
