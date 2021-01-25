package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//订单模块
@SpringBootApplication
@MapperScan(basePackages ="com.example.repositry")
@EnableDiscoveryClient
public class IndentApplication {
    public static void main(String[] args) {
        SpringApplication.run(IndentApplication.class, args);
    }
}