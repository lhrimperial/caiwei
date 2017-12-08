package com.caiwei.sunny.mdm.permis.api.service;

import com.caiwei.sunny.mdm.permis.api.domain.EmployeeDO;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
public interface IEmployeeService {

    int insert(EmployeeDO employeeDO);

    int update(EmployeeDO employeeDO);

    int delete(int teId);

    EmployeeDO findByEmpCode(String empCode);

    List<EmployeeDO> findByDeptCode(String deptCode);
}
