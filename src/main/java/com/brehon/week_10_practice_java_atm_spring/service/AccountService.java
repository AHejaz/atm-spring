package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.dto.*;
import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import com.brehon.week_10_practice_java_atm_spring.entity.User;

import java.util.List;
import java.util.Optional;

public interface AccountService extends BaseService<AccountDto,Long>{


    LoginResponseDto login(LoginDto dto);


    AccountDto findByCardNumber(String cardNumber);


    void moneyTransfer(TransferMoneyDto dto);

    void withdraw(DepositWithdrawDto dto);

    void deposit(DepositWithdrawDto dto);

}
