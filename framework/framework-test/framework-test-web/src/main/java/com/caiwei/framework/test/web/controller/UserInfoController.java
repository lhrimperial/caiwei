package com.caiwei.framework.test.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author longhairen
 * @create 2017/8/21 0021 上午 10:29
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    @Qualifier("userInfoDruidService")
    private com.caiwei.framework.test.web.service.IUserInfoService userInfoService;

    @RequestMapping("/find/{id}")
    public com.caiwei.framework.test.web.domain.UserInfo findUserInfo(@PathVariable("id") int id){
        return userInfoService.findUserInfo(id);
    }

    @RequestMapping("/list/{pageNO}")
    public List<com.caiwei.framework.test.web.domain.UserInfo> findUserList(@PathVariable("pageNO") int pageNO){
        return userInfoService.findUserInfoList(pageNO);
    }
}
