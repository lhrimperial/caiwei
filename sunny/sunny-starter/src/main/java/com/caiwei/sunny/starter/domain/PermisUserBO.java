package com.caiwei.sunny.starter.domain;

import com.caiwei.framework.server.shared.entity.IUser;
import com.caiwei.sunny.mdm.permis.api.domain.PermisUserDO;

import java.util.Set;

/**
 * @author longhr
 * @version 2017/11/8 0008
 */
public class PermisUserBO extends PermisUserDO implements IUser {

    @Override
    public Set<String> getRoleids() {
        return null;
    }

    @Override
    public Set<String> queryAccessUris() {
        return null;
    }

    @Override
    public void setRoleids(Set<String> paramSet) {

    }

    @Override
    public void setUserName(String paramString) {

    }

    @Override
    public String getUserName() {
        return null;
    }
}
