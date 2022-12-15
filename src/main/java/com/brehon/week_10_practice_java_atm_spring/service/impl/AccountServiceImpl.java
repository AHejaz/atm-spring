package com.brehon.week_10_practice_java_atm_spring.service.impl;

import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import com.brehon.week_10_practice_java_atm_spring.exceptions.InvalidInputException;
import com.brehon.week_10_practice_java_atm_spring.exceptions.NotFoundException;
import com.brehon.week_10_practice_java_atm_spring.repository.AccountRepository;
import com.brehon.week_10_practice_java_atm_spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account login(String cardNumber, String password) {
        return accountRepository.findByCard_CardNumberAndCard_Password(cardNumber, password).orElseThrow(()->{throw new InvalidInputException("your input not correct");});
    }

    @Override
    public Optional<Account> findByCardNumber(String cardNumber){
        return accountRepository.findByCard_CardNumber(cardNumber);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void update(Account account) {
        if (accountRepository.existsById(account.getId()))
            accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void moneyTransfer(String cardNum1, String cardNum2, double amount){
        accountRepository.findByCard_CardNumber(cardNum1).ifPresentOrElse(account -> {
            Account account2 = accountRepository.findByCard_CardNumber(cardNum2).orElseThrow();
            account.withDraw(amount);
            account2.deposit(amount);
        },()->{
            throw new NotFoundException("no account by this card number");
        });

    }
    @Override
    public List<Transaction> lastTenTransactions(String cardNumber) {
        List<Transaction> transactions = accountRepository.findByCard_CardNumber(cardNumber).orElseThrow().getTransactions();
        if (transactions.isEmpty())
            throw new NotFoundException("There is no transaction");
        Collections.reverse(transactions);
        transactions.subList(0, transactions.size() < 10 ? transactions.size() : 9);
        return transactions;
    }
}
