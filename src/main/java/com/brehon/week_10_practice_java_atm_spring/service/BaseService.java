package com.brehon.week_10_practice_java_atm_spring.service;

import com.brehon.week_10_practice_java_atm_spring.exceptions.NotFoundException;
import jakarta.validation.Valid;

import java.util.List;

public interface BaseService <D,N>{

    List<D> findAll();

    D findById(N id)throws NotFoundException ;

    D saveOrUpdate(@Valid D dto);

    void delete(@Valid D dto);


    void deleteById(N id);
}
