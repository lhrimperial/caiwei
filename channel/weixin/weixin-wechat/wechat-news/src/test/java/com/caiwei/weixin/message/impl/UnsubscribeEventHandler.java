package com.caiwei.weixin.message.impl;

import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 取消关注事件
 * UnsubscribeEventHandler
 * @author 龙海仁
 * @create：2016年3月29日 下午11:28:28 
 */
@Service
public class UnsubscribeEventHandler extends AbstractHandler{
	
//	@Autowired
//	private IWechatUserService wechatUserService;
	
	@Override
	public String getContent(Map<String, String> inputPara) {
		return "";
		
	}

}
