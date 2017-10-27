package com.caiwei.weixin.service;

import com.caiwei.framework.util.json.FastJsonUtil;
import com.caiwei.weixin.message.MsgDispatcher;
import com.caiwei.weixin.wechat.base.define.MessageKey;
import com.caiwei.weixin.wechat.base.define.MsgKey;
import com.caiwei.weixin.wechat.base.entity.resp.text.ResTextMsg;
import com.caiwei.weixin.wechat.base.util.MessageUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;


/**
 * @author 龙海仁
 * @create：2016年1月7日 下午5:33:28
 * @description：消息核心消息处理类
 */
public class CoreService {
	
	private static Logger logger = Logger.getLogger(CoreService.class);
	
	public static String handleMsg(HttpServletRequest request, ApplicationContext context){
		String respMessage = null;
		Map<String, String> requestMap = null;
        try {
			// xml请求解析  
			requestMap = MessageUtil.parseXml(request);
			logger.info(FastJsonUtil.toJsonString(requestMap));
			//记录消息日志
			save(requestMap,context);
			//处理消息
			respMessage = MsgDispatcher.dispatch(requestMap,context);
		} catch (Exception e) {
			respMessage = exception(requestMap,"服务器目前无法处理您的请求！");
			logger.error("消息处理异常");
		}
        logger.info(respMessage);
        return respMessage;
	}
	
	public static String exception(Map<String, String> requestMap, String exceptionContent) {
		ResTextMsg textMessage = new ResTextMsg();
		textMessage.setToUserName(requestMap.get("FromUserName"));  
	    textMessage.setFromUserName(requestMap.get("ToUserName"));  
	    textMessage.setCreateTime(new Date().getTime());
	    textMessage.setMsgType(MessageKey.RESP_MSG_TYPE_TEXT);
	    textMessage.setContent(exceptionContent);
	    return MessageUtil.textMessageToXml(textMessage);
	}
	
	private static void save(Map<String, String> requestMap, ApplicationContext context){
		try {
			//记录日志
//			IMsgManageService msgManageService = (IMsgManageService)context.getBean("msgManageService");
//			msgManageService.insertMsg(requestMap);
			//user openid
			String openid = requestMap.get(MsgKey.KEY_FROMUSER);
			//获取用户信息
		/*	IWechatUserManageService wechatUserManageService = (IWechatUserManageService) context.getBean("wechatUserManageService");
			IWechatUserService wechatUserService = (IWechatUserService) context.getBean("wechatUserService");
			try {
				if(!wechatUserService.existWechatUser(openid)){
					WechatUserInfo info = wechatUserManageService.achieveWechatUserInfo(openid, WeChatUtil.getToken());
					wechatUserService.saveWechatUserInfo(info);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		} catch (BeansException e) { 
			logger.error("保存请求消息异常！");
			e.printStackTrace();
		}
	}

}
