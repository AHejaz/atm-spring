package com.brehon.week_10_practice_java_atm_spring.controller;

import com.brehon.week_10_practice_java_atm_spring.dto.TransactionDto;
import com.brehon.week_10_practice_java_atm_spring.dto.TransferMoneyDto;
import com.brehon.week_10_practice_java_atm_spring.mapper.TransactionMapper;
import com.brehon.week_10_practice_java_atm_spring.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionController(TransactionService transactionService, TransactionMapper transactionMapper) {
        this.transactionService = transactionService;
        this.transactionMapper = transactionMapper;
    }

    @GetMapping("/")
    public List<TransactionDto> findAll(){
        return transactionMapper.toTransactionDto(transactionService.findAll());
    }

    @GetMapping("")
    public TransactionDto findById(@RequestParam(name = "id") Long id){
        return transactionMapper.toTransactionDto(transactionService.findById(id));
    }

    @GetMapping("/{card_number}")
    public List<TransactionDto> lastTenTransaction(@PathVariable(name = "card_number")String cardNumber){
        return transactionMapper.toTransactionDto(transactionService.lastTenTransaction(cardNumber));
    }

    @PostMapping
    public void save(@RequestBody @Valid TransactionDto transactionDto){
        transactionService.save(transactionMapper.toTransaction(transactionDto));
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id")Long id){
        transactionService.deleteById(id);
    }

}
