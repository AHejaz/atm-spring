package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import com.brehon.week_10_practice_java_atm_spring.entity.enums.TransactionType;

import java.util.List;
import java.util.Optional;


public interface TransactionService {
    List<Transaction> lastTenTransaction(String cardNumber);

    void save(Transaction transaction);

    Transaction findById(Long id);


    List<Transaction> findAll();

    void update(Transaction transaction);

    void delete(Transaction transaction);

    void createTransaction(Double amount, TransactionType type);

    void deleteById(Long id);
}
