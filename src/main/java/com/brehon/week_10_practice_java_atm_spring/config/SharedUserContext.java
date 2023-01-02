package com.brehon.week_10_practice_java_atm_spring.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SharedUserContext {

    private Long userId;

    private String nationalCode;

    private String accountNumber;
}
