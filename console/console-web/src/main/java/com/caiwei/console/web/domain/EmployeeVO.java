package com.caiwei.console.web.domain;

import com.caiwei.console.common.domain.EmployeeDO;
import com.github.framework.server.shared.domain.vo.BaseVO;

import java.util.List;

/**
 *
 **/
public class EmployeeVO extends BaseVO {

    private String queryParam;
    private EmployeeDO employeeDO;
    private List<EmployeeDO> employeeDOS;

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public EmployeeDO getEmployeeDO() {
        return employeeDO;
    }

    public void setEmployeeDO(EmployeeDO employeeDO) {
        this.employeeDO = employeeDO;
    }

    public List<EmployeeDO> getEmployeeDOS() {
        return employeeDOS;
    }

    public void setEmployeeDOS(List<EmployeeDO> employeeDOS) {
        this.employeeDOS = employeeDOS;
    }
}
