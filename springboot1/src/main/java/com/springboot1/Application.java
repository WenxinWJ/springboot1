package com.springboot1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 说明是一个 Spring Boot 应用程序
@SpringBootApplication
@MapperScan("com.springboot1.mapper")   // 扫描器(扫描mapper)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
