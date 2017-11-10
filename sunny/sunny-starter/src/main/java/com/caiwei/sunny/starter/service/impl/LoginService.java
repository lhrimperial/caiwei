package com.caiwei.sunny.starter.service.impl;

import com.caiwei.sunny.mdm.permis.api.service.IPermisUserService;
import com.caiwei.sunny.starter.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longhr
 * @version 2017/11/7 0007
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    private IPermisUserService permisUserService;

    @Override
    public void userLogin(String userCode, String password) {

    }
}
