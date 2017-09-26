package com.caiwei.framework.test.web.service.impl;

import com.caiwei.framework.test.web.domain.UserInfo;
import com.caiwei.framework.test.web.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author longhairen
 * @create 2017/8/21 0021 上午 10:19
 */
@Service("userInfoJdbcService")
public class UserInfoJdbcService implements IUserInfoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserInfo findUserInfo(int id) {
        String sql = "select id,user_name,pass_word,mobile_no,email,gender from t_user_info where id = 1";
        return jdbcTemplate.queryForObject(sql, UserInfo.class);
    }

    @Override
    public List<UserInfo> findUserInfoList(int pageNO) {
        String sql = "select id,user_name,pass_word,mobile_no,email,gender from t_user_info";
        return jdbcTemplate.query(sql, new RowMapper<UserInfo>() {
            @Override
            public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                UserInfo user = new UserInfo();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setPassWord(resultSet.getString("pass_word"));
                user.setEmail(resultSet.getString("email"));
                user.setMobileNo(resultSet.getString("mobile_no"));
                user.setGender(resultSet.getString("gender"));
                return user;
            }
        });
    }

}
