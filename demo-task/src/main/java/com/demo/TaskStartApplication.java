package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.dao")
//@EnableDubbo
public class TaskStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskStartApplication.class, args);
    }
}
