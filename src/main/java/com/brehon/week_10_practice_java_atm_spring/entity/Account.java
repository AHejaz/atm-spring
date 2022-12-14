package com.brehon.week_10_practice_java_atm_spring.entity;

import com.brehon.week_10_practice_java_atm_spring.entity.enums.AccountType;
import com.brehon.week_10_practice_java_atm_spring.entity.enums.TransactionType;
import com.brehon.week_10_practice_java_atm_spring.exceptions.InvalidAmountException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account extends AuditingField{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account_number",nullable = false,length = 20,unique = true)
    private String accountNumber;

    @Column(name = "password",nullable = false,length = 20)
    private String password;

    @Column(name = "balance",nullable = false,columnDefinition = "double default 100")
    private Double balance;

    @Column(name = "account_type",nullable = false,columnDefinition = "enum('JARI','SEPORDE','GHARZOL_HASANE')")
    @Enumerated(value = EnumType.STRING)
    private AccountType type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id",nullable = false)
    private Card card;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonDeserialize
    private List<Transaction> transactions;

    public Account(User user, String password, AccountType type) {
        Random random = new Random();
        this.id = null;
        this.user = user;
        this.accountNumber = String.valueOf(random.nextLong(10000000, 999999999));
        this.password = password;
        this.balance = 100d;
        this.type = type;
        this.card = new Card(password);
        this.transactions = new ArrayList<>();
    }



    public void deposit(Double amount) {
        this.balance += amount;
        Transaction transaction = new Transaction(amount, TransactionType.DEPOSIT);
        if (Objects.isNull(transactions))
            transactions = new ArrayList<>();
        transactions.add(transaction);
    }

    public void withDraw(Double amount) {
        if (amount < this.balance) {
            this.balance = this.balance - amount;
            Transaction transaction = new Transaction(amount, TransactionType.WITHDRAW);
            if (Objects.isNull(transactions))
                transactions = new ArrayList<>();
            transactions.add(transaction);
        } else
            throw new InvalidAmountException();
    }
}
