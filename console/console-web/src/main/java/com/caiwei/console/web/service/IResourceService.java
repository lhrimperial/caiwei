package com.caiwei.console.web.service;

import com.caiwei.console.common.domain.ResourceTreeNode;
import com.caiwei.console.web.domain.ResourceVO;

import java.util.List;

/**
 *
 */
public interface IResourceService {

    List<ResourceTreeNode> queryTreePathForName(String resourceName);

    List<ResourceTreeNode> queryResourceByParentRes(String node);

    ResourceVO queryResourceByExample(ResourceVO resourceVO);


}
