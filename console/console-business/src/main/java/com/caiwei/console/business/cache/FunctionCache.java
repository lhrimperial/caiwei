package com.caiwei.console.business.cache;

import com.github.framework.server.cache.DefaultTTLRedisCache;
import com.github.framework.server.shared.entity.IFunction;

/**
 *
 */
public class FunctionCache extends DefaultTTLRedisCache<IFunction> {
    public static final String CACHE_NAME = IFunction.class.getName();

    @Override
    public String getUUID() {
        return CACHE_NAME;
    }
}
