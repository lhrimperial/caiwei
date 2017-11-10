package com.caiwei.sunny.mdm.permis.api.service;

import com.caiwei.sunny.mdm.permis.api.domain.DepartmentDO;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
public interface IDepartmentService {

    int insert(DepartmentDO departmentDO);

    int update(DepartmentDO departmentDO);

    int delete(int tdId);

    DepartmentDO findByDeptCode(String deptCode);

    DepartmentDO findByEmpCode(String empCode);

    List<DepartmentDO> findByParentCode(String parentCode);
}
