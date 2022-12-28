package com.brehon.week_10_practice_java_atm_spring;

import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import com.brehon.week_10_practice_java_atm_spring.entity.User;
import com.brehon.week_10_practice_java_atm_spring.entity.enums.AccountType;
import com.brehon.week_10_practice_java_atm_spring.entity.enums.TransactionType;
import com.brehon.week_10_practice_java_atm_spring.mapper.AccountMapper;
import com.brehon.week_10_practice_java_atm_spring.mapper.TransactionMapper;
import com.brehon.week_10_practice_java_atm_spring.mapper.UserMapper;
import com.brehon.week_10_practice_java_atm_spring.service.AccountService;
import com.brehon.week_10_practice_java_atm_spring.service.TransactionService;
import com.brehon.week_10_practice_java_atm_spring.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class Week10PracticeJavaAtmSpringApplication implements ApplicationRunner {


    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private TransactionMapper transactionMapper;
    public static void main(String[] args) {
        SpringApplication.run(Week10PracticeJavaAtmSpringApplication.class, args);
    }
    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {


//        User user = new User("milad","ghasemi","12345678900", LocalDate.of(1998,10,20));
//
//        userService.createUser(userMapper.toDto(user));
////        user.setId(userService.findByNationalCode("564645").get().getId());
//        List<Transaction> transactions = new ArrayList<>();
//
////        transactionService.createTransaction(new Transaction(10d, TransactionType.WITHDRAW));
////        transactionService.save(new Transaction(30d, TransactionType.WITHDRAW));
////        transactionService.save(new Transaction(50d, TransactionType.DEPOSIT));
//
//        Account account = new Account(user,"bikh", AccountType.getAccountType(3));
//        account.setTransactions(transactions);
//        accountService.createAccount(accountMapper.toDto(account));
//
//        transactionService.createTransaction(transactionMapper.toDto(new Transaction(null,100d,TransactionType.DEPOSIT, LocalDate.now(),account)));
//
////        System.out.println(accountService.findAll());


    }
}
