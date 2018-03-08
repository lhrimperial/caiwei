package com.caiwei.console.business.cache;

import com.github.framework.server.cache.provider.ITTLCacheProvider;
import com.github.framework.server.shared.entity.IFunction;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class FunctionCacheProvider implements ITTLCacheProvider<IFunction> {

    @Override
    public IFunction get(String key) {
        return null;
    }
}
