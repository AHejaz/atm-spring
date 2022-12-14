package com.brehon.week_10_practice_java_atm_spring.mapper;

import com.brehon.week_10_practice_java_atm_spring.dto.AccountDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class,CardMapper.class,TransactionMapper.class} )
public interface AccountMapper  extends BaseMapper<Account,AccountDto>{


//    @Mapping(source = "user",target = "userDto")
//    @Mapping(source = "card",target = "cardDto")
//    @Mapping(source = "transactions",target = "transactionDtos")
//    AccountDto toAccountDto(Account account);
//
//
//    @Mapping(target = "user",source = "userDto")
//    @Mapping(target = "card",source = "cardDto")
//    @Mapping(target = "transactions",source = "transactionDtos")
//    Account toAccount(AccountDto accountDto);
//
//    List<AccountDto> toAccountDto(List<Account> accounts);
//
//    List<Account> toAccount(List<AccountDto> accountDtos);
}
