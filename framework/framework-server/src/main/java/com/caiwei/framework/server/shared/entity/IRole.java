package com.caiwei.framework.server.shared.entity;

import java.util.Collection;

/**
 * @ClassName: BaseEntity
 * @Description: TODO
 * @author 龙海仁
 * @date 2016年3月19日下午5:34:22
 *
 */
public interface IRole  extends IEntity{
	
	Collection<String> getFunctionIds();

}