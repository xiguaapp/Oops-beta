package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages = "com.example.dao")
@EnableDiscoveryClient
public class SolrserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(SolrserverApplication.class, args);
    }
}
