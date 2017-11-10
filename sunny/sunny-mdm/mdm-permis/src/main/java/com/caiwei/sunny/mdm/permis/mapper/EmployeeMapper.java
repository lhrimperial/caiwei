package com.caiwei.sunny.mdm.permis.mapper;

import com.caiwei.sunny.mdm.permis.api.domain.EmployeeDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {

    int delete(Integer teId);

    int insert(EmployeeDO record);

    int update(EmployeeDO record);

    EmployeeDO findById(Integer teId);

    EmployeeDO findByEmpCode(String empCode);

    List<EmployeeDO> findByDeptCode(String deptCode);

}