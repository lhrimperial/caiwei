package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.cache.ResourceCodeCache;
import com.caiwei.console.business.cache.ResourceMenuCache;
import com.caiwei.console.business.service.IUserMenuService;
import com.caiwei.console.common.domain.ResourceDO;
import com.caiwei.console.common.domain.ResourceNode;
import com.caiwei.console.common.domain.UserMenuDO;
import com.caiwei.console.common.exception.ResourceException;
import com.github.framework.server.cache.CacheManager;
import com.github.framework.server.cache.ICache;
import com.github.framework.util.string.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class UserMenuService implements IUserMenuService {


    @Override
    public List<UserMenuDO> queryUserMenuByUserCode(String userCode) {
        return null;
    }

    @Override
    public ResourceNode queryResourceByCode(String resCode) {
        if (StringUtils.isBlank(resCode)) {
            throw new ResourceException(ResourceException.RESOURCE_CODE_NULL);
        }
        ICache<String, ResourceDO> resCache = CacheManager.getInstance()
                .getCache(ResourceCodeCache.RESOURCE_CODE_CACHE_UUID);
        ResourceNode res = null;
        if (resCache != null) {
            ResourceDO  resourceDO = resCache.get(resCode);
            res = resourceDO.convert(resourceDO);
        }
        return res;
    }

    @Override
    public List<ResourceNode> queryResourceBatchByCode(String[] resCodes) {
        List<ResourceNode> resources = new ArrayList<ResourceNode>();
        for (String code : resCodes) {
            ResourceNode resource = this.queryResourceByCode(code);
            resources.add(resource);
        }
        return resources;
    }

    @Override
    public List<ResourceNode> queryResourcesByParentCode(String parentCode) {
        ICache<String, List<ResourceNode>> resMenuCache = CacheManager
                .getInstance().getCache(ResourceMenuCache.MENU_CACHE_UUID);
        List<ResourceNode> resMenus = resMenuCache.get(parentCode);
        if (resMenus == null) {
            throw new ResourceException(ResourceException.RESOURCE_URI_NULL);
        }
        return resMenus;
    }
}
