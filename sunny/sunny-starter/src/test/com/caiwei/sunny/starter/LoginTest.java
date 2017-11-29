package com.caiwei.sunny.starter;

import com.caiwei.framework.server.database.redis.RedisClient;
import com.caiwei.framework.util.cryp.MD5Util;
import com.caiwei.sunny.mdm.permis.api.domain.PermisUserDO;
import com.caiwei.sunny.mdm.permis.api.service.IPermisUserService;
import com.caiwei.sunny.starter.service.ILoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.Date;

/**
 * @author longhr
 * @version 2017/11/6 0006
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class LoginTest {

    @Autowired
    private IPermisUserService permisUserService;
    @Autowired
    private ILoginService loginService;
    @Autowired
    private RedisClient redisClient;

    @Test
    public void testFind() {
//        System.out.println(redisClient.get("user"));
    }

    @Test
    public void testRedis() {
        Jedis jedis = new Jedis("192.168.204.128");
        String keys = "name";

        // 删数据
        jedis.del(keys);
        // 存数据
        jedis.set(keys, "snowolf");
        // 取数据
        String value = jedis.get(keys);

        System.out.println(value);
    }

    @Test
    public void testInsert(){
        PermisUserDO userDO = new PermisUserDO();
        userDO.setCreateTime(new Date());
        userDO.setDeptCode("DP0001");
        userDO.setEmpCode("275688");
        userDO.setEmpName("longhairen");
        userDO.setUserCode("275688");
        userDO.setStatus(0);
        userDO.setPassWord(MD5Util.md5Encrypt("123"));
        permisUserService.insert(userDO);
    }
}
