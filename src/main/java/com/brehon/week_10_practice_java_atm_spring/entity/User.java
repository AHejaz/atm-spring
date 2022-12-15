package com.brehon.week_10_practice_java_atm_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name",nullable = false,length = 20)
    private String name;

    @Column(name = "family",nullable = false,length = 30)
    private String family;

    @Column(name = "age",nullable = false)
    private Integer age;

    @Column(name = "national_code",nullable = false,length = 11,unique = true)
    private String nationalCode;

    @Column(name = "birthday",nullable = false,length = 11)
    private LocalDate birthday;

    public User( String name, String family, String nationalCode, LocalDate birthday) {
        this.id = null;
        this.name = name;
        this.family = family;
        this.age = LocalDate.now().getYear()- birthday.getYear();
        this.nationalCode = nationalCode;
        this.birthday = birthday;
    }
}
