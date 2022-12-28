package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.dto.CardDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Card;

import java.util.List;
import java.util.Optional;

public interface CardService extends BaseService<CardDto,Long>{

    CardDto findByCardNumber(String cardNumber);

}
