package com.project.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description:
 * @author: YZL
 * @time: 2020/3/20 23:01
 */
@EnableTransactionManagement
@EnableFeignClients
@EnableCircuitBreaker
@EnableEurekaClient
@MapperScan("com.project.demo.dao")
@SpringBootApplication(scanBasePackages = {"com.project.demo"})
public class BlockBlockApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlockBlockApplication.class, args);
    }
}
