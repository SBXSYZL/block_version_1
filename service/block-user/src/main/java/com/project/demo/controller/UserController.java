package com.project.demo.controller;


import com.project.demo.error.BusinessException;
import com.project.demo.error.EmBusinessErr;
import com.project.demo.response.CommonReturnType;
import com.project.demo.response.RTStr;
import com.project.demo.service.UserService;
import com.project.demo.utils.MySessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description:
 * @author: YZL
 * @time: 2020/3/19 11:58
 */

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    private final UserService userService;
    private final DiscoveryClient client;
    private final HttpServletRequest httpServletRequest;

    public UserController(UserService userService, DiscoveryClient client, HttpServletRequest httpServletRequest) {
        this.userService = userService;
        this.client = client;
        this.httpServletRequest = httpServletRequest;
    }


    @RequestMapping("/test")
    public CommonReturnType test() {
        return CommonReturnType.create(RTStr.SUCCESS);
    }

    @PostMapping("/login")
    public CommonReturnType login(@RequestParam("email") String email,
                                  @RequestParam("password") String password) throws BusinessException {
        return CommonReturnType.create(userService.login(email, password));
    }

    @PostMapping("/registered")
    public CommonReturnType registered(@RequestParam("name") String name,
                                       @RequestParam("email") String email,
                                       @RequestParam("password") String password) throws BusinessException {
        userService.registered(name, email, password);
        return CommonReturnType.create(RTStr.SUCCESS);

    }

    @GetMapping("/getUserInfo")
    public CommonReturnType getUserInfo() throws BusinessException {
        Object attribute = MySessionUtil.getSession().getAttribute(MySessionUtil.USER_EMAIL);
        System.out.println(MySessionUtil.getSession().getId());
        if (attribute != null) {
            String email = (String) attribute;
            System.out.println(email);

            return CommonReturnType.create(userService.getUserInfo(email));
        } else {
            throw new BusinessException(EmBusinessErr.GET_INFO_ERROR);
        }

    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = client.getServices();
        System.out.println("discovery=>service: " + services);
        //得到一个具体的微服务信息,通过具体的微服务id，applicationName
        List<ServiceInstance> instances = client.getInstances("EUREKA-CLIENT-BLOCK-USER");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                            instance.getPort() + "\t" +
                            instance.getUri() + "\t" +
                            instance.getServiceId()
            );
        }
        return this.client;
    }
}
