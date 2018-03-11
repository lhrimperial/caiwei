package com.caiwei.console.web.controller;

import com.caiwei.console.web.domain.UserVO;
import com.caiwei.console.web.service.IUserService;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 **/
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController{

    @Autowired
    private IUserService userService;

    @RequestMapping("/index")
    public String index() {
        return "/sysset/user";
    }


    @ResponseBody
    @RequestMapping("/queryUserList")
    public UserVO queryUserList(UserVO userVO) {
        return userService.queryUserList(userVO);
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public ResponseVO<String> addUser(UserVO userVO) {
        ResponseVO responseVO = returnSuccess();

        return responseVO;
    }


    @ResponseBody
    @RequestMapping("/deleteUser")
    public ResponseVO<String> deleteUser(UserVO userVO) {
        ResponseVO responseVO = returnSuccess();


        return responseVO;
    }
}
