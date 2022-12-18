package com.brehon.week_10_practice_java_atm_spring.entity;

import com.brehon.week_10_practice_java_atm_spring.entity.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id",nullable = false)
    private Account account;

    public Transaction(Double amount, TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.date = LocalDate.now();
    }

    @PrePersist
    public void beforePersistDate(){
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", date=" + date +
                '}';
    }
}
