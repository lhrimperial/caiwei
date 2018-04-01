package com.caiwei.console.web.service;

import com.caiwei.console.common.domain.ResourceTreeNode;

import java.util.List;
import java.util.Set;

/**
 *
 */
public interface IMenuService {

    List<ResourceTreeNode> loadTree(String node);

    Set<String> queryTreePathForName(String menuName);

    List<ResourceTreeNode> queryResourceByParentRes(String node);

}
