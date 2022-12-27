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
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public List<TransactionDto> lastTenTransaction(String cardNumber){
        return transactionMapper.toDto(transactionRepository.findByAccount_Card_CardNumberOrderByDateDesc(cardNumber, PageRequest.of(0,10)).getContent());
    }
    @Override
    public TransactionDto saveOrUpdate(TransactionDto dto) {
        Transaction transaction = transactionMapper.toEntity(dto);
        transactionRepository.save(transaction);
        return transactionMapper.toDto(transaction);
    }

    @Override
    public TransactionDto findById(Long id) {
        return transactionMapper.toDto(transactionRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("this transaction not Fount!");
        }));
    }

    @Override
    public List<TransactionDto> findAll() {
        return transactionMapper.toDto(transactionRepository.findAll());
    }



    @Override
    public void delete(TransactionDto transaction) {
        transactionRepository.delete(transactionMapper.toEntity(transaction));
    }

    @Override
    public TransactionDto createTransaction(TransactionDto dto){
        Transaction transaction = transactionMapper.toEntity(dto);
        return transactionMapper.toDto(transaction);
    }

    @Override
    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
}
