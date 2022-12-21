package com.brehon.week_10_practice_java_atm_spring.service.impl;

import com.brehon.week_10_practice_java_atm_spring.entity.Card;
import com.brehon.week_10_practice_java_atm_spring.exceptions.NotFoundException;
import com.brehon.week_10_practice_java_atm_spring.repository.CardRepository;
import com.brehon.week_10_practice_java_atm_spring.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    @Override
    public void save(Card card) {
        cardRepository.save(card);
    }

    @Override
    public void createCard(String password){
        Card card = new Card(password);
        cardRepository.save(card);
    }

    @Override
    public Card findById(Long id) {
        return cardRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("card Not Found!");
        });
    }

    @Override
    public Optional<Card> findByCardNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }


    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public void update(Card card) {
        if (cardRepository.existsById(card.getId()))
            cardRepository.save(card);
    }

    @Override
    public void delete(Card card) {
        cardRepository.delete(card);
    }

    @Override
    public void deleteById(Long id) {
        cardRepository.deleteById(id);
    }
}
