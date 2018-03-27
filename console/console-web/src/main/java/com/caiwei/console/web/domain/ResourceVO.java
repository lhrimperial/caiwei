package com.caiwei.console.web.domain;

import com.caiwei.console.common.domain.ResourceNode;
import com.github.framework.server.shared.domain.vo.BaseVO;

import java.util.List;

/**
 *
 */
public class ResourceVO extends BaseVO{

    private static final long serialVersionUID = 5748247526083912108L;
    private ResourceNode resourceNode;
    private List<ResourceNode> resourceNodes;

    public ResourceNode getResourceNode() {
        return resourceNode;
    }

    public void setResourceNode(ResourceNode resourceNode) {
        this.resourceNode = resourceNode;
    }

    public List<ResourceNode> getResourceNodes() {
        return resourceNodes;
    }

    public void setResourceNodes(List<ResourceNode> resourceNodes) {
        this.resourceNodes = resourceNodes;
    }
}
