package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.dto.TransactionDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import com.brehon.week_10_practice_java_atm_spring.entity.enums.TransactionType;

import java.util.List;
import java.util.Optional;


public interface TransactionService extends BaseService<TransactionDto,Long>{
    List<TransactionDto> lastTenTransaction(String cardNumber);

}
