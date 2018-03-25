package com.caiwei.console.web.domain;

import com.caiwei.console.common.domain.PermisUserDO;
import com.github.framework.server.shared.domain.vo.BaseVO;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public class UserVO extends BaseVO implements Serializable {
    private static final long serialVersionUID = 4565436761708584140L;

    private String userCode;
    private String passWord;

    private List<String> userCodes;

    private String queryParam;

    private PermisUserDO userDO;
    private List<PermisUserDO> userDOS;

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public List<String> getUserCodes() {
        return userCodes;
    }

    public void setUserCodes(List<String> userCodes) {
        this.userCodes = userCodes;
    }

    public PermisUserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(PermisUserDO userDO) {
        this.userDO = userDO;
    }

    public List<PermisUserDO> getUserDOS() {
        return userDOS;
    }

    public void setUserDOS(List<PermisUserDO> userDOS) {
        this.userDOS = userDOS;
    }

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
