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
public class CardDto {

    private Long id;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{16}$")
    private String cardNumber;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{3,4}$")
    private String cvv2;

    @NotNull
    @FutureOrPresent
    private LocalDate expireDate;

}
