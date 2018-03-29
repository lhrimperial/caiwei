package com.caiwei.console.web.domain;

import com.caiwei.console.common.domain.RoleDO;
import com.github.framework.server.shared.domain.vo.BaseVO;

import java.util.List;

/**
 *
 **/
public class RoleVO extends BaseVO {

    private static final long serialVersionUID = -5697185415167256371L;

    private String currRoleCode;
    private String resourceCodes;
    private String deleteResourceCodes;
    private List<String> roleCodes;

    private RoleDO roleDO;
    private List<RoleDO> roleDOS;

    public String getResourceCodes() {
        return resourceCodes;
    }

    public void setResourceCodes(String resourceCodes) {
        this.resourceCodes = resourceCodes;
    }

    public String getDeleteResourceCodes() {
        return deleteResourceCodes;
    }

    public void setDeleteResourceCodes(String deleteResourceCodes) {
        this.deleteResourceCodes = deleteResourceCodes;
    }

    public String getCurrRoleCode() {
        return currRoleCode;
    }

    public void setCurrRoleCode(String currRoleCode) {
        this.currRoleCode = currRoleCode;
    }

    public List<String> getRoleCodes() {
        return roleCodes;
    }

    public void setRoleCodes(List<String> roleCodes) {
        this.roleCodes = roleCodes;
    }

    public RoleDO getRoleDO() {
        return roleDO;
    }

    public void setRoleDO(RoleDO roleDO) {
        this.roleDO = roleDO;
    }

    public List<RoleDO> getRoleDOS() {
        return roleDOS;
    }

    public void setRoleDOS(List<RoleDO> roleDOS) {
        this.roleDOS = roleDOS;
    }
}
