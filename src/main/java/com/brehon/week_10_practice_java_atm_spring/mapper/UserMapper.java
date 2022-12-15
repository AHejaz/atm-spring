package com.brehon.week_10_practice_java_atm_spring.mapper;


import com.brehon.week_10_practice_java_atm_spring.dto.UserDto;
import com.brehon.week_10_practice_java_atm_spring.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static List<UserDto> toUserDto(List<User> users){
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            userDtos.add(new UserDto(user.getId(), user.getName(), user.getFamily(), user.getAge(),
                    user.getNationalCode(),user.getBirthday()));
        });
        return userDtos;
    }

    public static UserDto toUserDto(User user){
        return new UserDto(user.getId(), user.getName(), user.getFamily(),
                user.getAge(), user.getNationalCode(), user.getBirthday());
    }

    public static User toEntity(UserDto userDto){
        return new User(userDto.getId(), userDto.getName(), userDto.getFamily(),
                userDto.getAge(), userDto.getNationalCode(), userDto.getBirthday());
    }

    public static List<User> toEntity(List<UserDto> userDtos){
        List<User> users = new ArrayList<>();
        userDtos.forEach(userDto -> {
            users.add(new User(userDto.getId(), userDto.getName(), userDto.getFamily(), userDto.getAge(),
                    userDto.getNationalCode(),userDto.getBirthday()));
        });
        return users;
    }

}
