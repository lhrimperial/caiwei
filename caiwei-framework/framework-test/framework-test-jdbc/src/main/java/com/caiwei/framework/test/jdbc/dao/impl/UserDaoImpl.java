package com.caiwei.framework.test.jdbc.dao.impl;

import com.caiwei.framework.test.jdbc.dao.UserDao;
import com.caiwei.framework.test.jdbc.domain.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private DataSource dataSource;

    private Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }

    @Override
    public UserPO findByUserName(Integer id) {
        Connection connection = null;
        UserPO userPO = null;
        try {
            String sql = "select * from t_user where id = ?";
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.getResultSet();
            if (rs != null) {
                userPO = new UserPO();
                userPO.setId(rs.getInt(0));
                userPO.setUserName(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return userPO;
    }

    @Override
    public List<UserPO> findAllUser() {
        return null;
    }

    @Override
    public void save(UserPO userPO) {

    }

    @Override
    public void update(UserPO userPO) {

    }
}
