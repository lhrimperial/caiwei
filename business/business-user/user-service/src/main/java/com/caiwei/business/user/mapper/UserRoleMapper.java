package com.caiwei.business.user.mapper;


import com.caiwei.business.user.api.domain.UserRolePO;
import org.springframework.stereotype.Repository;

/**
 * @author longhairen
 * @create 2017/6/9 0009 下午 5:24
 */
@Repository
public interface UserRoleMapper {

    /**
     *
     * @param userCode
     * @return
     */
    UserRolePO findUserRoleByUserCode(String userCode);

    /**
     *
     * @param userRolePO
     */
    void insert(UserRolePO userRolePO);

    /**
     *
     * @param userRolePO
     */
    void update(UserRolePO userRolePO);
}
