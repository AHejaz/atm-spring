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
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto){
        if (userRepository.findByNationalCode(userDto.getNationalCode()).isPresent())
            throw new InvalidInputException("this user already exist!");
        if (LocalDate.now().getYear() - userDto.getBirthday().getYear()< 18)
            throw new AgeException();

        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(user));
    }



    @Override
    public UserDto findById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("user not found");
        }));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDto(userRepository.findAll());
    }


    @Override
    public void delete(UserDto user) {
        userRepository.delete(userMapper.toEntity(user));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto findByNationalCode(String nationalCode) {
        User user= userRepository.findByNationalCode(nationalCode).orElseThrow(()->
                {throw new NotFoundException("account with this nationalCode not found");
                });
        return userMapper.toDto(user);
    }
}
