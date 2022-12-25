package com.brehon.week_10_practice_java_atm_spring.controller;


import com.brehon.week_10_practice_java_atm_spring.dto.AccountDto;
import com.brehon.week_10_practice_java_atm_spring.dto.DepositWithdrawDto;
import com.brehon.week_10_practice_java_atm_spring.dto.LoginDto;
import com.brehon.week_10_practice_java_atm_spring.dto.TransferMoneyDto;
import com.brehon.week_10_practice_java_atm_spring.mapper.AccountMapper;
import com.brehon.week_10_practice_java_atm_spring.mapper.UserMapper;
import com.brehon.week_10_practice_java_atm_spring.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
    private final AccountService accountService;


    @Autowired
    public AccountController(AccountService accountService, AccountMapper accountMapper, UserMapper userMapper) {
        this.accountService = accountService;

    }


    @GetMapping("/")
    public List<AccountDto> findAll() {
        return accountService.findAll();
    }

    @GetMapping
    public AccountDto findByCardNumber(@RequestParam("card_number") String cardNumber) {
        return accountService.findByCardNumber(cardNumber);
    }

    @PostMapping("/login")
    public ResponseEntity<AccountDto> login(@RequestBody @Valid LoginDto dto){
        return ResponseEntity.ok(accountService.login(dto));
    }

    @PostMapping(value = "")
    public ResponseEntity<AccountDto> save(@RequestBody @Valid AccountDto accountDto) {
        AccountDto account = accountService.createAccount(accountDto);
        return ResponseEntity.ok(account);
    }



    @PostMapping("/transfer")
    public ResponseEntity<Void> transferMoney(@RequestBody @Valid TransferMoneyDto dto){
        accountService.moneyTransfer(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/w")
    public ResponseEntity<Void> withdraw(@RequestBody @Valid DepositWithdrawDto dto){
        accountService.withdraw(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/d")
    public ResponseEntity<Void> deposit(@RequestBody @Valid DepositWithdrawDto dto){
        accountService.deposit(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        accountService.deleteById(id);
    }
}
