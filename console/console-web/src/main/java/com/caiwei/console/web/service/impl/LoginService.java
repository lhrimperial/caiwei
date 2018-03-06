package com.caiwei.console.web.service.impl;

import com.caiwei.console.api.service.IUserService;
import com.caiwei.console.business.service.IPermisUserService;
import com.caiwei.console.web.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    private IPermisUserService permisUserService;

    @Override
    public void userLogin(String userCode, String password) {
        permisUserService.findUser(userCode);
    }
}
