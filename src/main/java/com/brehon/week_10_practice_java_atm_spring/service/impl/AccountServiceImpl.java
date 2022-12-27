package com.brehon.week_10_practice_java_atm_spring.service.impl;

import com.brehon.week_10_practice_java_atm_spring.dto.AccountDto;
import com.brehon.week_10_practice_java_atm_spring.dto.DepositWithdrawDto;
import com.brehon.week_10_practice_java_atm_spring.dto.LoginDto;
import com.brehon.week_10_practice_java_atm_spring.dto.TransferMoneyDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import com.brehon.week_10_practice_java_atm_spring.entity.User;
import com.brehon.week_10_practice_java_atm_spring.entity.enums.AccountType;
import com.brehon.week_10_practice_java_atm_spring.exceptions.InvalidPasswordException;
import com.brehon.week_10_practice_java_atm_spring.exceptions.NotFoundException;
import com.brehon.week_10_practice_java_atm_spring.mapper.AccountMapper;
import com.brehon.week_10_practice_java_atm_spring.repository.AccountRepository;
import com.brehon.week_10_practice_java_atm_spring.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public void saveOrUpdate( AccountDto dto) {
        accountRepository.save(accountMapper.toEntity(dto));
    }

    @Override
    public AccountDto createAccount( AccountDto dto){
        Account account = accountMapper.toEntity(dto);
        return accountMapper.toDto(accountRepository.save(account));
    }

    @Override
    public AccountDto findById(Long id) {
        return accountMapper.toDto(accountRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("account not found");
        }));
    }

    @Override
    public AccountDto login( LoginDto dto) {
        Account account = accountRepository.findByCard_CardNumber(dto.getCardNumber()).orElseThrow(() -> {
            throw new NotFoundException("account not found");
        });
        if (account.getCard().validation(dto.getPassword()))
            return accountMapper.toDto(account);
        throw new InvalidPasswordException();
    }

    @Override
    public AccountDto findByCardNumber(String cardNumber){
        return accountMapper.toDto(accountRepository.findByCard_CardNumber(cardNumber).orElseThrow(()->{
            throw new NotFoundException("account not Found");
        })
        );
    }

    @Override
    public List<AccountDto> findAll() {
        return accountMapper.toDto(accountRepository.findAll());
    }


    @Override
    public void delete(@Valid AccountDto dto) {
        accountRepository.delete(accountMapper.toEntity(dto));
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void moneyTransfer( TransferMoneyDto dto){
        List<Account>accounts = new ArrayList<>();
        accountRepository.findByCard_CardNumber(dto.getCardOrigin()).ifPresentOrElse(account -> {
            Account account2 = accountRepository.findByCard_CardNumber(dto.getCardDestiny()).orElseThrow();
            account.withDraw(dto.getAmount());
            account2.deposit(dto.getAmount());
            accounts.add(account);
            accounts.add(account2);
            accountRepository.saveAll(accounts);
        },()->{
            throw new NotFoundException("no account by this card number");
        });

    }

    @Override
    public void withdraw(@Valid DepositWithdrawDto dto){
        Account account = accountRepository.findByCard_CardNumber(dto.getCardNumber()).orElseThrow(()->{
                    throw new NotFoundException("no account by this card number");
                });
        account.withDraw(dto.getAmount());
        accountRepository.save(account);
    }

    @Override
    public void deposit( DepositWithdrawDto dto){
        Account account =  accountRepository.findByCard_CardNumber(dto.getCardNumber()).orElseThrow(()->{
            throw new NotFoundException("no account by this card number");
        });
        account.deposit(dto.getAmount());
        accountRepository.save(account);
    }

}
