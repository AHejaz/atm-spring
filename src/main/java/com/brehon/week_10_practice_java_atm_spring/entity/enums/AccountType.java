package com.brehon.week_10_practice_java_atm_spring.entity.enums;


import com.brehon.week_10_practice_java_atm_spring.exceptions.InvalidInputException;

public enum AccountType {
    GHARZOL_HASANE(3),JARI(1),SEPORDE(2);

    private Integer value;

    AccountType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static AccountType getAccountType(Integer value){
        for (AccountType accountType :
                values()) {
            if (accountType.getValue().equals(value))
                return accountType;
        }
        throw new InvalidInputException("invalid value");
    }
}
