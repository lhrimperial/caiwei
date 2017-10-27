package com.caiwei.framework.test.readwrite.controller;

import com.caiwei.framework.test.readwrite.domain.UserTestPO;
import com.caiwei.framework.test.readwrite.service.IUserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author longhairen
 * @create 2017/10/27 0027 下午 2:44
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private IUserTestService userTestService;

    @RequestMapping("/find/{id}")
    public UserTestPO findUserById(@PathVariable("id") int id) {
        return userTestService.getUserTestPO(id);
    }
}
