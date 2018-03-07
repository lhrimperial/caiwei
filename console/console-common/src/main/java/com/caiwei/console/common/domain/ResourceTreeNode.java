package com.caiwei.console.common.domain;

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

    private ResourceDO resourceDO;

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

    public ResourceDO getResourceDO() {
        return resourceDO;
    }

    public void setResourceDO(ResourceDO resourceDO) {
        this.resourceDO = resourceDO;
    }
}
