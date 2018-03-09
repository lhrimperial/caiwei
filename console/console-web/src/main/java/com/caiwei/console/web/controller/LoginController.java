package com.caiwei.console.web.controller;

import com.caiwei.console.common.annotation.CookieNonCheckRequired;
import com.caiwei.console.common.context.PermisUserContext;
import com.caiwei.console.common.domain.DepartmentDO;
import com.caiwei.console.web.domain.LoginInfoVO;
import com.caiwei.console.web.domain.UserVO;
import com.caiwei.console.web.domain.cookie.Cookie;
import com.caiwei.console.web.service.ILoginService;
import com.github.framework.server.cache.exception.security.UserNotLoginException;
import com.github.framework.server.exception.BusinessException;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import com.github.framework.server.web.security.SecurityNonCheckRequired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@Controller
public class LoginController extends AbstractController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ILoginService loginService;

    @RequestMapping("/index")
    @SecurityNonCheckRequired
    @CookieNonCheckRequired
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
    @SecurityNonCheckRequired
    @CookieNonCheckRequired
    public ResponseVO login(Model model, @RequestBody UserVO userVo, HttpServletRequest request, HttpServletResponse response) {
        try {
            loginService.userLogin(userVo.getUserCode(), userVo.getPassWord());
            // 这时跳转到main 根据session生成cookie
            Cookie.saveCookie();
            return this.returnSuccess();
        } catch (BusinessException e) {
            return this.returnError(e);
        } catch (Exception ee) {
            logger.error("",ee);
            return this.returnError();
        }
    }

    @RequestMapping("/main")
    @CookieNonCheckRequired
    public String main() {
        return "main";
    }

    @ResponseBody
    @RequestMapping("/homePage")
    public String homePage() {
        return "Hello, Welcome!";
    }

    @ResponseBody
    @RequestMapping("/logout")
    public ResponseVO logout() {
        loginService.logout();
        //失效Cookie
        Cookie.invalidateCookie();
        return returnSuccess();
    }

    @ResponseBody
    @RequestMapping("/currentUserInfo")
    public ResponseVO<LoginInfoVO> currentLoginUserInfo() {
        ResponseVO responseVO = returnSuccess();
        LoginInfoVO loginInfoVO = loginService.currentLoginUserInfo();
        responseVO.setResult(loginInfoVO);
        return responseVO;
    }

    /**
     * 查询当前可切换部门
     * @return
     */
    @ResponseBody
    @RequestMapping("/currentUserChangeDepts")
    public ResponseVO<DepartmentDO> currentUserChangeDepts() {
        return returnSuccess();
    }

    /**
     * 切换部门
     * @return
     */
    @ResponseBody
    @RequestMapping("/changeCurrentDept")
    public ResponseVO<DepartmentDO> changeCurrentDept(String currenUserDeptCode) {

        return returnSuccess();
    }



}
