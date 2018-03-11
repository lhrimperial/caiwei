package com.caiwei.console.web.configure;

import com.github.framework.server.cache.exception.security.UserNotLoginException;
import com.github.framework.server.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(RedirectAttributes model, HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        String url = RequestContext.getCurrentContext().getRemoteRequestURL();
        logger.info("request url defaultErrorHandler : " + url);
        logger.error(e.getMessage(), e);

        String contentType = response.getContentType();
        logger.info("contentType : " + contentType);

        String returnUrl = "/error";
        String message = "系统异常!";

        if (e instanceof UserNotLoginException) {
            returnUrl = "redirect:/index";
        } else {
            model.addAttribute("url", url);
            model.addAttribute("message", message);
        }
        return returnUrl;
    }
}
