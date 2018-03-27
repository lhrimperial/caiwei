package com.caiwei.console.web.service.impl;

import com.caiwei.console.business.service.IUserMenuService;
import com.caiwei.console.common.domain.ResourceDO;
import com.caiwei.console.common.domain.ResourceNode;
import com.caiwei.console.common.domain.ResourceTreeNode;
import com.caiwei.console.web.domain.ResourceVO;
import com.caiwei.console.web.service.IResourceService;
import com.github.framework.server.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private IUserMenuService userMenuService;

    @Override
    public List<ResourceTreeNode> queryTreePathForName(String resourceName) {
        List<ResourceTreeNode> list = new ArrayList<>();
        ResourceDO resourceDO = new ResourceDO();
        resourceDO.setResName(resourceName);
        List<ResourceDO> resourceDOS = userMenuService.queryResourcesByParam(resourceDO);
        for (ResourceDO res : resourceDOS) {
            list.add(ResourceTreeNode.changeResToTreeNode(ResourceDO.convert(res), true));
        }
        return list;
    }

    @Override
    public List<ResourceTreeNode> queryResourceByParentRes(String node) {
        List<ResourceTreeNode> nodes = new ArrayList<>();
        List<ResourceNode> childResources = userMenuService.queryResourcesByParentCode(node);
        for (ResourceNode res : childResources) {
            // 转换菜单对象为节点对象
            ResourceTreeNode<ResourceNode> treeNode = ResourceTreeNode.changeResToTreeNode(res,false);
            nodes.add(treeNode);
        }
        return nodes;
    }

    @Override
    public ResourceVO queryResourceByExample(ResourceVO resourceVO) {
        if (resourceVO == null) {
            throw new BusinessException("参数不能为空！");
        }
        ResourceDO resourceDO = ResourceDO.flipConvert(resourceVO.getResourceNode());
        List<ResourceDO> list = userMenuService.queryResourcesByParam(resourceDO);
        List<ResourceNode> resourceNodes = new ArrayList<>();
        for (ResourceDO res : list) {
            resourceNodes.add(ResourceDO.convert(res));
        }
        resourceVO.setResourceNodes(resourceNodes);
        return resourceVO;
    }
}
