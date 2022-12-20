package com.brehon.week_10_practice_java_atm_spring.mapper;


import com.brehon.week_10_practice_java_atm_spring.dto.UserDto;
import com.brehon.week_10_practice_java_atm_spring.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDto userDto);

    UserDto toUserDto(User user);

    List<User> toUser(List<UserDto> userDto);

    List<UserDto> toUserDto(List<User> user);

}
