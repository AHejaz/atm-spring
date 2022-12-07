package com.brehon.week_10_practice_java_atm_spring;

import com.brehon.week_10_practice_java_atm_spring.controller.ATM;
import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import com.brehon.week_10_practice_java_atm_spring.entity.User;
import com.brehon.week_10_practice_java_atm_spring.entity.enums.AccountType;
import com.brehon.week_10_practice_java_atm_spring.service.AccountService;
import com.brehon.week_10_practice_java_atm_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Week10PracticeJavaAtmSpringApplication implements ApplicationRunner {

    @Autowired
    private ATM atm;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(Week10PracticeJavaAtmSpringApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        atm.run();

//        User user = new User("milad","ghasemi","564645", LocalDate.now());
//        userService.save(user);
//        System.out.println(userService.findByNationalCode("85236974100").get());
//        Account account = new Account(user,"bikh", AccountType.getAccountType(3));
//        accountService.save(account);
//
//        System.out.println(accountService.findAll());

    }
}
