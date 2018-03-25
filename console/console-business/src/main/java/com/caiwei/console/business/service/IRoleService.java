package com.caiwei.console.business.service;

import com.caiwei.console.common.domain.RoleDO;

import java.util.List;

/**
 *
 **/
public interface IRoleService {

    void save(RoleDO roleDO);

    void update(RoleDO roleDO);

    void updateStatus(List<String> roleCodes, Byte status);

    void delete(String roleCode);

    RoleDO findById(Integer id);

    RoleDO findByCode(String roleCode);

    List<RoleDO> findByParam(RoleDO roleDO, int pageNo, int pageSize);
}
