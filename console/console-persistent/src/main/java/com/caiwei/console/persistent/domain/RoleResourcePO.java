package com.caiwei.console.persistent.domain;


import com.github.framework.server.shared.domain.po.BasePO;

public class RoleResourcePO extends BasePO {

    private static final long serialVersionUID = 7060387400887162747L;
    /**
     * 角色ID
     */
    private Integer troleId;

    /**
     * 权限ID
     */
    private Integer tresId;

    public Integer getTroleId() {
        return troleId;
    }

    public void setTroleId(Integer troleId) {
        this.troleId = troleId;
    }

    public Integer getTresId() {
        return tresId;
    }

    public void setTresId(Integer tresId) {
        this.tresId = tresId;
    }
}