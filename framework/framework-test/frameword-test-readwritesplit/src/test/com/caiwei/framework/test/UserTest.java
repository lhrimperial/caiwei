package com.caiwei.framework.test;

import com.alibaba.fastjson.JSON;
import com.caiwei.framework.test.readwrite.ApplicationReadWrite;
import com.caiwei.framework.test.readwrite.domain.UserTestPO;
import com.caiwei.framework.test.readwrite.service.IUserTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


/**
 * @author longhairen
 * @create 2017/10/25 0025 下午 8:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationReadWrite.class)
public class UserTest {

    @Autowired
    private IUserTestService userTestService;

    @Test
    public void insertUserTest() {
        UserTestPO po = null;
        List<UserTestPO> list = new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            po = new UserTestPO();
            po.setId(5 + i);
            po.setUserName("world" + i);
            list.add(po);
//            userTestService.insertT(po);
        }
        userTestService.insertList(list);

    }

    @Test
    public void findUserTest() {
        UserTestPO po = userTestService.getUserTestPO(1);
        System.out.println(JSON.toJSONString(po));
    }

    @Test
    public void findUserListTest() {
        List<UserTestPO> pos = userTestService.getAllUserTestPOs(1);
        System.out.println(JSON.toJSONString(pos));
    }
}
