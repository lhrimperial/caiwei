package com.caiwei.framework.test.readwrite.service.impl;

import com.caiwei.framework.starter.configuration.readwirte.ReadOnlyConnection;
import com.caiwei.framework.test.readwrite.domain.UserTestPO;
import com.caiwei.framework.test.readwrite.mapper.UserTestMapper;
import com.caiwei.framework.test.readwrite.service.IUserTestService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author longhairen
 * @create 2017/10/25 0025 下午 8:24
 */
@Service
public class UserTestService implements IUserTestService {
    public final static int PAGE_SIZE = 10;

    @Autowired
    private UserTestMapper userTestMapper;

    @Override
    public void insertT(UserTestPO userTestPO) {
        userTestMapper.insertT(userTestPO);
    }

    @Override
    public void insertList(List<UserTestPO> list) {
        userTestMapper.insertList(list);
    }

    @Override
    public void deleteById(int id) {
        userTestMapper.deleteById(id);
    }

    @Override
    public void updateT(UserTestPO userTestPO) {
        userTestMapper.updateT(userTestPO);
    }

    @Override
    @ReadOnlyConnection
    public UserTestPO getUserTestPO(int id) {
        return userTestMapper.getUserTestPO(id);
    }

    @Override
    @ReadOnlyConnection
    public List<UserTestPO> getAllUserTestPOs(int pageNO) {
        int offset = (pageNO - 1) * PAGE_SIZE;
        RowBounds rowBounds = new RowBounds(offset, PAGE_SIZE);
        return userTestMapper.getAllUserTestPOs(rowBounds);
    }
}
