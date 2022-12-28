package com.brehon.week_10_practice_java_atm_spring.service.impl;

import com.brehon.week_10_practice_java_atm_spring.exceptions.NotFoundException;
import com.brehon.week_10_practice_java_atm_spring.mapper.BaseMapper;
import com.brehon.week_10_practice_java_atm_spring.service.BaseService;
import jakarta.validation.Valid;

import java.util.List;


public abstract class BaseCrud <E,D,M extends BaseMapper,R extends org.springframework.data.jpa.repository.JpaRepository,N extends Number>  implements BaseService<D,N> {

    protected final M mapper;

    protected final R repository;



    protected BaseCrud(M mapper, R repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<D> findAll(){
        return mapper.toDto(repository.findAll());
    }

    public D findById(N id)throws NotFoundException{
        return (D) mapper.toDto(repository.findById(id));
    }

    public D saveOrUpdate(@Valid D dto){
       E e = (E) repository.save(mapper.toEntity(dto));
       return (D) mapper.toDto(e);
    }

    public void delete(@Valid D dto){
        repository.delete(mapper.toEntity(dto));
    }


    public void deleteById(N id){
        repository.deleteById(id);
    }
}
