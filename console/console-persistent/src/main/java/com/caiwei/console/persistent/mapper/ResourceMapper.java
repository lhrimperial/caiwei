package com.caiwei.console.persistent.mapper;

import com.caiwei.console.persistent.domain.ResourcePO;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceMapper {

    int insert(ResourcePO record);

    int update(ResourcePO record);
}