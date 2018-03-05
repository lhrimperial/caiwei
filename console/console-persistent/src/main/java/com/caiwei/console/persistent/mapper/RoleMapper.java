package com.caiwei.console.persistent.mapper;

import com.caiwei.console.persistent.domain.RolePO;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {

    int insert(RolePO record);

    int update(RolePO record);
}