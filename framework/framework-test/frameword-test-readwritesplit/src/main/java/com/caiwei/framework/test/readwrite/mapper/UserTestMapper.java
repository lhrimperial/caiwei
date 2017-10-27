package com.caiwei.framework.test.readwrite.mapper;

import com.caiwei.framework.test.readwrite.domain.UserTestPO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author longhairen
 * @create 2017/10/25 0025 下午 8:05
 */
@Repository
public interface UserTestMapper {

    @Insert("<script>"+
            "insert into t_user(id, user_name) "
            + "values "
            + "<foreach collection =\"list\" item=\"user\" index= \"index\" separator =\",\"> "
            + "(#{user.id},#{user.userName}) "
            + "</foreach> "
            + "</script>")
    void insertList(@Param("list") List<UserTestPO> list);

    @Insert("insert into t_user(id,user_name) values(#{id},#{userName})")
    public void insertT(UserTestPO UserTestPO);

    @Delete("delete from t_user where id=#{id}")
    public void deleteById(int id);

    @Update("update t_user set name=#{userName} where id=#{id}")
    public void updateT(UserTestPO UserTestPO);

    @Select("select * from t_user where id=#{id}")
    @Results(
            {
                    @Result(column = "id", property = "id"),
                    @Result(column = "user_name", property = "userName"),
            })
    public UserTestPO getUserTestPO(int id);

    @Select("select * from t_user")
    @Results(
            {
                    @Result(column = "id", property = "id"),
                    @Result(column = "user_name", property = "userName"),
            })
    public List<UserTestPO> getAllUserTestPOs(RowBounds rowBounds);

}
