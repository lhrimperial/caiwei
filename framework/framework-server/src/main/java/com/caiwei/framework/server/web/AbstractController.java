package com.caiwei.framework.server.web;

import com.caiwei.framework.server.exception.BusinessException;
import com.caiwei.framework.server.shared.entity.ErrorCode;
import com.caiwei.framework.server.shared.entity.ResponseVO;
import com.caiwei.framework.server.web.message.IMessageBundle;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author longhr
 * @version 2017/11/8 0008
 */
public class AbstractController {

    @Autowired
    protected IMessageBundle messageBundle;

    protected ResponseVO returnSuccess() {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setSuccess(true);
        responseVO.setResCode(ErrorCode.SUCCESS.getCode());
        responseVO.setResMsg(ErrorCode.SUCCESS.getName());
        return responseVO;
    }

    protected ResponseVO returnSuccess(String message) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setSuccess(true);
        responseVO.setResCode(ErrorCode.SUCCESS.getCode());
        responseVO.setResMsg(message);
        return responseVO;
    }

    protected ResponseVO returnError(BusinessException e) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setSuccess(true);
        responseVO.setResCode(ErrorCode.SUCCESS.getCode());
        responseVO.setResMsg(e.getMessage());
        return responseVO;
    }

    protected ResponseVO returnError(String message) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setSuccess(false);
        responseVO.setResCode(ErrorCode.FAILURE.getCode());
        responseVO.setResMsg(message);
        return responseVO;
    }

    protected ResponseVO returnError() {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setSuccess(false);
        responseVO.setResCode(ErrorCode.FAILURE.getCode());
        responseVO.setResMsg(ErrorCode.FAILURE.getName());
        return responseVO;
    }

}
