package com.wangdakeji.wongder.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.wangdakeji.wongder"})
public class WongderRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WongderRestApplication.class, args);
    }
}
