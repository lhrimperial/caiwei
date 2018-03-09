package com.caiwei.console.web.interceptor;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.caiwei.console.common.annotation.CookieNonCheckRequired;
import com.caiwei.console.common.context.PermisUserContext;
import com.caiwei.console.web.domain.cookie.Cookie;
import com.caiwei.console.web.domain.cookie.CookieConstant;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 *
 */
public class ValidatorCookieInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (((HandlerMethod) handler).hasMethodAnnotation(CookieNonCheckRequired.class)) {
            return super.preHandle(request, response, handler);
        }
        String ssoToken = request.getParameter(CookieConstant.TOKEN_NAME);
        if (StringUtils.isBlank(ssoToken)) {
            // 当前服务session中没有user对象,从cookie中初始化user到session中
            Cookie.cookieToSession();
        }

        // 重新生成cookie或修改cookie中时间戳
        Cookie.saveCookie();
        PermisUserContext.getCurrentUser().loadAccess();

        return super.preHandle(request, response, handler);
    }
}
