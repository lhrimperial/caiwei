package com.caiwei.console.web.controller;

import com.caiwei.console.common.domain.PermisUserDO;
import com.caiwei.console.persistent.domain.UserPO;
import com.caiwei.console.web.context.PermisUserContext;
import com.caiwei.console.web.domain.UserVO;
import com.caiwei.console.web.service.ILoginService;
import com.github.framework.server.cache.exception.security.UserNotLoginException;
import com.github.framework.server.context.UserContext;
import com.github.framework.server.exception.BusinessException;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
public class LoginController extends AbstractController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/index")
    public String index() {
        try {
            PermisUserContext.getCurrentUser();
        } catch(UserNotLoginException e) {
            return "login";
        }
        return "main";
    }

    @ResponseBody
    @RequestMapping("/login")
    public ResponseVO login(Model model, @RequestBody UserVO userVo) {
        try {
            loginService.userLogin(userVo.getUserCode(), userVo.getPassWord());
            // 这时跳转到main.jsp 根据session生成cookie
//                Cookie.saveCookie();
            return this.returnSuccess();
        } catch (BusinessException e) {
            return this.returnError(e);
        } catch (Exception ee) {
            return this.returnError();
        }
    }

    @RequestMapping("/currentUserInfo")
    public ResponseVO<PermisUserDO> currentLoginUserInfo() {

        return returnSuccess();
    }

}
