package com.project.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description:
 * @author: YZL
 * @time: 2020/3/20 23:07
 */
@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.project.demo"})
public class FeignBlockConsumer {
    public static void main(String[] args) {
        SpringApplication.run(FeignBlockConsumer.class, args);
    }
}
