package com.caiwei.console.web.configure;

import com.github.framework.server.cache.exception.security.UserNotLoginException;
import com.github.framework.server.context.RequestContext;
import com.github.framework.server.exception.BusinessException;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.shared.entity.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.ServerSocket;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(Model model, HttpServletRequest req, Exception e) throws Exception {
        String url = RequestContext.getCurrentContext().getRemoteRequestURL();
        logger.info("request url defaultErrorHandler : " + url);
        logger.error(e.getMessage(), e);

        String returnUrl = "/error";
        String message = "系统异常!";

        if (e instanceof UserNotLoginException) {
            returnUrl = "redirect:index";
        } else {
            model.addAttribute("url", url);
            model.addAttribute("message", message);
        }
        return returnUrl;
    }
}
