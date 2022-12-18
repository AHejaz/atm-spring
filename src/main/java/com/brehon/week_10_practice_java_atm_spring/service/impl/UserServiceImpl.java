package com.brehon.week_10_practice_java_atm_spring.service.impl;

import com.brehon.week_10_practice_java_atm_spring.entity.User;
import com.brehon.week_10_practice_java_atm_spring.exceptions.AgeException;
import com.brehon.week_10_practice_java_atm_spring.exceptions.InvalidInputException;
import com.brehon.week_10_practice_java_atm_spring.exceptions.NotFoundException;
import com.brehon.week_10_practice_java_atm_spring.repository.UserRepository;
import com.brehon.week_10_practice_java_atm_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String name, String family, String nationalCode, LocalDate birthday){
        if (userRepository.findByNationalCode(nationalCode).isPresent())
            throw new InvalidInputException("this user already exist!");
        if (LocalDate.now().getYear() - birthday.getYear()< 18)
            throw new AgeException();

        User user = new User(name,family,nationalCode,birthday);
        userRepository.save(user);
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(User user) {
        if (userRepository.existsById(user.getId()))
            userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByNationalCode(String nationalCode) {
        return userRepository.findByNationalCode(nationalCode).orElseThrow(()->
                {throw new NotFoundException("account with this nationalCode not found");
                });
    }
}
