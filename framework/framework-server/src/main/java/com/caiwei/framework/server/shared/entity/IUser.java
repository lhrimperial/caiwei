package com.caiwei.framework.server.shared.entity;

import java.util.Set;

/**
 * @ClassName: BaseEntity
 * @Description: TODO
 * @author 龙海仁
 * @date 2016年3月19日下午5:34:22
 *
 */
public interface IUser {

	/**
	 * 获取用户的所有角色id getRoleids
	 */
	Set<String> getRoleids();

	Set<String> queryAccessUris();

	void setRoleids(Set<String> paramSet);

	void setUserName(String paramString);

	String getUserName();
}
