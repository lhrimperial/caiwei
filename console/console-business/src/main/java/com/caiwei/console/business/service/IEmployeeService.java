package com.caiwei.console.business.service;


import com.caiwei.console.common.domain.EmployeeDO;
import com.caiwei.console.persistent.domain.EmployeePO;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
public interface IEmployeeService {

    int insert(EmployeeDO employeeDO);

    int update(EmployeeDO employeeDO);

    int delete(String empCode);

    EmployeeDO findByEmpCode(String empCode);

    List<EmployeeDO> findByDeptCode(String deptCode);

    List<EmployeeDO> findEmpByParam(EmployeeDO employeeDO);

    List<EmployeeDO> findEmpByPage(EmployeeDO employeeDO, int pageNo, int pageSize);

    long totalCount(EmployeeDO employeeDO);
}
