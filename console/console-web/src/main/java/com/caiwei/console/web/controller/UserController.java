package com.caiwei.console.web.controller;

import com.caiwei.console.web.domain.RoleVO;
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
    @RequestMapping("/findUserById")
    public ResponseVO<UserVO> findUserById(@RequestBody UserVO userVO) {
        ResponseVO responseVO = returnSuccess();
        responseVO.setResult(systemSetService.findUserById(userVO));
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public ResponseVO<String> updateUser(@RequestBody UserVO userVO) {
        ResponseVO responseVO = returnSuccess();
        systemSetService.updateUser(userVO);
        responseVO.setResult("修改用户成功");
        return responseVO;
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
        return systemSetService.queryUserDept(userVO);
    }

    @ResponseBody
    @RequestMapping("/queryOrgRoleByUserCode")
    public ResponseVO<RoleVO> queryOrgRoleByUserCode(@RequestBody UserVO userVO) {
        ResponseVO responseVO = returnSuccess();
        responseVO.setResult(systemSetService.queryOrgRoleByUserCode(userVO));
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/queryAllRole")
    public RoleVO queryAllRole(@ModelAttribute RoleVO roleVO) {
        return systemSetService.queryAllRole(roleVO);
    }

    @ResponseBody
    @RequestMapping("/updateUserOrgRole")
    public ResponseVO<String> updateUserOrgRole(@RequestBody UserVO userVO) {
        ResponseVO responseVO = returnSuccess();
        systemSetService.updateUserOrgRole(userVO);
        responseVO.setResult("用户角色配置成功！");
        return responseVO;
    }
}
