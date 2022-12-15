package com.brehon.week_10_practice_java_atm_spring.mapper;

import com.brehon.week_10_practice_java_atm_spring.dto.TransactionDto;
import com.brehon.week_10_practice_java_atm_spring.dto.UserDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import com.brehon.week_10_practice_java_atm_spring.entity.User;

import java.util.ArrayList;
import java.util.List;

public class TransactionMapper {

    public static List<TransactionDto> toUserDto(List<Transaction> transactions){
        List<TransactionDto> transactionDtos = new ArrayList<>();
        transactions.forEach(transaction -> {
            transactionDtos.add(new TransactionDto(transaction.getId(),
                    transaction.getAmount(),
                    transaction.getTransactionType(),
                    transaction.getDate()));
        });
        return transactionDtos;
    }

    public static TransactionDto toUserDto(Transaction transaction){
        return new TransactionDto(transaction.getId(),
                transaction.getAmount(),
                transaction.getTransactionType(),
                transaction.getDate());
    }

    public static Transaction toEntity(TransactionDto transactionDto){
        return new Transaction(transactionDto.getId(),
                transactionDto.getAmount(),
                transactionDto.getTransactionType(),
                transactionDto.getDate(),
                null);
    }

    public static List<Transaction> toEntity(List<TransactionDto> transactionDtos){
        List<Transaction> transactions= new ArrayList<>();
        transactionDtos.forEach(transactionDto -> {
            transactions.add(new Transaction(transactionDto.getId(),
                    transactionDto.getAmount(),
                    transactionDto.getTransactionType(),
                    transactionDto.getDate(),
                    null));
        });
        return transactions;
    }
}
