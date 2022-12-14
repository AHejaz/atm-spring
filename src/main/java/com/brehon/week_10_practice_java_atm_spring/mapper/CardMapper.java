package com.brehon.week_10_practice_java_atm_spring.mapper;

import com.brehon.week_10_practice_java_atm_spring.dto.CardDto;
import com.brehon.week_10_practice_java_atm_spring.entity.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper extends BaseMapper<Card,CardDto> {


}
