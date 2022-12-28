package com.brehon.week_10_practice_java_atm_spring.service.impl;

import com.brehon.week_10_practice_java_atm_spring.dto.UserDto;
import com.brehon.week_10_practice_java_atm_spring.entity.User;
import com.brehon.week_10_practice_java_atm_spring.exceptions.AgeException;
import com.brehon.week_10_practice_java_atm_spring.exceptions.InvalidInputException;
import com.brehon.week_10_practice_java_atm_spring.exceptions.NotFoundException;
import com.brehon.week_10_practice_java_atm_spring.mapper.UserMapper;
import com.brehon.week_10_practice_java_atm_spring.repository.UserRepository;
import com.brehon.week_10_practice_java_atm_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl extends BaseCrud<User,UserDto,UserMapper,UserRepository,Long>implements UserService {



    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        super(userMapper,userRepository);
    }

    @Override
    public UserDto createUser(UserDto userDto){
        if (repository.findByNationalCode(userDto.getNationalCode()).isPresent())
            throw new InvalidInputException("this user already exist!");
        if (LocalDate.now().getYear() - userDto.getBirthday().getYear()< 18)
            throw new AgeException();

        User user = mapper.toEntity(userDto);
        return mapper.toDto(repository.save(user));
    }


    @Override
    public UserDto findByNationalCode(String nationalCode) {
        User user= repository.findByNationalCode(nationalCode).orElseThrow(()->
                {throw new NotFoundException("account with this nationalCode not found");
                });
        return mapper.toDto(user);
    }
}
