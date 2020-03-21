package com.project.demo.service;

import com.project.demo.error.BusinessException;
import com.project.demo.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface UserService {
    String login(String email, String password) throws BusinessException;

    void registered(String name, String email, String password) throws BusinessException;

    UserVO getUserInfo(String email) throws BusinessException;

}
