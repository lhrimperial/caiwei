package com.caiwei.console.business.service;


import com.caiwei.console.persistent.domain.EmployeePO;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
public interface IEmployeeService {

    int insert(EmployeePO employeeDO);

    int update(EmployeePO employeeDO);

    int delete(String empCode);

    EmployeePO findByEmpCode(String empCode);

    List<EmployeePO> findByDeptCode(String deptCode);
}
