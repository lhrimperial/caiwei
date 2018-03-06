package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.service.IPermisUserService;
import com.caiwei.console.persistent.domain.UserPO;
import com.caiwei.console.persistent.mapper.UserMapper;
import com.github.framework.server.shared.define.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
@Service
public class PermisUserService implements IPermisUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(UserPO userPO) {
        return userMapper.insert(userPO);
    }

    @Override
    public int update(UserPO userPO) {
        return userMapper.update(userPO);
    }

    @Override
    public int delete(String userCode) {
        UserPO userPO = new UserPO(userCode, Constants.PoStatus.INACTIVE.value());
        return userMapper.update(userPO);
    }

    @Override
    public UserPO findUser(String userCode) {
        return userMapper.findByUserCode(userCode);
    }
}
