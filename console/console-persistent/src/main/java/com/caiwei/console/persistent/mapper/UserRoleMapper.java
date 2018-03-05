package com.caiwei.console.persistent.mapper;

import com.caiwei.console.persistent.domain.UserRolePO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {

    int insert(UserRolePO record);

    int update(UserRolePO record);
}