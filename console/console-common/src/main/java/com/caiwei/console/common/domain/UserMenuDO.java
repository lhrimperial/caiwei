package com.caiwei.console.common.domain;

import java.io.Serializable;

/**
 *
 */
public class UserMenuDO implements Serializable {
    private static final long serialVersionUID = -6899497576658354005L;

    /**
     *显示顺序
     */
    private Integer displayOrder;

    /**
     *用户
     */
    private String userCode;

    /**
     *权限
     */
    private String resourceCode;

    /**
     *是否启用
     */
    private String active;

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
