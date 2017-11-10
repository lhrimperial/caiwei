package com.caiwei.sunny.starter.controller;

import com.caiwei.framework.server.cache.exception.security.UserNotLoginException;
import com.caiwei.framework.server.exception.BusinessException;
import com.caiwei.framework.server.shared.entity.ResponseVO;
import com.caiwei.framework.server.web.AbstractController;
import com.caiwei.sunny.starter.context.SunnyUserContext;
import com.caiwei.sunny.starter.domain.PermisUserBO;
import com.caiwei.sunny.starter.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author longhr
 * @version 2017/11/7 0007
 */
@Controller
public class LoginController extends AbstractController{

    @Autowired
    private ILoginService loginService;

    @RequestMapping("/index")
    public String index() {
        try {
            SunnyUserContext.getCurrentUser();
        } catch(UserNotLoginException e) {
            return "login";
        }
        return "main";
    }

    @ResponseBody
    @RequestMapping("/login")
    public ResponseVO login(Model model, @RequestBody PermisUserBO permisUserBO) {
        try {
//                loginService.userLogin(currentUser.getUserName(),currentUser.getPassword());
            // 这时跳转到main.jsp 根据session生成cookie
//                Cookie.saveCookie();
            return this.returnSuccess();
        } catch (BusinessException e) {
            return this.returnError(e);
        }
    }

}
