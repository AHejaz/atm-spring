package com.brehon.week_10_practice_java_atm_spring.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@MappedSuperclass
@Data
public class AuditingField {
    @CreatedDate
    private Date createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private Date updateAt;

}
