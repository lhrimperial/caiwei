package com.caiwei.console.business.cache;

import com.caiwei.console.common.domain.ResourceDO;
import com.github.framework.server.cache.DefaultTTLRedisCache;
import org.springframework.stereotype.Component;

/**
 * 权限缓存
 */
@Component
public class ResourceCodeCache extends DefaultTTLRedisCache<ResourceDO> {
	public static final String RESOURCE_CODE_CACHE_UUID = "resourceCode";
	@Override
	public String getUUID() {
		return RESOURCE_CODE_CACHE_UUID;
	}

}
