package com.caiwei.console.web.domain;

import com.caiwei.console.common.domain.DepartmentDO;
import com.github.framework.server.shared.domain.vo.BaseVO;

import java.util.List;

/**
 *
 **/
public class DepartmentVO extends BaseVO {

    private String deptCode;
    private DepartmentDO departmentDO;
    private List<DepartmentDO> departmentDOS;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public DepartmentDO getDepartmentDO() {
        return departmentDO;
    }

    public void setDepartmentDO(DepartmentDO departmentDO) {
        this.departmentDO = departmentDO;
    }

    public List<DepartmentDO> getDepartmentDOS() {
        return departmentDOS;
    }

    public void setDepartmentDOS(List<DepartmentDO> departmentDOS) {
        this.departmentDOS = departmentDOS;
    }
}
