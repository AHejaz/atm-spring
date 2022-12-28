package com.brehon.week_10_practice_java_atm_spring.service.impl;

import com.brehon.week_10_practice_java_atm_spring.dto.*;
import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import com.brehon.week_10_practice_java_atm_spring.exceptions.InvalidPasswordException;
import com.brehon.week_10_practice_java_atm_spring.exceptions.NotFoundException;
import com.brehon.week_10_practice_java_atm_spring.mapper.AccountMapper;
import com.brehon.week_10_practice_java_atm_spring.repository.AccountRepository;
import com.brehon.week_10_practice_java_atm_spring.service.AccountService;
import com.brehon.week_10_practice_java_atm_spring.util.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl extends BaseCrud<Account,AccountDto, AccountMapper, AccountRepository,Long> implements AccountService {

    private final JwtUtils jwtUtils;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper, JwtUtils jwtUtils) {
        super(accountMapper,accountRepository);
        this.jwtUtils = jwtUtils;
    }


    @Override
    public AccountDto saveOrUpdate(AccountDto dto) {
        return null;
    }

    @Override
    public LoginResponseDto login(LoginDto dto) {
        Account account = repository.findByCard_CardNumber(dto.getCardNumber()).orElseThrow(() -> {
            throw new NotFoundException("account not found");
        });
        if (account.getCard().validation(dto.getPassword()))
            return new LoginResponseDto(jwtUtils.generateToken(account));
        throw new InvalidPasswordException();
    }

    @Override
    public AccountDto findByCardNumber(String cardNumber){
        return mapper.toDto(repository.findByCard_CardNumber(cardNumber).orElseThrow(()->{
            throw new NotFoundException("account not Found");
        })
        );
    }


    @Override
    public void moneyTransfer( TransferMoneyDto dto){
        List<Account>accounts = new ArrayList<>();
        repository.findByCard_CardNumber(dto.getCardOrigin()).ifPresentOrElse(account -> {
            Account account2 = repository.findByCard_CardNumber(dto.getCardDestiny()).orElseThrow();
            account.withDraw(dto.getAmount());
            account2.deposit(dto.getAmount());
            accounts.add(account);
            accounts.add(account2);
            repository.saveAll(accounts);
        },()->{
            throw new NotFoundException("no account by this card number");
        });

    }

    @Override
    public void withdraw(@Valid DepositWithdrawDto dto){
        Account account = repository.findByCard_CardNumber(dto.getCardNumber()).orElseThrow(()->{
                    throw new NotFoundException("no account by this card number");
                });
        account.withDraw(dto.getAmount());
        repository.save(account);
    }

    @Override
    public void deposit( DepositWithdrawDto dto){
        Account account =  repository.findByCard_CardNumber(dto.getCardNumber()).orElseThrow(()->{
            throw new NotFoundException("no account by this card number");
        });
        account.deposit(dto.getAmount());
        repository.save(account);
    }

}
