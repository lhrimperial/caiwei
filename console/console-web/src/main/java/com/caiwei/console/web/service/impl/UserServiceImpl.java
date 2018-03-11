package com.caiwei.console.web.service.impl;

import com.caiwei.console.business.service.IPermisUserService;
import com.caiwei.console.web.domain.UserVO;
import com.caiwei.console.web.service.IUserService;
import com.github.framework.server.shared.define.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IPermisUserService permisUserService;

    @Override
    public UserVO queryUserList(UserVO userVO) {
        UserVO userVO1 = new UserVO();
        userVO1.setUserDOS(permisUserService.findUsers(userVO.getUserDO()));
        return userVO1;
    }

    @Override
    public void addUser(UserVO userVO) {

    }

    @Override
    public void deleteUser(UserVO userVO) {
        List<String> userCodes = userVO.getUserCodes();
        permisUserService.updateStatus(userCodes, Constants.PO_INACTIVE);
    }
}
