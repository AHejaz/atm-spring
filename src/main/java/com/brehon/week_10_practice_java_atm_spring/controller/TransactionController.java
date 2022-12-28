package com.brehon.week_10_practice_java_atm_spring.controller;

import com.brehon.week_10_practice_java_atm_spring.dto.TransactionDto;
import com.brehon.week_10_practice_java_atm_spring.dto.TransferMoneyDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import com.brehon.week_10_practice_java_atm_spring.mapper.TransactionMapper;
import com.brehon.week_10_practice_java_atm_spring.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    private final TransactionService transactionService;


    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TransactionDto>> findAll() {
        List<TransactionDto> dtoList = transactionService.findAll();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> findById(@PathVariable(name = "id") Long id) {
        TransactionDto dto = transactionService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{card_number}")
    public ResponseEntity<List<TransactionDto>> lastTenTransaction(@PathVariable(name = "card_number") String cardNumber) {
        List<TransactionDto> dtoList = transactionService.lastTenTransaction(cardNumber);
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<TransactionDto> save(@RequestBody @Valid TransactionDto transactionDto) {
        TransactionDto dto = transactionService.saveOrUpdate(transactionDto);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
        transactionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
