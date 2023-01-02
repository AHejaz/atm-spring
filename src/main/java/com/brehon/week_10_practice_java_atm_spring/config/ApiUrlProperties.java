package com.brehon.week_10_practice_java_atm_spring.config;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class ApiUrlProperties {

    private List<String> publicUrl;

    public ApiUrlProperties() {
        publicUrl = new ArrayList<>();
        publicUrl.add("/account/login");
        publicUrl.add("/account/register");
    }
}
