package com.brehon.week_10_practice_java_atm_spring.mapper;

import com.brehon.week_10_practice_java_atm_spring.dto.CardDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardDto toCardDto(Card card);

    Card toCard(CardDto cardDto);

    List<CardDto> toCardDto(List<Card> cards);

    List<Card> toCard(List<CardDto> cards);
}
