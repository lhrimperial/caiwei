package com.caiwei.weixin.servlet;

import com.caiwei.weixin.service.CoreService;
import com.caiwei.weixin.wechat.base.define.WechatConst;
import com.caiwei.weixin.wechat.base.util.WechatSignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author 龙海仁
 * @create：2016年1月7日 下午5:29:23
 * @description：明文模式 微信消息入口
 */
public class WeChatServlet extends HttpServlet {

	Logger logger = LoggerFactory.getLogger(WeChatServlet.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 8894456031004204535L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
		try {
			// 微信加密签名
			String signature = request.getParameter("signature");
			// 时间戳
			String timestamp = request.getParameter("timestamp");
			// 随机数
			String nonce = request.getParameter("nonce");
			// 随机字符串
			String echostr = request.getParameter("echostr");

			logger.info("signature:" + signature + ",timestamp:" + timestamp
					+ ",nonce:" + nonce + ",echostr:" + echostr);

			out = response.getWriter();
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			if (WechatSignUtil.checkSignature(WechatConst.WECHAT_TOKEN, signature, timestamp, nonce)) {
				out.print(echostr);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}finally{
			if(out != null){
				out.close();
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 输出
		PrintWriter out = null;
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			ApplicationContext context = WebApplicationContextUtils
					.getWebApplicationContext(getServletContext());
			// 处理消息
			String respMessage = CoreService.handleMsg(request, context);
			logger.info(respMessage);
			out = response.getWriter();
			out.print(respMessage);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}finally{
			if(out != null){
				out.close();
			}
		}

	}

}
