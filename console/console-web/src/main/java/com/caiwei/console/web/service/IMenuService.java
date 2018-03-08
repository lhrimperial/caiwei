package com.caiwei.console.web.service;

import com.caiwei.console.common.domain.ResourceTreeNode;

import java.util.List;

/**
 *
 */
public interface IMenuService {

    List<ResourceTreeNode> loadTree(String node);

    List<ResourceTreeNode> queryTreePathForName(String menuName);

}
