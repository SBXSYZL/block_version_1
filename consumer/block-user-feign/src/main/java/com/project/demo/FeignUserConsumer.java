package com.project.demo;

import com.project.demo.config.FeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.request.RequestContextListener;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description:
 * @author: YZL
 * @time: 2020/3/20 0:10
 */

@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.project.demo"})
public class FeignUserConsumer {
    public static void main(String[] args) {
        SpringApplication.run(FeignUserConsumer.class, args);
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    @Bean
    public FeignInterceptor getFeignInterceptor() {
        return new FeignInterceptor();
    }
}
