package com.brehon.week_10_practice_java_atm_spring.controller;


import com.brehon.week_10_practice_java_atm_spring.dto.AccountDto;
import com.brehon.week_10_practice_java_atm_spring.dto.DepositWithdrawDto;
import com.brehon.week_10_practice_java_atm_spring.dto.TransferMoneyDto;
import com.brehon.week_10_practice_java_atm_spring.mapper.AccountMapper;
import com.brehon.week_10_practice_java_atm_spring.mapper.UserMapper;
import com.brehon.week_10_practice_java_atm_spring.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
    private final AccountService accountService;

    private final AccountMapper accountMapper;

    private final UserMapper userMapper;



    @Autowired
    public AccountController(AccountService accountService, AccountMapper accountMapper, UserMapper userMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
        this.userMapper = userMapper;
    }


    @GetMapping("/")
    public List<AccountDto> findAll() {
        return accountMapper.toAccountDto(accountService.findAll());
    }

    @GetMapping
    public AccountDto findByCardNumber(@RequestParam("card_number") String cardNumber) {
        return accountMapper.toAccountDto(accountService.findByCardNumber(cardNumber));
    }

    @PostMapping("")
    public void save(@RequestBody @Valid AccountDto accountDto) {
        accountService.save(accountMapper.toAccount(accountDto));
    }

    @PostMapping("/a")
    public void createdAccount(@RequestBody @Valid AccountDto accountDto) {
        accountService.createAccount(userMapper.toUser(accountDto.getUserDto()),
                accountDto.getPassword(),
                accountDto.getType().getValue());
    }

    @PostMapping("/")
    public void transferMoney(@RequestBody @Valid TransferMoneyDto transferDto){
        accountService.moneyTransfer(transferDto.getCardOrigin(),
                transferDto.getCardDestiny(),
                transferDto.getAmount());
    }

    @PostMapping("/w")
    public void withdraw(@RequestBody @Valid DepositWithdrawDto depositWithdrawDto){
        accountService.deposit(depositWithdrawDto.getCardNumber(),
                depositWithdrawDto.getAmount());
    }

    @PostMapping("/d")
    public void deposit(@RequestBody @Valid DepositWithdrawDto depositWithdrawDto){
        accountService.deposit(depositWithdrawDto.getCardNumber(),
                depositWithdrawDto.getAmount());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        accountService.deleteById(id);
    }
}
