package com.caiwei.sunny.mdm.permis.mapper;

import com.caiwei.sunny.mdm.permis.api.domain.DepartmentDO;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepartmentMapper {

    int delete(Integer tdId);

    int update(DepartmentDO departmentDO);

    int insert(DepartmentDO record);

    DepartmentDO findByDeptCode(String deptCode);

    DepartmentDO findByEmpCode(String empCode);

    List<DepartmentDO> findByParentCode(String parentCode);

}