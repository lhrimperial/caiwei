package com.caiwei.framework.server.shared.entity;

import java.util.List;


/**
 * @ClassName: BaseEntity
 * @Description: TODO
 * @author 龙海仁
 * @date 2016年3月19日下午5:34:22
 *
 */
public interface IModule extends IEntity {
	
	List<IFunction>	 getFunctions();

}
