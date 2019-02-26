package com.demo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class ApiStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiStartApplication.class, args);
	}

}
