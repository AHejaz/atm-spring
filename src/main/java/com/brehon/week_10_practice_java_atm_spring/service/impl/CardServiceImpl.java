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
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    private final CardMapper cardMapper;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }


    @Override
    public void saveOrUpdate(CardDto dto) {
        cardRepository.save(cardMapper.toEntity(dto));
    }

    @Override
    public CardDto createCard(CardDto dto){
        Card card = cardMapper.toEntity(dto);
        return cardMapper.toDto(cardRepository.save(card));
    }

    @Override
    public CardDto findById(Long id) {
        return cardMapper.toDto(cardRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("card Not Found!");
        }));
    }

    @Override
    public CardDto findByCardNumber(String cardNumber) {
        return cardMapper.toDto(cardRepository.findByCardNumber(cardNumber).orElseThrow(()->{
            throw new NotFoundException("card Not Found!");
        }));
    }


    @Override
    public List<CardDto> findAll() {
        return cardMapper.toDto(cardRepository.findAll());
    }



    @Override
    public void delete(CardDto dto) {
        cardRepository.delete(cardMapper.toEntity(dto));
    }

    @Override
    public void deleteById(Long id) {
        cardRepository.deleteById(id);
    }
}
