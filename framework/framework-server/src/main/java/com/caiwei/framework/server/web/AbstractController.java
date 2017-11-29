package com.caiwei.framework.server.web;

import com.caiwei.framework.server.exception.BusinessException;
import com.caiwei.framework.server.shared.entity.ErrorCode;
import com.caiwei.framework.server.shared.entity.ResponseVO;
import com.caiwei.framework.server.web.message.IMessageBundle;
import org.springframework.beans.factory.annotation.Autowired;
import sun.font.TrueTypeFont;

/**
 * @author longhr
 * @version 2017/11/8 0008
 */
public class AbstractController {

    @Autowired
    protected IMessageBundle messageBundle;

    protected ResponseVO returnSuccess() {
        return new ResponseVO(true, ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getName());
    }

    protected ResponseVO returnSuccess(String message) {
        return new ResponseVO(true, ErrorCode.SUCCESS.getCode(), message);
    }

    protected ResponseVO returnError(BusinessException e) {
        return new ResponseVO(false, e.getErrorCode(), messageBundle.getMessage(e.getErrorCode(), e.getErrorArguments()));
    }

    protected ResponseVO returnError(String message) {
        return new ResponseVO(false, ErrorCode.FAILURE.getCode(), message);
    }

    protected ResponseVO returnError() {
        return new ResponseVO(false, ErrorCode.FAILURE.getCode(), ErrorCode.FAILURE.getName());
    }

}
