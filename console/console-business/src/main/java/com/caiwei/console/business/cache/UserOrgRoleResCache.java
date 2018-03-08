package com.caiwei.console.business.cache;


import com.github.framework.server.cache.DefaultTTLRedisCache;

import java.util.List;
import java.util.Set;

/**
 * 用户部门角色权限缓存
 */
public class UserOrgRoleResCache extends DefaultTTLRedisCache<List<Set<String>>> {
	public static final String USER_ORG_ROLE_RES_CACHE_UUID = "userOrgRoleResource";

	@Override
	public String getUUID() {
		return USER_ORG_ROLE_RES_CACHE_UUID;
	}

}
