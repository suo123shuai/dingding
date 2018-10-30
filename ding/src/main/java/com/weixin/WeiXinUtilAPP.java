package com.weixin;

import com.alibaba.fastjson.JSONObject;
import org.jdom.JDOMException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WeiXinUtilAPP {
	/**
	 * 商家可以考虑读取配置文件
	 * app支付设置
	 * 6zulineng88KKHGIK6969HGHRczulin1
	 */
	
	//初始化
	public static String APP_ID = "wxe027fd644fe7aab6";//微信开放平台应用id
	public static String PARTNER = "1512803141";//财付通商户号
	public static String PARTNER_KEY = "shenglaui09KKUHGIK2414HGHRF9KH19";//商户号对应的密钥
	//统一下单接口
	public static final String getPreOrderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	public static String notify_url="https://www.youlunhui.com/youlh/p/weixin/wxNotify";

	
	/**
	 * 随机字符串
	 * @return
	 */
	public static String getNonceStr() {
		Random random = new Random();
		return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)),"utf-8");
	}
	/**
	 * 预支付订单
	 * @param orderNum
	 * @param body
	 * @param totalFee
	 * @param ip
	 * @param attach
	 * @return
	 */
	public static String getPreOrderApp(String orderNum, String body,
				String totalFee, String ip, HashMap attach) {
			// TODO Auto-generated method stub
			String attachStr = JSONObject.toJSONString(attach).toString();

			String nonce_str = getNonceStr();

			String signSoure = "appid=" + APP_ID + "&attach=" + attachStr + "&body="
					+ body + "&mch_id=" + PARTNER + "&nonce_str=" + nonce_str
					+ "&notify_url=" + notify_url + "&out_trade_no=" + orderNum
					+ "&spbill_create_ip=" + ip + "&total_fee=" + totalFee
					+ "&trade_type=APP";

			String stringSignTemp = signSoure + "&key=" + PARTNER_KEY;
			String sign = MD5Util.MD5Encode(stringSignTemp,"utf-8").toUpperCase();
			String param = "<xml>" + "<appid>" + APP_ID + "</appid>" + "<attach>"
					+ attachStr + "</attach>" + "<body>" + body + "</body>"
					+ "<mch_id>" + PARTNER + "</mch_id>" + "<nonce_str>" + nonce_str
					+ "</nonce_str>" + "<notify_url>" + notify_url
					+ "</notify_url>" + "<out_trade_no>" + orderNum
					+ "</out_trade_no>" + "<spbill_create_ip>" + ip
					+ "</spbill_create_ip>" + "<total_fee>" + totalFee
					+ "</total_fee>" + "<trade_type>APP</trade_type>" + "<sign>"
					+ sign + "</sign>" + "</xml>";

//			try {
//				//解决body汉字乱码
//				return new String(param.toString().getBytes(), "ISO8859-1");
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			return param;

	}
	public static HashMap createCallAppPayParam(String prepay_id) {
		// TODO Auto-generated method stub
		String nonce_str = getNonceStr();
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("appid",APP_ID);
		param.put("noncestr",nonce_str);//10000以内随机数字，MD5加密大写后的字符串
		param.put("package","Sign=WXPay");
		param.put("partnerid",PARTNER);//财付通账号
		param.put("prepayid",prepay_id);
		param.put("timestamp",getTimeStamp());


		String signSoure = "appid=" + APP_ID + "&noncestr=" + nonce_str
				+ "&package=" + param.get("package") + "&partnerid=" + param.get("partnerid")
				+ "&prepayid=" +  param.get("prepayid") + "&timestamp=" + param.get("timestamp");
		String stringSignTemp = signSoure + "&key=" + PARTNER_KEY;
		String sign = MD5Util.MD5Encode(stringSignTemp,"utf-8").toUpperCase();

		param.put("sign",sign);//其他参数按照字符顺序&链接，最后加上key，MD5加密后大写

		return param;
	}

	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}
	/**
	 * 获取参数
	 * @param xml
	 * @return
	 */
	public static Map  getParamMap(String xml){

			try {
				return XMLUtil.doXMLParse(xml);
			} catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return null;
	}
	/**
	 * 验证签名-APP支付
	 * @param Params
	 * @return
	 */
	public static boolean getSignVeryfy(Map Params) {
		String sign=Params.get("sign").toString();
    	//过滤空值、sign与sign_type参数
    	Map<String, String> sParaNew = TenpayUtil.paraFilter(Params);
        //获取待签名字符串
        String preSignStr = TenpayUtil.createLinkString(sParaNew);
        //获得签名验证结果
        boolean isSign = false;
        String signNew=MD5Util.MD5Encode(preSignStr+"&key="+PARTNER_KEY,"utf-8").toUpperCase();
        if(sign.equals(signNew)){
        	return true;
        }
        return isSign;
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
	public static void main(String[] ddd) {

		
	}
}
