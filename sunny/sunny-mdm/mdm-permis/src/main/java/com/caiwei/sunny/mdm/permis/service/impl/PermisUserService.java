package com.caiwei.sunny.mdm.permis.service.impl;

import com.caiwei.sunny.mdm.permis.api.domain.PermisUserDO;
import com.caiwei.sunny.mdm.permis.api.service.IPermisUserService;
import com.caiwei.sunny.mdm.permis.mapper.PermisUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
@Service
public class PermisUserService implements IPermisUserService {

    @Autowired
    private PermisUserMapper permisUserMapper;

    @Override
    public int insert(PermisUserDO permisUserDO) {
        return permisUserMapper.insert(permisUserDO);
    }

    @Override
    public int update(PermisUserDO permisUserDO) {
        return permisUserMapper.update(permisUserDO);
    }

    @Override
    public int delete(int id) {
        return permisUserMapper.delete(id);
    }

    @Override
    public PermisUserDO findPermisUser(String userCode) {
        return permisUserMapper.findByUserCode(userCode);
    }
}
