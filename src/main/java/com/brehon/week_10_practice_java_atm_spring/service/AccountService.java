package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import com.brehon.week_10_practice_java_atm_spring.entity.User;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    void save(Account account);

    Optional<Account> findById(Long id);


    List<Account> findAll();

    void update(Account account);

    void delete(Account account);

    void deleteById(Long id);
}
