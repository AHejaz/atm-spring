package com.brehon.week_10_practice_java_atm_spring.entity;

import com.brehon.week_10_practice_java_atm_spring.entity.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "transaction_type", nullable = false,columnDefinition = "enum( 'DEPOSIT', 'WITHDRAW')")
    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;

    public Transaction(Double amount, TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.date = new Date();
    }

}
