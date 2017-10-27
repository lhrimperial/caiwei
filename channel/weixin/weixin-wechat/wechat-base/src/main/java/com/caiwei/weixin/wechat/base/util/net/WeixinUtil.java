package com.caiwei.weixin.wechat.base.util.net;

import org.apache.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

/**
 * @author 龙海仁
 * @create：2015年12月14日 下午11:17:13
 * @description：
 */
public class WeixinUtil {
	
	private static Logger logger = Logger.getLogger(WeixinUtil.class);
	/**
	 * 
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @return
	 * @author 龙海仁
	 * @date 2015年12月14日下午11:18:09
	 * @update 
	 */
	public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
		StringBuffer buffer = new StringBuffer();
		HttpsURLConnection httpUrlConn =null;
		OutputStream outputStream = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		try {
			// 创建 SSLContext 对象，并使用我们指定的信任管理器初始化
			TrustManager[] trust = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, trust, new java.security.SecureRandom());

			// 从上述 SSLContext 对象中得到 SSLSocketFactory 对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			httpUrlConn.setConnectTimeout(300000);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();
			// 当有数据需要提交时
			if (null != outputStr) {
				outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				try {
					outputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 将返回的输入流转换成字符串
			inputStream = httpUrlConn.getInputStream();
			inputStreamReader = new InputStreamReader(
					inputStream , "utf-8");
			bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			
		} catch (ConnectException ce) {
			logger.error("Weixin server connection timed out." + ce.getMessage());
		} catch (Exception e) {
			logger.error("https request error:{}", e);
		}finally{
			try {
				if(inputStream != null){
					inputStream.close();
				}
				if(inputStreamReader != null){
					inputStreamReader.close();
				}
				if(bufferedReader != null){
					bufferedReader.close();
				}
				if(httpUrlConn != null){
					httpUrlConn.disconnect();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return buffer.toString();
	}
	
	public static InputStream httpsGetMedia(String requestUrl, String requestMethod, String outputStr) {
		HttpsURLConnection httpUrlConn =null;
		OutputStream outputStream = null;
		InputStream inputStream = null;
		try {
			// 创建 SSLContext 对象，并使用我们指定的信任管理器初始化
			TrustManager[] trust = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, trust, new java.security.SecureRandom());

			// 从上述 SSLContext 对象中得到 SSLSocketFactory 对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			httpUrlConn.setConnectTimeout(300000);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();
			// 当有数据需要提交时
			if (null != outputStr) {
				outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				try {
					outputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 将返回的输入流转换成字符串
			inputStream = httpUrlConn.getInputStream();
		} catch (ConnectException ce) {
			logger.error("Weixin server connection timed out." + ce.getMessage());
		} catch (Exception e) {
			logger.error("https request error:{}", e);
		}finally{
		}
		return inputStream;
	}
}
