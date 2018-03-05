package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.service.IPermisUserService;
import com.caiwei.console.persistent.domain.UserPO;
import com.caiwei.console.persistent.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
@Service
public class PermisUserService implements IPermisUserService {

    @Autowired
    private UserMapper permisUserMapper;

    @Override
    public int insert(UserPO permisUserDO) {
        return permisUserMapper.insert(permisUserDO);
    }

    @Override
    public int update(UserPO permisUserDO) {
        return permisUserMapper.update(permisUserDO);
    }

    @Override
    public int delete(int id) {
        return permisUserMapper.delete(id);
    }

    @Override
    public UserPO findPermisUser(String userCode) {
        return permisUserMapper.findByUserCode(userCode);
    }
}
