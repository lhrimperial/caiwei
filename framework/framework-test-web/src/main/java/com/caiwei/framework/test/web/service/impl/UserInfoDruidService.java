package com.caiwei.framework.test.web.service.impl;

import com.caiwei.framework.test.web.domain.UserInfo;
import com.caiwei.framework.test.web.mapper.UserInfoMapper;
import com.caiwei.framework.test.web.service.IUserInfoService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author longhairen
 * @create 2017/8/22 0022 下午 3:57
 */
@Service("userInfoDruidService")
public class UserInfoDruidService implements IUserInfoService {

    public final static int PAGE_SIZE = 10;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findUserInfo(int id) {
        return userInfoMapper.findUserInfo(id);
    }

    @Override
    public List<UserInfo> findUserInfoList(int pageNO) {
        int offset = (pageNO - 1) * PAGE_SIZE;
        RowBounds rowBounds = new RowBounds(offset, PAGE_SIZE);
        return userInfoMapper.findUserByPage(rowBounds);
    }
}
