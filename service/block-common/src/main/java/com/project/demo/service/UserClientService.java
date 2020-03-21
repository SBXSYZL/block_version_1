package com.project.demo.service;

import com.project.demo.error.BusinessException;
import com.project.demo.response.CommonReturnType;
import javafx.util.Pair;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "EUREKA-CLIENT-BLOCK-USER",
        fallback = UserClientHystrix.class)
public interface UserClientService {

    @PostMapping("/user/login")
    CommonReturnType login(@RequestParam("email") String email, @RequestParam("password") String password) throws BusinessException;

    @PostMapping("/user/registered")
    CommonReturnType registered(@RequestParam("name") String name,
                                @RequestParam("email") String email,
                                @RequestParam("password") String password) throws BusinessException;

    @GetMapping("/user/getUserInfo")
    CommonReturnType getUserInfo() throws BusinessException;
}
