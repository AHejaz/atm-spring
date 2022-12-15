package com.brehon.week_10_practice_java_atm_spring.controller;


import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import com.brehon.week_10_practice_java_atm_spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @GetMapping
    public Optional<Account> findByCardNumber(@RequestParam("card_number") String cardNumber){
        return  accountService.findByCardNumber(cardNumber);
    }
    @PostMapping
    public void save(@RequestBody Account account){
        accountService.save(account);
    }
}
