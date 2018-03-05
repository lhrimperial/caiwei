package com.caiwei.console.persistent.mapper;

import com.caiwei.console.persistent.domain.EmployeePO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {

    int insert(EmployeePO record);

    int update(EmployeePO record);

    EmployeePO findById(Integer teId);

    EmployeePO findByEmpCode(String empCode);

    List<EmployeePO> findByDeptCode(String deptCode);

}