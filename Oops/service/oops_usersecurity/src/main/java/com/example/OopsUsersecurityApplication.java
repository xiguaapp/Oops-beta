package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages ="com.example.dao")
@EnableFeignClients(basePackages = "com.example")
public class OopsUsersecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(OopsUsersecurityApplication.class, args);
    }
}