package com.caiwei.framework.test.jdbc.controller;

import com.caiwei.framework.test.jdbc.domain.UserPO;
import com.caiwei.framework.test.jdbc.service.IUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class UserController {

    private IUserService userService;

    @RequestMapping("/find/{id}")
    public UserPO findUser(@PathVariable Integer id) {
        return userService.findByUserName(id);
    }
}
