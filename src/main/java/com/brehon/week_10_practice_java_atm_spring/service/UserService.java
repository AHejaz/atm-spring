package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.dto.UserDto;
import com.brehon.week_10_practice_java_atm_spring.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserService extends BaseService<UserDto,Long>{

    UserDto createUser(UserDto userDto);

    UserDto findByNationalCode(String nationalCode);
}
