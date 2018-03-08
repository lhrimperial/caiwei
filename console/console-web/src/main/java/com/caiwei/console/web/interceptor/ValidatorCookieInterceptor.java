package com.caiwei.console.web.interceptor;

import com.caiwei.console.common.annotation.CookieNonCheckRequired;
import com.caiwei.console.common.context.PermisUserContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        PermisUserContext.getCurrentUser().loadAccess();

        return super.preHandle(request, response, handler);
    }
}
