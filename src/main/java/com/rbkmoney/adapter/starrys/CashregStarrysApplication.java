package com.rbkmoney.adapter.starrys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class CashregStarrysApplication extends SpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(CashregStarrysApplication.class, args);
    }
}
