package com.brehon.week_10_practice_java_atm_spring.mapper;

import com.brehon.week_10_practice_java_atm_spring.dto.TransactionDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring" )
public interface TransactionMapper extends BaseMapper<Transaction,TransactionDto>{

//    @Mapping(target = "account", source = "accountDto")
//    Transaction toTransaction(TransactionDto transactionDto);
//
//    @Mapping(source = "account",target = "accountDto")
//    TransactionDto toTransactionDto(Transaction transaction);
//
//    List<TransactionDto> toTransactionDto(List<Transaction> transactions);
//
//    List<Transaction> toTransaction(List<TransactionDto> transactionDtos);
}
