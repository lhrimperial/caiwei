package com.caiwei.console.persistent.mapper;

import com.caiwei.console.common.domain.ResourceDO;
import com.caiwei.console.persistent.domain.ResourcePO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceMapper {

    int insert(ResourcePO record);

    int update(ResourcePO record);

    ResourceDO findByResCode(String resCode);

    List<ResourceDO> findByParentCode(String parentCode);

    List<ResourceDO> queryResourcesByParam(ResourceDO resourceDO);
}