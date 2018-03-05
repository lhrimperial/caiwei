package com.caiwei.console.persistent.mapper;

import com.caiwei.console.persistent.domain.DepartmentPO;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepartmentMapper {

    int update(DepartmentPO departmentDO);

    int insert(DepartmentPO record);

    DepartmentPO findByDeptCode(String deptCode);

    DepartmentPO findByEmpCode(String empCode);

    List<DepartmentPO> findByParentCode(String parentCode);

}