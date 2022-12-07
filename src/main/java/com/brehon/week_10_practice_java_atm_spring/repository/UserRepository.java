package com.brehon.week_10_practice_java_atm_spring.repository;

import com.brehon.week_10_practice_java_atm_spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
