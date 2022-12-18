package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(String name, String family, String nationalCode, LocalDate birthday);

    void save(User user);

    Optional<User> findById(Long id);


    List<User> findAll();

    void update(User user);

    void delete(User user);

    void deleteById(Long id);

    User findByNationalCode(String nationalCode);
}
