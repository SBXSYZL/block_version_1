package com.project.demo.controller;

import com.project.demo.error.BusinessException;
import com.project.demo.response.CommonReturnType;
import com.project.demo.response.RTStr;
import com.project.demo.service.UserClientService;
import com.project.demo.utils.MySessionUtil;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: YZL
 * @time: 2020/3/20 0:14
 */
@RestController
@RequestMapping("/user")
public class UserConsumerController extends BaseController {
    private final UserClientService service;

    public UserConsumerController(UserClientService service) {
        this.service = service;
    }


    @PostMapping("/login")
    public CommonReturnType login(@RequestParam("email") String email, @RequestParam("password") String password) throws BusinessException {
        System.out.println("Feign request" + MySessionUtil.getSession().getId());
        return service.login(email, password);
    }

    @PostMapping("/registered")
    public CommonReturnType registered(@RequestParam("name") String name,
                                       @RequestParam("email") String email,
                                       @RequestParam("password") String password) throws BusinessException {
        return service.registered(name, email, password);
    }

    @GetMapping("/test")
    public CommonReturnType test() {
        return CommonReturnType.create(RTStr.SUCCESS);
    }

    @GetMapping("/getUserInfo")
    public CommonReturnType getUserInfo() throws BusinessException {
        System.out.println("Feign request" + MySessionUtil.getSession().getId());
        return service.getUserInfo();
    }
}
