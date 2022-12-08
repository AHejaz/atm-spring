package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;

import java.util.List;
import java.util.Optional;


public interface TransactionService {
    List<Transaction> lastTenTransaction(String cardNumber);

    void save(Transaction transaction);

    Optional<Transaction> findById(Long id);


    List<Transaction> findAll();

    void update(Transaction transaction);

    void delete(Transaction transaction);

    void deleteById(Long id);
}
