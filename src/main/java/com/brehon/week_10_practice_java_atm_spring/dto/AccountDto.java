package com.brehon.week_10_practice_java_atm_spring.dto;

import com.brehon.week_10_practice_java_atm_spring.entity.enums.AccountType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AccountDto {

    private Long id;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{10}$")
    private String accountNumber;

    @NotBlank
    @NotNull
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?\\d)(?=.*?[#?!@$ %^&*-]).{5,}$")
    private String password;

    @NotNull
    @Min(value = 0)
    private Double balance;

    @NotNull
    private AccountType type;

    @NotNull
    private UserDto user;

    @NotNull
    private CardDto card;

    private List<TransactionDto> transactions;

}
