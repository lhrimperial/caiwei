package com.caiwei.console.common.domain;

import com.github.framework.server.shared.entity.IUser;

import java.util.Set;

/**
 *
 */
public class PermisUserDO implements IUser {



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
