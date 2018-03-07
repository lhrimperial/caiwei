package com.caiwei.console.business.configure;

import com.caiwei.console.business.cache.UserCache;
import com.caiwei.console.business.cache.UserCacheProvider;
import com.github.framework.server.cache.store.RedisCacheStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class CacheConfiguration {

    @Autowired
    private RedisCacheStore redisCacheStore;

    @Autowired
    private UserCacheProvider userCacheProvider;

    @Bean
    public UserCache getUserCache() {
        UserCache userCache = new UserCache();
        userCache.setCacheStorage(redisCacheStore);
        userCache.setCacheProvider(userCacheProvider);
        return userCache;
    }

}
