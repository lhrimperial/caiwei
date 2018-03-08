package com.caiwei.console.business.service;


import com.caiwei.console.common.domain.DepartmentDO;
import com.caiwei.console.persistent.domain.DepartmentPO;

import java.util.List;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
public interface IDepartmentService {

    int insert(DepartmentPO departmentDO);

    int update(DepartmentPO departmentDO);

    int delete(String deptCode);

    DepartmentDO findByDeptCode(String deptCode);

    DepartmentDO findByEmpCode(String empCode);

    List<DepartmentDO> findByParentCode(String parentCode);
}
