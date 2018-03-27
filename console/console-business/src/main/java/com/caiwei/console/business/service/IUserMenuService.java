package com.caiwei.console.business.service;

import com.caiwei.console.common.domain.ResourceDO;
import com.caiwei.console.common.domain.ResourceNode;
import com.caiwei.console.common.domain.UserMenuDO;

import java.util.List;

/**
 *
 */
public interface IUserMenuService {

    List<UserMenuDO> queryUserMenuByUserCode(String userCode);

    ResourceNode queryResourceByCode(String resCode);

    List<ResourceNode> queryResourceBatchByCode(String[] resCodes);

    List<ResourceNode> queryResourcesByParentCode(String parentCode);

    List<ResourceDO> queryResourcesByParam(ResourceDO resourceDO);
}
