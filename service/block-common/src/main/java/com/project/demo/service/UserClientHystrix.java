package com.project.demo.service;

import com.project.demo.DO.UserDO;
import com.project.demo.error.BusinessException;
import com.project.demo.error.EmBusinessErr;
import com.project.demo.response.CommonReturnType;
import com.project.demo.vo.UserVO;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: YZL
 * @time: 2020/3/20 8:12
 */
@Component
public class UserClientHystrix implements UserClientService {
    @Override
    public CommonReturnType login(String email, String password) throws BusinessException {
        throw new BusinessException(EmBusinessErr.USER_LOGIN_ERROR);
    }

    @Override
    public CommonReturnType registered(String name, String email, String password) throws BusinessException {
        throw new BusinessException(EmBusinessErr.USER_REGISTERED_ERROR);
    }

    @Override
    public CommonReturnType getUserInfo() {
        return CommonReturnType.create(new UserVO());
    }
}
