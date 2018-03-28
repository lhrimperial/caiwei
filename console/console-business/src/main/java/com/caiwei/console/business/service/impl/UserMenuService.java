package com.caiwei.console.business.service.impl;

import com.caiwei.console.business.cache.ResourceCodeCache;
import com.caiwei.console.business.cache.ResourceMenuCache;
import com.caiwei.console.business.service.IUserMenuService;
import com.caiwei.console.common.domain.ResourceDO;
import com.caiwei.console.common.domain.ResourceNode;
import com.caiwei.console.common.domain.UserMenuDO;
import com.caiwei.console.common.exception.ResourceException;
import com.caiwei.console.persistent.domain.ResourcePO;
import com.caiwei.console.persistent.mapper.ResourceMapper;
import com.github.framework.server.cache.CacheManager;
import com.github.framework.server.cache.ICache;
import com.github.framework.server.exception.BusinessException;
import com.github.framework.server.shared.define.Constants;
import com.github.framework.util.serializer.BeanCopyUtils;
import com.github.framework.util.string.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class UserMenuService implements IUserMenuService {

    @Autowired
    private ResourceMapper resourceMapper;


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
            res = ResourceDO.convert(resourceDO);
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
    public List<ResourceNode> queryResourcesByParentCode(String parentCode, boolean cache) {
        List<ResourceNode> resMenus = null;
        if (cache) {
            ICache<String, List<ResourceNode>> resMenuCache = CacheManager
                    .getInstance().getCache(ResourceMenuCache.MENU_CACHE_UUID);
            resMenus = resMenuCache.get(parentCode);
            if (resMenus == null) {
                throw new ResourceException(ResourceException.RESOURCE_URI_NULL);
            }
        } else {
            resMenus = new ArrayList<>();
            List<ResourceDO> resourceDOS = resourceMapper.findByParentCode(parentCode);
            for (ResourceDO res : resourceDOS) {
                resMenus.add(ResourceDO.convert(res));
            }
        }
        return resMenus;
    }

    @Override
    public List<ResourceDO> queryResourcesByParam(ResourceDO resourceDO) {
        return resourceMapper.queryResourcesByParam(resourceDO);
    }

    @Override
    public void addResource(ResourceDO resourceDO) {
        if (resourceDO == null) {
            throw new BusinessException("资源参数为空！");
        }
        ResourceDO exist = resourceMapper.findByResCode(resourceDO.getResCode());
        if (exist != null) {
            throw new BusinessException("该资源编码已存在！");
        }
        ResourcePO resourcePO = new ResourcePO();
        BeanCopyUtils.copyBean(resourceDO, resourcePO);
        if (resourcePO.getCreateTime() == null) {
            resourcePO.setCreateTime(new Date());
        }
        if (resourcePO.getModifyTime() == null) {
            resourcePO.setModifyTime(new Date());
        }
        resourcePO.setStatus(Constants.PO_ACTIVE);
        resourceMapper.insert(resourcePO);
    }

    @Override
    public void updateResource(ResourceDO resourceDO) {
        if (resourceDO == null) {
            throw new BusinessException("资源参数为空！");
        }
        ResourcePO resourcePO = new ResourcePO();
        BeanCopyUtils.copyBean(resourceDO, resourcePO);
        if (resourcePO.getModifyTime() == null) {
            resourcePO.setModifyTime(new Date());
        }
        resourceMapper.update(resourcePO);
    }

    @Override
    public void deleteResource(List<String> resourceCodes) {
        resourceMapper.updateStatus(resourceCodes, Constants.PO_INACTIVE);
    }
}
