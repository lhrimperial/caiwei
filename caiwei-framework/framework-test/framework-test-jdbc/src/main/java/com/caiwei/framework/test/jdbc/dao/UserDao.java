package com.caiwei.framework.test.jdbc.dao;

import com.caiwei.framework.test.jdbc.domain.UserPO;
import java.util.List;

/**
 *
 */
public interface UserDao {

    UserPO findByUserName(Integer id);

    List<UserPO> findAllUser();

    void save(UserPO userPO);

    void update(UserPO userPO);
}
