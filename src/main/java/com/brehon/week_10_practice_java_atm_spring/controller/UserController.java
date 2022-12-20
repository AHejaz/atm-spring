package com.brehon.week_10_practice_java_atm_spring.controller;

import com.brehon.week_10_practice_java_atm_spring.dto.UserDto;
import com.brehon.week_10_practice_java_atm_spring.mapper.UserMapper;
import com.brehon.week_10_practice_java_atm_spring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/")
    public List<UserDto> findAll(){
        return userMapper.toUserDto(userService.findAll());
    }

    @GetMapping("/d")
    public UserDto findById(@RequestParam(name = "id") Long id){
        return userMapper.toUserDto(userService.findById(id).orElseThrow());
    }

    @GetMapping("/n")
    public UserDto findByNationalCode(@RequestParam(name = "national_code") String nationalCode){
        return userMapper.toUserDto(userService.findByNationalCode(nationalCode));
    }

    @PostMapping
    public void  save(@RequestBody @Valid UserDto userDto){
        userService.save(userMapper.toUser(userDto));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        userService.deleteById(id);
    }
}
