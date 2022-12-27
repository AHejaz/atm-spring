package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.dto.UserDto;
import com.brehon.week_10_practice_java_atm_spring.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto userDto);


    UserDto findById(Long id);


    List<UserDto> findAll();

    void delete(UserDto user);

    void deleteById(Long id);

    UserDto findByNationalCode(String nationalCode);
}
