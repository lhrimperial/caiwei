package com.caiwei.framework.test.jdbc.service;

import com.caiwei.framework.test.jdbc.domain.UserPO;

import java.util.List;

/**
 *
 */
public interface IUserService {
    UserPO findByUserName(Integer id);

    List<UserPO> findAllUser();

    void save(UserPO userPO);

    void update(UserPO userPO);
}
