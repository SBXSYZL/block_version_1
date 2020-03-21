package com.project.demo.service.Impl;

import com.netflix.client.http.HttpRequest;
import com.netflix.ribbon.proxy.annotation.Http;
import com.project.demo.DO.UserDO;
import com.project.demo.dao.TablesMapper;
import com.project.demo.dao.UserDOMapper;
import com.project.demo.error.BusinessException;
import com.project.demo.error.EmBusinessErr;
import com.project.demo.service.TableService;
import com.project.demo.service.UserService;
import com.project.demo.utils.MD5Util;
import com.project.demo.utils.MySessionUtil;
import com.project.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description:
 * @author: YZL
 * @time: 2020/3/20 0:18
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDOMapper userDOMapper;
    private final TableService tableService;
    private final RedisCacheManager redisCacheManager;
    private final HttpServletRequest httpServletRequest;

    public UserServiceImpl(UserDOMapper userDOMapper, TablesMapper tablesMapper, RedisCacheManager redisCacheManager, TableService tableService, HttpServletRequest httpServletRequest) {
        this.userDOMapper = userDOMapper;
        this.redisCacheManager = redisCacheManager;
        this.tableService = tableService;
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public String login(String email, String password) throws BusinessException {
        try {
            List<String> tables = tableService.selectUserTables();
            UserDO userDO = userDOMapper.selectByEmail(email, tables);
            if (userDO != null) {
                if (email.equals(userDO.getEmail()) && userDO.getPassword().equals(MD5Util.getMD5(password))) {
                    MySessionUtil.getSession().setAttribute(MySessionUtil.USER_EMAIL, userDO.getEmail());
                    System.out.println(MySessionUtil.getSession().getId());
                    return userDO.getName();
                } else {
                    throw new BusinessException(EmBusinessErr.USER_LOGIN_ERROR);
                }
            } else {
                throw new BusinessException(EmBusinessErr.USER_LOGIN_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(EmBusinessErr.USER_LOGIN_ERROR);
        }
    }

    @Override
    public void registered(String name, String email, String password) throws BusinessException {
        try {
            List<String> tables = tableService.selectUserTables();
            UserDO userDO = userDOMapper.selectByEmail(email, tables);
            if (userDO == null) {
                String table = tableService.selectUserLastTable();
                int suc = userDOMapper.registered(name, email, MD5Util.getMD5(password), table);
                System.out.println(suc);
                if (suc != 1) {
                    throw new BusinessException(EmBusinessErr.USER_REGISTERED_ERROR);
                }
            } else {
                throw new BusinessException(EmBusinessErr.USER_ACCOUNT_EXISTS_ALREADY);
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof BusinessException) {
                throw e;
            } else {
                throw new BusinessException(EmBusinessErr.USER_REGISTERED_ERROR);
            }

        }
    }


    @Override
    @Cacheable(value = "userInfo", key = "#email")
    public UserVO getUserInfo(String email) throws BusinessException {
        try {
            if (email != null) {
                List<String> tables = tableService.selectUserTables();
                return userDOMapper.selectInfoByEmail(email, tables);
            } else {
                throw new BusinessException(EmBusinessErr.GET_INFO_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(EmBusinessErr.GET_INFO_ERROR);
        }

    }
}
