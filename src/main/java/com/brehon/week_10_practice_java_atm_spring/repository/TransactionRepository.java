package com.brehon.week_10_practice_java_atm_spring.repository;

import com.brehon.week_10_practice_java_atm_spring.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
