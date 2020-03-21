package com.project.demo;

import com.project.demo.config.FeignInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @description:
 * @author: YZL
 * @time: 2020/3/20 4:38
 */
@EnableTransactionManagement
@EnableFeignClients
@EnableCircuitBreaker
@EnableEurekaClient
@MapperScan("com.project.demo.dao")
@EnableRedisHttpSession
@SpringBootApplication(scanBasePackages = {"com.project.demo"})
public class BlockUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlockUserApplication.class, args);
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
