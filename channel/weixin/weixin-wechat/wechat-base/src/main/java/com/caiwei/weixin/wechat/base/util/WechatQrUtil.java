package com.caiwei.weixin.wechat.base.util;

import com.caiwei.framework.util.image.ImageUtils;
import com.caiwei.framework.util.file.*;
import com.caiwei.framework.util.json.JsonUtils;
import com.caiwei.framework.util.string.StringUtils;
import com.caiwei.weixin.wechat.base.define.WechatUrl;
import com.caiwei.weixin.wechat.base.entity.token.QrTicket;
import com.caiwei.weixin.wechat.base.util.net.WeixinUtil;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;


/**
 * 
 * WechatQrUtil
 * @author 龙海仁
 * @create：2016年6月19日 下午4:58:24 
 */
public class WechatQrUtil {
	
	private static Logger logger = Logger.getLogger(WechatQrUtil.class);
	
	public static QrTicket QR_TICKET;
	
	/**
	 * 获取QrTicket ticket
	 * @return
	 * @author 龙海仁
	 * @date 2015年12月15日下午8:13:44
	 * @update 
	 */
	public static String getTicketValue(int scene_id){
		String ticketCode = "";
		if(QR_TICKET == null || checkQrTicketTimeOut(QR_TICKET)){
			QR_TICKET = getTicket(scene_id);
			ticketCode = QR_TICKET.getTicket();
		}else{
			ticketCode = QR_TICKET.getTicket();
		}
		return ticketCode;
	}
	
	/**
	 * @Title: checkQrTicketTimeOut 
	 * @Description:检测QrTicket是否过期
	 * @param qrTicket
	 * @return
	 */
	private static boolean checkQrTicketTimeOut(QrTicket qrTicket) {
		boolean isOk = true;
		long currentTime = System.currentTimeMillis() / 1000;
		long differece = currentTime - qrTicket.getCurrentTime();
		if (differece > qrTicket.getExpire_seconds()) {
			isOk = true;
		} else {
			isOk = false;
		}
		return isOk;
	}
	/**
	 * 获取微信临时二维码 有效期10分钟
	 * @param scene_id
	 * @author 龙海仁
	 * @date 2016年6月19日下午4:59:52
	 * @update 
	 */
	public static QrTicket getTicket(int scene_id){
		// 创建二维码ticket接口
		String createUrl = StringUtils.formart(WechatUrl.QR_SCENE, WeChatUtil.getToken());
		String postParam = "{\"expire_seconds\": 7200, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+scene_id+"}}}";
		String qrTtoken = WeixinUtil.httpRequest(createUrl, "POST", postParam);
		logger.info(qrTtoken);
		
		QrTicket tickect = JsonUtils.toObject(qrTtoken, QrTicket.class);
		if(tickect != null){
			tickect.setCurrentTime(System.currentTimeMillis() / 1000);
		}
		return tickect;
	}
	
	
	/**
	 * 获取微信临时二维码的base64String
	 * @param scene_id
	 * @return
	 * @author 龙海仁
	 * @date 2016年6月19日下午7:15:36
	 * @update 
	 */
	public static String genInterimQrBase64Code(int scene_id){
		String qrBase64Code = null;
		// 用  （tickectStr）换取二维码
		String tickectStr = getTicketValue(scene_id);
		logger.info("tickectStr:"+tickectStr);
		
		String encode = URLEncoder.encode(tickectStr);
		
		String downQrUrl = StringUtils.formart( WechatUrl.EXCHANGE_QR, encode);
		InputStream inputStream = WeixinUtil.httpsGetMedia(downQrUrl, "GET", null);
		
		try {
			File qrFile  = FileUtil.stream2file(inputStream);
			qrBase64Code = ImageUtils.encodeImgageToBase64(qrFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return qrBase64Code;
	}
	
}
