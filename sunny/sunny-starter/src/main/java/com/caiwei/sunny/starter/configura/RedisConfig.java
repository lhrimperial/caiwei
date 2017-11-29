package com.caiwei.sunny.starter.configura;

import com.caiwei.framework.server.cache.aspect.RedisCacheableAspect;
import com.caiwei.framework.server.database.redis.RedisClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author longhr
 * @version 2017/11/7 0007
 */
//@Configuration
public class RedisConfig {

    @Bean
    public RedisClient getRedisClient(){
        return new RedisClient();
    }

    @Bean
    public RedisCacheableAspect getRedisCacheableAspect() {
        return new RedisCacheableAspect();
    }
}
