package com.brehon.week_10_practice_java_atm_spring.controller;


import com.brehon.week_10_practice_java_atm_spring.dto.AccountDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import com.brehon.week_10_practice_java_atm_spring.mapper.AccountMapper;
import com.brehon.week_10_practice_java_atm_spring.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("account")
public class AccountController {
    private final AccountService accountService;

    private final AccountMapper accountMapper;

    @Autowired
    public AccountController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }


    @GetMapping("/")
    public List<AccountDto> findAll() {
        return accountMapper.toAccountDto(accountService.findAll());
    }

    @GetMapping
    public AccountDto findByCardNumber(@RequestParam("card_number") String cardNumber) {
        return accountMapper.toAccountDto(accountService.findByCardNumber(cardNumber));
    }

    @PostMapping
    public void save(@RequestBody @Valid AccountDto accountDto) {
        accountService.save(accountMapper.toAccount(accountDto));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        accountService.deleteById(id);
    }
}
