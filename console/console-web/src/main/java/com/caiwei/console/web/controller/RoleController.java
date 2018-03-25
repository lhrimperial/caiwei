package com.caiwei.console.web.controller;

import com.caiwei.console.web.domain.RoleVO;
import com.caiwei.console.web.service.ISystemSetService;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 **/
@Controller
@RequestMapping("/role")
public class RoleController extends AbstractController {

    @Autowired
    private ISystemSetService systemSetService;

    @RequestMapping("/index")
    public String index() {
        return "/sysset/role";
    }

    @ResponseBody
    @RequestMapping("/findRole")
    public ResponseVO<RoleVO> findRole(@RequestBody RoleVO roleVO) {
        ResponseVO responseVO = returnSuccess();
        responseVO.setResult(systemSetService.findRole(roleVO));
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/listRole")
    public RoleVO findRoles(@ModelAttribute RoleVO roleVO) {
        return systemSetService.queryRoleList(roleVO);

    }

    @ResponseBody
    @RequestMapping("/addRole")
    public ResponseVO<String> addRole(@RequestBody RoleVO roleVO) {
        ResponseVO responseVO = returnSuccess();
        systemSetService.addRole(roleVO);
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/updateRole")
    public ResponseVO<String> updateRole(@RequestBody RoleVO roleVO) {
        ResponseVO responseVO = returnSuccess();
        systemSetService.updateRole(roleVO);
        return responseVO;
    }


    @ResponseBody
    @RequestMapping("/deleteRole")
    public ResponseVO<String> deleteRoles(@RequestBody RoleVO roleVO) {
        ResponseVO responseVO = returnSuccess();
        systemSetService.deleteRole(roleVO);
        return responseVO;
    }
}
