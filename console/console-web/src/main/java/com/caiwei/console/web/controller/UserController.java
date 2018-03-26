package com.caiwei.console.web.controller;

import com.caiwei.console.web.domain.UserVO;
import com.caiwei.console.web.service.ISystemSetService;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 **/
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController{

    @Autowired
    private ISystemSetService systemSetService;

    @RequestMapping("/index")
    public String index() {
        return "/sysset/user";
    }


    @ResponseBody
    @RequestMapping("/queryUserList")
    public UserVO queryUserList(@ModelAttribute UserVO userVO) {
        return systemSetService.queryUserList(userVO);
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public ResponseVO<String> addUser(@RequestBody UserVO userVO) {
        ResponseVO responseVO = returnSuccess();
        systemSetService.addUser(userVO);
        return responseVO;
    }


    @ResponseBody
    @RequestMapping("/deleteUser")
    public ResponseVO<String> deleteUser(@RequestBody UserVO userVO) {
        ResponseVO responseVO = returnSuccess();
        systemSetService.deleteUser(userVO);
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/queryUserDept")
    public UserVO queryUserDept(@ModelAttribute UserVO userVO) {
        return null;
    }

}
