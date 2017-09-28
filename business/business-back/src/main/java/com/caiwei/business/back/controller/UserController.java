package com.caiwei.business.back.controller;

import com.caiwei.business.user.api.domain.UserPO;
import com.caiwei.business.user.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author longhairen
 * @create 2017/9/28 0028 下午 5:17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/find/{userCode}")
    public UserPO findUser(@PathVariable("userCode") String userCode) {
        return userService.findUserByCode(userCode);
    }
}
