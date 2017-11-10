package com.caiwei.framework.server.shared.entity;

import java.io.Serializable;

/**
 * @author longhr
 * @version 2017/11/8 0008
 */
public class ResponseVO<T> implements Serializable{
    private static final long serialVersionUID = -3640707473825917708L;
    private boolean success;
    private String resCode;
    private String resMsg;
    private T result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
