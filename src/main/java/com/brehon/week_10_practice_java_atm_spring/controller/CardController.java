package com.brehon.week_10_practice_java_atm_spring.controller;

import com.brehon.week_10_practice_java_atm_spring.dto.CardDto;
import com.brehon.week_10_practice_java_atm_spring.mapper.CardMapper;
import com.brehon.week_10_practice_java_atm_spring.service.CardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("card")
public class CardController {

    private final CardService cardService;


    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CardDto>> findAll(){
        List<CardDto> dtoList = cardService.findAll();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDto> findById(@PathVariable(name = "id")Long id){
        CardDto cardDto= cardService.findById(id);
        return ResponseEntity.ok(cardDto);
    }

    @PostMapping
    public ResponseEntity<CardDto> save(@RequestBody @Valid CardDto cardDto){
        CardDto card=cardService.saveOrUpdate(cardDto);
        return ResponseEntity.ok(card);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id")Long id){
        cardService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
