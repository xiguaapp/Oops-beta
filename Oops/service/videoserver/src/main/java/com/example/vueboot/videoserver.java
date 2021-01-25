package com.example.vueboot;

import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages ="com.example")
@MapperScan(basePackages ="com.example.vueboot.dao")
public class videoserver {
    public static void main(String[] args) {
        SpringApplication.run(videoserver.class, args);
    }
}