package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.dto.TransactionDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import com.brehon.week_10_practice_java_atm_spring.entity.enums.TransactionType;

import java.util.List;
import java.util.Optional;


public interface TransactionService {
    List<TransactionDto> lastTenTransaction(String cardNumber);

    TransactionDto saveOrUpdate(TransactionDto transaction);

    TransactionDto findById(Long id);


    List<TransactionDto> findAll();


    void delete(TransactionDto transaction);

    TransactionDto createTransaction(TransactionDto dto);

    void deleteById(Long id);
}
