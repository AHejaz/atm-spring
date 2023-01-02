package com.brehon.week_10_practice_java_atm_spring.entity;

import com.brehon.week_10_practice_java_atm_spring.entity.enums.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role",length = 20)
    private RoleType role;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
