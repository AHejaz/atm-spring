package com.brehon.week_10_practice_java_atm_spring.controller;

import com.brehon.week_10_practice_java_atm_spring.dto.CardDto;
import com.brehon.week_10_practice_java_atm_spring.mapper.CardMapper;
import com.brehon.week_10_practice_java_atm_spring.service.CardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("card")
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;

    @Autowired
    public CardController(CardService cardService, CardMapper cardMapper) {
        this.cardService = cardService;
        this.cardMapper = cardMapper;
    }

    @GetMapping("/")
    public List<CardDto> findAll(){
        return cardMapper.toDto(cardService.findAll());
    }

    @GetMapping("")
    public CardDto findById(@RequestParam(name = "id")Long id){
        return cardMapper.toDto(cardService.findById(id));
    }

    @PostMapping
    public void save(@RequestBody @Valid CardDto cardDto){
        cardService.save(cardMapper.toEntity(cardDto));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id")Long id){
        cardService.deleteById(id);
    }
}
