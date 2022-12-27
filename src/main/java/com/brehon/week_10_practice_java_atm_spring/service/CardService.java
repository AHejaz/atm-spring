package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.dto.CardDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Card;

import java.util.List;
import java.util.Optional;

public interface CardService {
    void saveOrUpdate(CardDto dto);

    CardDto createCard(CardDto dto);

    CardDto findById(Long id);

    CardDto findByCardNumber(String cardNumber);

    List<CardDto> findAll();


    void delete(CardDto dto);


    void deleteById(Long id);
}
