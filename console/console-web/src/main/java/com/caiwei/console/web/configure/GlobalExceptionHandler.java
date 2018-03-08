package com.caiwei.console.web.configure;

import com.github.framework.server.cache.exception.security.UserNotLoginException;
import com.github.framework.server.context.RequestContext;
import com.github.framework.server.exception.BusinessException;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.shared.entity.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

//@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseVO<String> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        String url = RequestContext.getCurrentContext().getRemoteRequestURL();
        logger.info("request url defaultErrorHandler : " + url);

        Enumeration names = req.getHeaderNames();
        while(names.hasMoreElements()){
            String paraName=(String)names.nextElement();
            System.out.println(paraName+": "+req.getHeader(paraName));
        }


        Enumeration enu=req.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            System.out.println(paraName+": "+req.getParameter(paraName));
        }

        String errorCode = "";
        String message = "";
        if (e instanceof BusinessException) {
            errorCode = ((BusinessException) e).getErrorCode();
            message = e.getMessage();
        } else {
            errorCode = ErrorCode.FAILURE.getCode();
            message = ErrorCode.FAILURE.getName();
        }

        return new ResponseVO(false, errorCode, message);
    }
}
