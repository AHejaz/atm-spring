package com.brehon.week_10_practice_java_atm_spring.entity.enums;


import com.brehon.week_10_practice_java_atm_spring.exceptions.InvalidInputException;

public enum TransactionType {
    DEPOSIT(1),WITHDRAW(2);
    private Integer value;

    TransactionType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
    public static TransactionType getTransactionType(Integer value){
        for (TransactionType transactionType :
                values()) {
            if (transactionType.getValue().equals(value))
                return transactionType;
        }
        throw new InvalidInputException("invalid value");
    }
}
