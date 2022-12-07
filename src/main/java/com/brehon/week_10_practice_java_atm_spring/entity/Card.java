package com.brehon.week_10_practice_java_atm_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Random;

@Entity
@Table(name = "card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "card_number", nullable = false, length = 16)
    private String cardNumber;

    @Column(name = "password", nullable = false, length = 18)
    private String password;

    @Column(name = "cvv2", nullable = false, length = 4)
    private String cvv2;

    @Column(name = "expire_date", nullable = false)
    private LocalDate expireDate;

    private static final  String PRE_FIX = "50470610";

    public Card(String password) {
        Random random = new Random();
        this.cardNumber = PRE_FIX + random.nextInt(10000000,99999999);
        this.cvv2 = String.valueOf(random.nextInt(1000,9999));
        this.expireDate = LocalDate.now().plusYears(5);
        this.password = password;
    }
}
