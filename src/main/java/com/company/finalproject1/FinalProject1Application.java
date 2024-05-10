package com.company.finalproject1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class FinalProject1Application {

    public static void main(String[] args) {
        SpringApplication.run(FinalProject1Application.class, args);
    }

}
