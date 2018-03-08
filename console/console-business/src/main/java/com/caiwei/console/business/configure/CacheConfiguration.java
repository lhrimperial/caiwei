package com.caiwei.console.business.configure;

import com.caiwei.console.business.cache.*;
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

    @Autowired
    private FunctionCacheProvider functionCacheProvider;

    @Autowired
    private UserOrgRoleResCacheProvider userOrgRoleResCacheProvider;

    @Autowired
    private ResourceCodeCacheProvider resourceCodeCacheProvider;

    @Autowired
    private ResourceMenuCacheProvider resourceMenuCacheProvider;

    @Bean
    public ResourceMenuCache resourceMenuCache() {
        ResourceMenuCache resourceMenuCache = new ResourceMenuCache();
        resourceMenuCache.setCacheProvider(resourceMenuCacheProvider);
        resourceMenuCache.setCacheStorage(redisCacheStore);
        return resourceMenuCache;
    }

    @Bean
    public ResourceCodeCache resourceCodeCache() {
        ResourceCodeCache resourceCodeCache = new ResourceCodeCache();
        resourceCodeCache.setCacheProvider(resourceCodeCacheProvider);
        resourceCodeCache.setCacheStorage(redisCacheStore);
        return resourceCodeCache;
    }

    @Bean
    public UserOrgRoleResCache userOrgRoleResCache() {
        UserOrgRoleResCache userOrgRoleResCache = new UserOrgRoleResCache();
        userOrgRoleResCache.setCacheStorage(redisCacheStore);
        userOrgRoleResCache.setCacheProvider(userOrgRoleResCacheProvider);
        return userOrgRoleResCache;
    }

    @Bean
    public FunctionCache functionCache() {
        FunctionCache functionCache = new FunctionCache();
        functionCache.setCacheStorage(redisCacheStore);
        functionCache.setCacheProvider(functionCacheProvider);
        return functionCache;
    }

    @Bean
    public UserCache userCache() {
        UserCache userCache = new UserCache();
        userCache.setCacheStorage(redisCacheStore);
        userCache.setCacheProvider(userCacheProvider);
        return userCache;
    }

}
