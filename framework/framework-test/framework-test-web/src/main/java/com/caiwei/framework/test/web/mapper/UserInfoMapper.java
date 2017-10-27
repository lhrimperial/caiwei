package com.caiwei.framework.test.web.mapper;

import com.caiwei.framework.test.web.domain.UserInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by longhairen on 2017/4/20 0020.
 */
@Repository
public interface UserInfoMapper {

    UserInfo findUserInfo(int id);

    List<UserInfo> findUserList();

    List<UserInfo> findUserByPage(RowBounds rowBounds);

}
