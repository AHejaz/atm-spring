package com.brehon.week_10_practice_java_atm_spring.entity;

import com.brehon.week_10_practice_java_atm_spring.entity.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account_number",nullable = false,length = 20)
    private String accountNumber;

    @Column(name = "password",nullable = false,length = 20)
    private String password;

    @Column(name = "balance",nullable = false)
    private Double balance;

    @Column(name = "account_type",nullable = false,columnDefinition = "enum('JARI','SEPORDE','GHARZOL_HASANE')")
    @Enumerated(EnumType.ORDINAL)
    private AccountType type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private Card card;

    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    private List<Transaction> transactions;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", type=" + type +
                ", user=" + user +
                ", card=" + card +
                '}';
    }
}
