package com.caiwei.business.user.service;

import com.caiwei.business.user.api.domain.UserPO;
import com.caiwei.business.user.api.service.IUserService;
import com.caiwei.business.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longhairen
 * @create 2017/6/15 0015 上午 9:29
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserPO findUserByCode(String userCode) {
        UserPO userPO = userMapper.findUserByUserCode(userCode);
        return userPO;
    }
}
