package com.caiwei.console.persistent.mapper;

import com.caiwei.console.common.domain.DepartmentDO;
import com.caiwei.console.persistent.domain.DepartmentPO;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepartmentMapper {

    int update(DepartmentPO departmentDO);

    int insert(DepartmentPO record);

    DepartmentDO findByDeptCode(String deptCode);

    DepartmentDO findByEmpCode(String empCode);

    List<DepartmentDO> findByParentCode(String parentCode);

}