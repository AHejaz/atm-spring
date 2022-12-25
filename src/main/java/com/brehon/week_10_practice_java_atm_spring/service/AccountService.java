package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.dto.AccountDto;
import com.brehon.week_10_practice_java_atm_spring.dto.DepositWithdrawDto;
import com.brehon.week_10_practice_java_atm_spring.dto.LoginDto;
import com.brehon.week_10_practice_java_atm_spring.dto.TransferMoneyDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import com.brehon.week_10_practice_java_atm_spring.entity.User;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    void saveOrUpdate(AccountDto dto);

    AccountDto createAccount(AccountDto dto);

    Optional<Account> findById(Long id);

    AccountDto login(LoginDto dto);


    AccountDto findByCardNumber(String cardNumber);

    List<AccountDto> findAll();


    void delete(AccountDto dto);

    void deleteById(Long id);

    void moneyTransfer(TransferMoneyDto dto);

    void withdraw(DepositWithdrawDto dto);

    void deposit(DepositWithdrawDto dto);

    List<Transaction> lastTenTransactions(String cardNumber);
}
