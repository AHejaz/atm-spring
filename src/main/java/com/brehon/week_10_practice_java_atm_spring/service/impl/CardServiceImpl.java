package com.brehon.week_10_practice_java_atm_spring.service.impl;

import com.brehon.week_10_practice_java_atm_spring.dto.CardDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Card;
import com.brehon.week_10_practice_java_atm_spring.exceptions.NotFoundException;
import com.brehon.week_10_practice_java_atm_spring.mapper.CardMapper;
import com.brehon.week_10_practice_java_atm_spring.repository.CardRepository;
import com.brehon.week_10_practice_java_atm_spring.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl extends BaseCrud<Card,CardDto,CardMapper,CardRepository,Long>implements CardService {


    @Autowired
    public CardServiceImpl(CardRepository cardRepository, CardMapper cardMapper) {
        super(cardMapper, cardRepository);
    }

    @Override
    public CardDto findByCardNumber(String cardNumber) {
        return mapper.toDto(repository.findByCardNumber(cardNumber).orElseThrow(() -> {
            throw new NotFoundException("card Not Found!");
        }));
    }
}

