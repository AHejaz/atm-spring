package com.brehon.week_10_practice_java_atm_spring.entity.enums;

import com.brehon.week_10_practice_java_atm_spring.exceptions.InvalidInputException;

public enum RoleType {

    ROLE_USER(1),
    ROLE_ADMIN(2);

    private Integer value;

    RoleType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static RoleType getTransactionType(Integer value){
        for (RoleType roleType :
                values()) {
            if (roleType.getValue().equals(value))
                return roleType;
        }
        throw new InvalidInputException("invalid value");
    }
}
