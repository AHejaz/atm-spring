package com.brehon.week_10_practice_java_atm_spring.repository;

import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends BaseRepository<Transaction,Long> {

    Page<Transaction> findByAccount_Card_CardNumberOrderByDateDesc(String cardNumber,Pageable pageable);
}
