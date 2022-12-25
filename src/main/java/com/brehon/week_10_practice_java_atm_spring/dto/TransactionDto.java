package com.brehon.week_10_practice_java_atm_spring.dto;


import com.brehon.week_10_practice_java_atm_spring.entity.enums.TransactionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TransactionDto {
    private Long id;

    @NotNull
    @Min(value = 1)
    private Double amount;

    @NotNull
    private TransactionType transactionType;

    @NotNull
    @PastOrPresent
    private LocalDate date;

}
