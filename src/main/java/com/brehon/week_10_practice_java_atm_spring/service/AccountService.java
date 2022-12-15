package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    void save(Account account);

    Optional<Account> findById(Long id);

    Account login(String cardNumber,String password);


    Optional<Account> findByCardNumber(String cardNumber);

    List<Account> findAll();

    void update(Account account);

    void delete(Account account);

    void deleteById(Long id);

    void moneyTransfer(String cardNum1, String cardNum2, double amount);

    List<Transaction> lastTenTransactions(String cardNumber);
}
