package com.weixin;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


/**
 * 微信web登录
 */
public class WeiXinUtilWeb {
		
	public static void main(String[] ddd) {

	}

	
	/**
	 * PC端Web 第一步：请求CODE
	 * 
	 * @param state
	 * @return
	 */
	public static String appid_web="wxcb5b3d6e66df005f";//开放平台web应用
	public static String AppSecret_web = "ce2df81e64c1c63b02fcffbcdbfa6a9b";
	public static String userinfo_redirect_uri_web="https://www.youlunhai.com/youlhai/api/weixin/reqTokenWeb";
	public static String bindweixin_redirect_uri_web="https://www.youlunhai.com/youlhai/api/weixin/reqTokenBindweixinWeb";
	public static String getReqCodUrl_web ="https://open.weixin.qq.com/connect/qrconnect?";
	// 微信登陆第二步 通过code获取access_token，url
	private static final String getReqTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?";
	// 微信登陆第三步 通过access_token获取用户信息，url
	private static final String getReqUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?";
	private static final String grant_type_web = "authorization_code";// 填authorization_code
	public static String scope_web="snsapi_login";
	public static String response_type_web = "code";// 填code
	public static String getReqCodUrlWeb(String state) {
		StringBuffer sb = new StringBuffer(getReqCodUrl_web);

		try
		{
			sb.append("appid=").append(appid_web);
			sb.append("&");
			sb.append("redirect_uri=").append(
					URLEncoder.encode(userinfo_redirect_uri_web,"utf-8"));
			sb.append("&");
			sb.append("response_type=").append(response_type_web);
			sb.append("&");
			sb.append("scope=").append(scope_web);
			sb.append("&");
			sb.append("state=").append(state);
			sb.append("#wechat_redirect");
		}catch (Exception e){

		}


		return sb.toString();
	}
	/**
	 * Web 微信登陆第二步：获取CODE 通过code获取access_token
	 * 
	 * @param code
	 * @return
	 */
	public static String getReqTokenUrlWeb(String code) {

		StringBuffer sb = new StringBuffer(getReqTokenUrl);

		sb.append("appid=").append(appid_web);
		sb.append("&");
		sb.append("secret=").append(AppSecret_web);
		sb.append("&");
		sb.append("grant_type=").append(grant_type_web);
		sb.append("&");
		sb.append("code=").append(code);

		return sb.toString();
	}

	public static String getReqUserInfoUrl(String token, String openid) {
		StringBuffer sb = new StringBuffer(getReqUserInfoUrl);

		sb.append("access_token=").append(token);
		sb.append("&");
		sb.append("openid=").append(openid);
		sb.append("&");
		sb.append("lang=zh_CN");

		return sb.toString();

	}
	
	
	public static String postUrl(String remoteUrl, String param) {
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		StringBuffer sb = new StringBuffer();
		try {
			url = new URL(remoteUrl);

			httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setDoOutput(true);
			httpurlconnection.setRequestMethod("POST");
			httpurlconnection.getOutputStream().write(param.getBytes("UTF-8"));
			httpurlconnection.getOutputStream().close();
			InputStream in = httpurlconnection.getInputStream();
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = in.read(b)) != -1) {
				sb.append(new String(b, 0, i, "UTF-8"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			sb.append("");

		} finally {
			if (httpurlconnection != null)
				httpurlconnection.disconnect();

		}
		return sb.toString();
	}
	public static String getReqCodUrlWebBindWeixin(String state) {
		StringBuffer sb = new StringBuffer(getReqCodUrl_web);
		try{
			sb.append("appid=").append(appid_web);
			sb.append("&");
			sb.append("redirect_uri=").append(
					URLEncoder.encode(bindweixin_redirect_uri_web,"utf-8"));
			sb.append("&");
			sb.append("response_type=").append(response_type_web);
			sb.append("&");
			sb.append("scope=").append(scope_web);
			sb.append("&");
			sb.append("state=").append(state);
			sb.append("#wechat_redirect");
		}catch (Exception e){

		}

		return sb.toString();
	}

	
	
}
