package com.caiwei.console.business.configure;

import com.github.framework.server.cache.store.RedisCacheStore;
import com.github.framework.server.database.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 *
 **/
@Configuration
public class RedisClientConfiguration {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Bean
    public RedisClient getRedisClient() {
        RedisClient redisClient = new RedisClient();
        redisClient.setRedisTemplate(redisTemplate);
        return redisClient;
    }

    @Bean
    public RedisCacheStore getReidsCacheStore() {
        RedisCacheStore redisCacheStore = new RedisCacheStore();
        redisCacheStore.setRedisClient(getRedisClient());
        return redisCacheStore;
    }
}
