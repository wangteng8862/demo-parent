package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.dao")
public class WebStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebStartApplication.class, args);
    }
}
