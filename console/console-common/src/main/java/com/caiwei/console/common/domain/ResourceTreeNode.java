package com.caiwei.console.common.domain;

import com.caiwei.console.common.define.ConsoleConstants;
import com.github.framework.server.shared.define.FunctionType;
import com.github.framework.server.shared.entity.BaseEntity;
import com.github.framework.server.shared.entity.node.TreeNode;

/**
 * 功能树节点的实体对象
 */
public class ResourceTreeNode<T extends BaseEntity> extends TreeNode<T,ResourceTreeNode> {

    //连接
    private String uri;

    //是否可展开
    private Boolean expandable;

    //是否展开
    private Boolean expend;

    //显示图标
    private String iconCls;

    //菜单的CSS
    private String cls;

    //菜单的显示顺序
    private String displayOrder;

    private ResourceNode resourceNode;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Boolean getExpandable() {
        return expandable;
    }

    public void setExpandable(Boolean expandable) {
        this.expandable = expandable;
    }

    public Boolean getExpend() {
        return expend;
    }

    public void setExpend(Boolean expend) {
        this.expend = expend;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public ResourceNode getResourceNode() {
        return resourceNode;
    }

    public void setResourceNode(ResourceNode resourceNode) {
        this.resourceNode = resourceNode;
    }

    // 转换菜单对象为树节点对象
    public static ResourceTreeNode<ResourceNode> changeResToTreeNode(ResourceNode res, boolean containNode) {
        ResourceTreeNode<ResourceNode> treeNode = new ResourceTreeNode<ResourceNode>();
        treeNode.setId(res.getFunctionCode());
        treeNode.setText(res.getName());
        treeNode.setExpandable(!ConsoleConstants.YES.equalsIgnoreCase(res.getLeafFlag()));
//        treeNode.setChecked(ConsoleConstants.YES.equalsIgnoreCase(res.getChecked()));
        treeNode.setCls(res.getCls());
        treeNode.setIconCls(res.getIconCls());
        treeNode.setDisplayOrder(res.getDisplayOrder());
        if (res.getResType().equalsIgnoreCase(FunctionType.MENU)) {
            treeNode.setUri(res.getUri());
            treeNode.setLeaf(true);
        } else {
            treeNode.setLeaf(false);
        }
        if (res.getParentRes() != null) {
            treeNode.setParentId(res.getParentRes());
        } else {
            treeNode.setParentId(null);
        }
        if (containNode) {
            treeNode.setResourceNode(res);
        }
        return treeNode;
    }
}
