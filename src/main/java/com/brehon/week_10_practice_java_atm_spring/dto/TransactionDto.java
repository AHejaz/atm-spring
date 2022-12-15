package com.brehon.week_10_practice_java_atm_spring.dto;


import com.brehon.week_10_practice_java_atm_spring.entity.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TransactionDto {
    private Long id;
    private Double amount;
    private TransactionType transactionType;
    private Date date;
}
