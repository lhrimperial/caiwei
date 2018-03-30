package com.caiwei.console.persistent.mapper;

import com.caiwei.console.common.domain.EmployeeDO;
import com.caiwei.console.persistent.domain.EmployeePO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {

    int insert(EmployeePO record);

    int update(EmployeePO record);

    EmployeeDO findByEmpCode(String empCode);

    List<EmployeeDO> findByDeptCode(String deptCode);

    List<EmployeeDO> findEmpByParam(EmployeeDO employeeDO);

    long totalCount(EmployeeDO employeeDO);

}