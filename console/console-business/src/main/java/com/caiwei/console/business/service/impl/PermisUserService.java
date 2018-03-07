package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.cache.UserCache;
import com.caiwei.console.business.service.IPermisUserService;
import com.caiwei.console.common.domain.PermisUserDO;
import com.caiwei.console.persistent.domain.UserPO;
import com.caiwei.console.persistent.mapper.UserMapper;
import com.github.framework.server.cache.CacheManager;
import com.github.framework.server.shared.define.Constants;
import com.github.framework.util.serializer.BeanCopyUtils;
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
    public int save(PermisUserDO permisUserDO) {
        UserPO userPO = new UserPO();
        BeanCopyUtils.copyBean(permisUserDO, userPO);
        return userMapper.insert(userPO);
    }

    @Override
    public int update(PermisUserDO permisUserDO) {
        UserPO userPO = new UserPO();
        BeanCopyUtils.copyBean(permisUserDO, userPO);
        return userMapper.update(userPO);
    }

    @Override
    public int delete(String userCode) {
        UserPO userPO = new UserPO(userCode, Constants.PoStatus.INACTIVE.value());
        return userMapper.update(userPO);
    }

    @Override
    public PermisUserDO findUserByLoginCode(String userCode) {
        return userMapper.findUserByLoginCode(userCode);
    }

    @Override
    public PermisUserDO findUserDetail(String userCode) {
        PermisUserDO user = (PermisUserDO) CacheManager.getInstance()
                .getCache(UserCache.CACHE_NAME).get(userCode);
        return user;
    }
}
