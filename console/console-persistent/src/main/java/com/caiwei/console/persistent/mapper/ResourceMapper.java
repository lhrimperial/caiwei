package com.caiwei.console.persistent.mapper;

import com.caiwei.console.common.domain.ResourceDO;
import com.caiwei.console.persistent.domain.ResourcePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceMapper {

    int insert(ResourcePO record);

    int update(ResourcePO record);

    int updateStatus(@Param("resCodes") List<String> resCodes, @Param("status") Byte status);

    ResourceDO findByResCode(String resCode);

    List<ResourceDO> findByParentCode(String parentCode);

    List<ResourceDO> queryResourcesByParam(ResourceDO resourceDO);
}