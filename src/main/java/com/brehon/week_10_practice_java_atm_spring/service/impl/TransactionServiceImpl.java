package com.brehon.week_10_practice_java_atm_spring.service.impl;

import com.brehon.week_10_practice_java_atm_spring.dto.TransactionDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import com.brehon.week_10_practice_java_atm_spring.entity.enums.TransactionType;
import com.brehon.week_10_practice_java_atm_spring.exceptions.NotFoundException;
import com.brehon.week_10_practice_java_atm_spring.mapper.TransactionMapper;
import com.brehon.week_10_practice_java_atm_spring.repository.TransactionRepository;
import com.brehon.week_10_practice_java_atm_spring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl extends BaseCrud<Transaction,TransactionDto,TransactionMapper,TransactionRepository,Long> implements TransactionService {


    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        super(transactionMapper,transactionRepository);
    }

    @Override
    public List<TransactionDto> lastTenTransaction(String cardNumber){
        return mapper.toDto(repository.findByAccount_Card_CardNumberOrderByDateDesc(cardNumber, PageRequest.of(0,10)).getContent());
    }

}
