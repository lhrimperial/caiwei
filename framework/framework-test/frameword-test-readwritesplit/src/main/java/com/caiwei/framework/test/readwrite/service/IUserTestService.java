package com.caiwei.framework.test.readwrite.service;

import com.caiwei.framework.test.readwrite.domain.UserTestPO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author longhairen
 * @create 2017/10/25 0025 下午 8:21
 */
public interface IUserTestService {

    public void insertT(UserTestPO userTestPO);

    void insertList(List<UserTestPO> list);

    public void deleteById(int id);

    public void updateT(UserTestPO userTestPO);

    public UserTestPO getUserTestPO(int id);

    public List<UserTestPO> getAllUserTestPOs(int pageNO);
}
