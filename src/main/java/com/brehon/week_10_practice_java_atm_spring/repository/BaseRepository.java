package com.brehon.week_10_practice_java_atm_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<E,N> extends JpaRepository<E,N> {
}
