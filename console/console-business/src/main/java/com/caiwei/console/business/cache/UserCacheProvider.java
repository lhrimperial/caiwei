package com.caiwei.console.business.cache;

import com.caiwei.console.common.domain.EmployeeDO;
import com.caiwei.console.common.domain.PermisUserDO;
import com.caiwei.console.persistent.domain.EmployeePO;
import com.caiwei.console.persistent.mapper.EmployeeMapper;
import com.caiwei.console.persistent.mapper.UserMapper;
import com.github.framework.server.cache.provider.ITTLCacheProvider;
import com.github.framework.server.shared.entity.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class UserCacheProvider implements ITTLCacheProvider<IUser> {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public IUser get(String key) {
        PermisUserDO permisUserDO = userMapper.findUserDetail(key);
        if (permisUserDO != null) {
            EmployeeDO employeeDO = employeeMapper.findByEmpCode(permisUserDO.getEmpCode());
            permisUserDO.setEmployeeDO(employeeDO);
        }
        return permisUserDO;
    }
}
