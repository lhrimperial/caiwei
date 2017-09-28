package com.caiwei.business.user.mapper;

import com.caiwei.business.user.api.domain.UserPO;
import org.springframework.stereotype.Repository;

/**
 * @author longhairen
 * @create 2017/6/9 0009 下午 3:16
 */
@Repository
public interface UserMapper {


    /**
     * 根据用户编码查询用户信息
     * @param userCode
     * @return
     */
    UserPO findUserByUserCode(String userCode);

    /**
     * 保存用户信息
     * @param userPO
     */
    void insert(UserPO userPO);

    /**
     * 更新用户信息
     * @param userPO
     */
    void update(UserPO userPO);
}
