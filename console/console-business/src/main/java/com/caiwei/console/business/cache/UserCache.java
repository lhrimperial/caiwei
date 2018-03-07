package com.caiwei.console.business.cache;

import com.github.framework.server.cache.DefaultTTLRedisCache;
import com.github.framework.server.shared.entity.IUser;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class UserCache extends DefaultTTLRedisCache<IUser> {

    public static final String CACHE_NAME = IUser.class.getName();

    @Override
    public String getUUID() {
        return CACHE_NAME;
    }

}
