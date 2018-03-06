package com.caiwei.console.web.domain;

import java.io.Serializable;

/**
 *
 */
public class UserVO implements Serializable {
    private static final long serialVersionUID = 4565436761708584140L;

    private String userCode;
    private String passWord;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
