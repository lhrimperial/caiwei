package com.caiwei.business.user.mapper;


import com.caiwei.business.user.api.domain.DepartmentPO;
import org.springframework.stereotype.Repository;

/**
 * @author longhairen
 * @create 2017/6/14 0014 上午 10:03
 */
@Repository
public interface DepartmentMapper {

    /**
     *
     * @param deptCode
     * @return
     */
    DepartmentPO findDeptByCode(String deptCode);
    /**
     *
     * @param departmentPO
     */
    void update(DepartmentPO departmentPO);

    /**
     *
     * @param departmentPO
     */
    void insert(DepartmentPO departmentPO);
}
