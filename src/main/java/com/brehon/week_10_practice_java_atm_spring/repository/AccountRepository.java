package com.brehon.week_10_practice_java_atm_spring.repository;

import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
