package com.caiwei.console.business.cache;

import com.caiwei.console.common.domain.ResourceNode;
import com.github.framework.server.cache.DefaultTTLRedisCache;

import java.util.List;

/**
 * 功能权限缓存
 */
public class ResourceMenuCache extends DefaultTTLRedisCache<List<ResourceNode>> {
	public static final String MENU_CACHE_UUID = "menuCache";
	public String getUUID() {
		return MENU_CACHE_UUID;
	}
	
}
