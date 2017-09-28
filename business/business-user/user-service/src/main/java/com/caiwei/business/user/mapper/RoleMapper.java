package com.caiwei.business.user.mapper;

import com.caiwei.business.user.api.domain.RolePO;
import org.springframework.stereotype.Repository;

/**
 * @author longhairen
 * @create 2017/6/9 0009 下午 5:08
 */
@Repository
public interface RoleMapper {

    /**
     *
     * @param roleCode
     * @return
     */
    RolePO findRoleByRoleCode(String roleCode);

    /**
     *
     * @param rolePO
     */
    void insert(RolePO rolePO);

    /**
     *
     * @param rolePO
     */
    void update(RolePO rolePO);
}
