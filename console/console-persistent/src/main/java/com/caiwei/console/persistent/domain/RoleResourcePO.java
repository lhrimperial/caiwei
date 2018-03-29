package com.caiwei.console.persistent.domain;


import com.github.framework.server.shared.define.Constants;
import com.github.framework.server.shared.domain.po.BasePO;

import java.util.Date;

public class RoleResourcePO extends BasePO {

    private static final long serialVersionUID = 7060387400887162747L;
    /**
     * 角色ID
     */
    private String roleCode;

    /**
     * 权限ID
     */
    private String resCode;

    public RoleResourcePO() {

    }

    public RoleResourcePO(String roleCode, String resCode) {
        super(Constants.PO_ACTIVE, new Date(), new Date());
        this.roleCode = roleCode;
        this.resCode = resCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }
}