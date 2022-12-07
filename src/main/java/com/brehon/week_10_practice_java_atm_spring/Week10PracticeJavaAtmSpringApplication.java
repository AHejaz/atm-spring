package com.brehon.week_10_practice_java_atm_spring;

import com.brehon.week_10_practice_java_atm_spring.controller.ATM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week10PracticeJavaAtmSpringApplication implements ApplicationRunner {

    @Autowired
    private ATM atm;

    public static void main(String[] args) {
        SpringApplication.run(Week10PracticeJavaAtmSpringApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        atm.run();
    }
}
