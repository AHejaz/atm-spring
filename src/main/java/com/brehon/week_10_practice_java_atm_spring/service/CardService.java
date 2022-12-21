package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.entity.Card;

import java.util.List;
import java.util.Optional;

public interface CardService {
    void save(Card card);

    void createCard(String password);

    Card findById(Long id);

    Optional<Card> findByCardNumber(String cardNumber);

    List<Card> findAll();

    void update(Card card);

    void delete(Card card);


    void deleteById(Long id);
}
