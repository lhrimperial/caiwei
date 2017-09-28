package com.caiwei.business.user.mapper;


import com.caiwei.business.user.api.domain.EmployeePO;
import org.springframework.stereotype.Repository;

/**
 * @author longhairen
 * @create 2017/6/14 0014 上午 10:09
 */
@Repository
public interface EmployeeMapper {

    /**
     *
     * @param empCode
     * @return
     */
    EmployeePO findEmpByCode(String empCode);

    /**
     *
     * @param employeePO
     */
    void update(EmployeePO employeePO);

    /**
     *
     * @param employeePO
     */
    void insert(EmployeePO employeePO);
}
