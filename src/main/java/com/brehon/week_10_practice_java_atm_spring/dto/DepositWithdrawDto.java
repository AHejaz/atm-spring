package com.brehon.week_10_practice_java_atm_spring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DepositWithdrawDto {

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{16}$")
    private String cardNumber;

    @NotNull
    @Min(value = 1)
    private Double amount;
}

