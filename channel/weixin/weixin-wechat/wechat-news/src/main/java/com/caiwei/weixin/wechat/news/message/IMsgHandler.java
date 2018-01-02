package com.caiwei.weixin.wechat.news.message;



import com.caiwei.framework.server.exception.BusinessException;

import java.util.Map;


/**
 * @ClassName: IMsgHandler
 * @Description:
 * @author hairen.long@hoau.net
 * @date 2015年4月3日 上午11:21:37
 */
public interface IMsgHandler {

	public String handleMsg(Map<String, String> inputParams)
			throws BusinessException;
}
