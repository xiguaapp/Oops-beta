package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan(basePackages = "com.example.repositry")
@SpringBootApplication
@EnableDiscoveryClient
public class OopsGifserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(OopsGifserverApplication.class, args);
    }
}
