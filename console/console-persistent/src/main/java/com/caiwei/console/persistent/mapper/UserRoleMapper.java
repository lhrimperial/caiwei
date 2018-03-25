package com.caiwei.console.persistent.mapper;

import com.caiwei.console.persistent.domain.UserRolePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {

    int insert(UserRolePO record);

    int update(UserRolePO record);

    int updateStatus(@Param("userCodes") List<String> userCodes, @Param("status") Byte status);

}