package com.caiwei.console.business.cache;

import com.caiwei.console.common.domain.PermisUserDO;
import com.caiwei.console.persistent.mapper.UserMapper;
import com.github.framework.server.cache.provider.ITTLCacheProvider;
import com.github.framework.server.shared.entity.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class UserCacheProvider implements ITTLCacheProvider<IUser> {

    @Autowired
    private UserMapper mapper;

    @Override
    public IUser get(String key) {
        PermisUserDO permisUserDO = mapper.findUserDetail(key);
        return permisUserDO;
    }
}
