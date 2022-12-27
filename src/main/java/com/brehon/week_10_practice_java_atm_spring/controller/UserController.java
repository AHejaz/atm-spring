package com.brehon.week_10_practice_java_atm_spring.controller;

import com.brehon.week_10_practice_java_atm_spring.dto.UserDto;
import com.brehon.week_10_practice_java_atm_spring.mapper.UserMapper;
import com.brehon.week_10_practice_java_atm_spring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;



    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll(){
        List<UserDto> dtoList =  userService.findAll();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable(name = "id") Long id){
        UserDto dto =  userService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/n")
    public ResponseEntity<UserDto> findByNationalCode(@RequestParam(name = "national_code") String nationalCode){
        UserDto dto =  userService.findByNationalCode(nationalCode);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UserDto>  save(@RequestBody @Valid UserDto userDto){
        UserDto dto = userService.createUser(userDto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id){
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
