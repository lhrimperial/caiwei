package com.caiwei.console.persistent.mapper;

import com.caiwei.console.persistent.domain.RoleResourcePO;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleResourceMapper {

    int insert(RoleResourcePO record);

    int update(RoleResourcePO record);
}