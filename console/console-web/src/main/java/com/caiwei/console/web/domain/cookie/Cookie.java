package com.caiwei.console.web.domain.cookie;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.caiwei.console.common.define.ConsoleConstants;
import com.github.framework.server.cache.CacheManager;
import com.github.framework.server.cache.ICache;
import com.github.framework.server.cache.exception.security.UserNotLoginException;
import com.github.framework.server.context.SessionContext;
import com.github.framework.server.context.UserContext;
import com.github.framework.server.shared.define.Definitions;
import com.github.framework.server.shared.entity.IUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class Cookie {

    private Cookie() {
    }

    private static Cookie cookie;

    public static Cookie getInstance() {
        if (cookie == null) {
            cookie = new Cookie();
        }
        return cookie;
    }

    /**
     * 保存cookie 主要功能：
     * 1.根据session重新生成cookie
     * 2.修改cookie的时间戳
     */
    public static void saveCookie() {
        String tokenParam = getTokenParam();
        javax.servlet.http.Cookie cookie = getCookie();
        if (cookie != null) {
            // 修改cookie时间戳
            cookie.setValue(tokenParam);
        } else {
            // 重新new一个Cookie
            cookie = new javax.servlet.http.Cookie(CookieConstant.TOKEN_NAME, tokenParam);
        }
        cookie.setPath("/");// 同一个域名所有url cookie共享
//        cookie.setMaxAge(5*60);//不写入磁盘，只写入内存，只有在当前页面有用,浏览器关闭立即失效
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        response.addCookie(cookie);
    }

    /**
     * 获取Token字符串
     */
    public static String getTokenParam() {
        String userName = (String) SessionContext.getSession().getObject(
                Definitions.KEY_USER);
        String empCode = (String) SessionContext.getSession().getObject(
                ConsoleConstants.KEY_CURRENT_EMPCODE);
        String currentDeptCode = (String) SessionContext.getSession()
                .getObject(ConsoleConstants.KEY_CURRENT_DEPTCODE);
        String currentDeptName = (String) SessionContext.getSession()
                .getObject(ConsoleConstants.KEY_CURRENT_DEPTNAME);
        Token token = new Token(SessionContext.getSession().getId(), userName,
                empCode, currentDeptCode,currentDeptName, SessionContext.getSession()
                .getMaxInactiveInterval());
        return TokenMarshal.marshal(token);
    }

    /**
     * Cookie数据到Session 主要功能： 1.Cookie不存在，Throw UserNotLoginException异常
     * 2.Cookie存在，赋值到Session
     */
    public static void cookieToSession() {
        javax.servlet.http.Cookie cookie = getCookie();
        if (cookie != null) {
            String paramToken = cookie.getValue();
            if (StringUtils.isBlank(paramToken)) {
                throw new UserNotLoginException();// 用户未登录
            } else {
                Token token = TokenMarshal.unMarshal(paramToken);
                if (token != null && !token.expired()) {
                    Cookie.getInstance().tokenToSession(token);
                } else {
                    throw new UserNotLoginException();// 用户未登录
                }
            }
        } else {
            throw new UserNotLoginException();// 用户未登录
        }
    }

    /**
     * token的内容复制到session中
     */
    @SuppressWarnings("unchecked")
    private void tokenToSession(Token token) {
        SessionContext.getSession().setObject(ConsoleConstants.KEY_CURRENT_EMPCODE,
                token.getEmpCode());
        SessionContext.getSession().setObject(Definitions.KEY_USER,
                token.getUserId());
        SessionContext.getSession().setObject(ConsoleConstants.KEY_CURRENT_DEPTCODE,
                token.getCurrentDeptCode());
        SessionContext.getSession().setObject(ConsoleConstants.KEY_CURRENT_DEPTNAME,
                token.getCurrentDeptName());
        ICache<String, IUser> userCache = CacheManager.getInstance().getCache(IUser.class.getName());
        UserContext.setCurrentUser(userCache.get(token.getUserId()));
    }

    /**
     * 失效Cookie
     */
    public static void invalidateCookie() {
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        // 失效掉token的cookie
        javax.servlet.http.Cookie cookie_token = getCookie();
        if (cookie_token != null) {
            cookie_token.setMaxAge(0);// 设置为0立即删除
            response.addCookie(cookie_token);
        }
        javax.servlet.http.Cookie cookie_jsession = getCookie(CookieConstant.JSESSIONID);
        if (cookie_jsession != null) {
            cookie_jsession.setMaxAge(0);// 设置为0立即删除
            response.addCookie(cookie_jsession);
        }
    }

    /**
     * 获取HttpCookie对象,token对应的cookie
     */
    public static javax.servlet.http.Cookie getCookie() {
        return getCookie(CookieConstant.TOKEN_NAME);
    }

    /**
     * 获取HttpCookie对象,根据传入的cookie的name值获取
     */
    public static javax.servlet.http.Cookie getCookie(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }

        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        javax.servlet.http.Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (int i = 0, len = cookies.length; i < len; i++) {
                if (name.equals(cookies[i].getName())) {
                    return cookies[i];
                }
            }
        }
        return null;
    }
}
