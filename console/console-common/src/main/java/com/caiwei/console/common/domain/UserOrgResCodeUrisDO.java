package com.caiwei.console.common.domain;

import java.io.Serializable;

/**
 *
 */
public class UserOrgResCodeUrisDO implements Serializable{
    private static final long serialVersionUID = 6073805750047708090L;
    /**
     * 资源权限编码
     */
    private String resCode;

    /**
     * 资源权限uri
     */
    private String resUri;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResUri() {
        return resUri;
    }

    public void setResUri(String resUri) {
        this.resUri = resUri;
    }
}
