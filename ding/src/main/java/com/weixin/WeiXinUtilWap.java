package com.weixin;

import com.alibaba.fastjson.JSONObject;
import org.jdom.JDOMException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

/**
 * 微信公众号 小程序 登录，web支付
 */
public class WeiXinUtilWap {

    // 第一步：请求CODE，url
    private static final String getReqCodUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?";// 是
    // 微信登陆第二步 通过code获取access_token，url
    private static final String getReqTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?";
    // 微信登陆第三步 通过access_token获取用户信息，url
    private static final String getReqUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?";

    // 微信登陆第三步 通过access_token获取用户信息,关注日期，url
    private static final String getReqUser1349003701InfoSubscribeTimeUrl = "https://api.weixin.qq.com/cgi-bin/user/info?";
    public static final String getPreOrderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    public static final String tuiKuan = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
    public static final String appid = "wx1c5a237b06797e5a";// 公众号应用唯一标识
    private static final String app_secret = "da1d26700ef95403170e2185ba0387e7";//微信登录，jspAPI使用，暂时未更新是错误的

    public static final String mch_id = "1515127071";
    private static final String key = "dingdingi44KKUHGIK2414HGHRF9KH28";
    private static final String pay_notify_url = "https://www.dingding101.com/ddcar/weixin/notifyWeiXin";//jsapi,扫码支付回调，不带端口号
    private static final String userinfo_redirect_uri = "https://www.youlunhui.com/youlh/p/weixin/reqTokenWeb";// 重定向地址，需要进行UrlEncode
    public static final String wx_refund = "https://api.mch.weixin.qq.com/secapi/pay/refund";//退款接口
    private static final String response_type = "code";// 填code
    private static final String scope = "snsapi_login";// 网页应用目前仅填写snsapi_login即可
    private static final String grant_type = "authorization_code";// 填authorization_code

    public static void main(String[] ddd) {

    }

    public static String signatureSHA1(HashMap param) {
        // TODO Auto-generated method stub
        String signSoure = "jsapi_ticket=" + param.get("jsapi_ticket")
                + "&noncestr=" + param.get("noncestr") + "&timestamp="
                + param.get("timestamp") + "&url=" + param.get("url");
        System.out.println(signSoure);
        String sign = Sha1Util.getSha1(signSoure);
        System.out.println(sign);
        return sign;
    }

    public static String getJSAPIAccessToken() {
        return "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + appid + "&secret=" + app_secret;
    }

    public static String getPreOrderParam(String orderNum, String openId,
                                          String body, String totalFee, String ip, HashMap attach) throws Exception {
        String attachStr = JSONObject.toJSONString(attach);

        String nonce_str = getNonceStr();
        System.out.println("nonce_str=" + nonce_str);
        System.out.println("attachStr=" + attachStr);
        String signSoure = "appid=" + appid + "&attach=" + attachStr + "&body="
                + body + "&mch_id=" + mch_id + "&nonce_str=" + nonce_str
                + "&notify_url=" + pay_notify_url + "&openid=" + openId
                + "&out_trade_no=" + orderNum + "&spbill_create_ip=" + ip
                + "&total_fee=" + totalFee + "&trade_type=JSAPI";

        String stringSignTemp = signSoure + "&key=" + key;
        String sign = MD5Util.MD5Encode(stringSignTemp, "utf-8").toUpperCase();
        String param = "<xml>" + "<appid>" + appid + "</appid>" + "<attach>"
                + attachStr + "</attach>" + "<body>" + body + "</body>"
                + "<mch_id>" + mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
                + "</nonce_str>" + "<notify_url>" + pay_notify_url
                + "</notify_url>" + "<openid>" + openId + "</openid>"
                + "<out_trade_no>" + orderNum + "</out_trade_no>"
                + "<spbill_create_ip>" + ip + "</spbill_create_ip>"
                + "<total_fee>" + totalFee + "</total_fee>"
                + "<trade_type>JSAPI</trade_type>" + "<sign>" + sign
                + "</sign>" + "</xml>";
        return param;
    }

    public static String getPreOrderParam1(String openId,
                                           String totalFee,
                                           String ip,String orderNo) throws Exception {
//        String attachStr = JSONObject.toJSONString(attach);
        Integer total = (int) (Double.valueOf(totalFee) * 100);

        String nonce_str = getNonceStr();
        System.out.println("nonce_str=" + nonce_str);
//        System.out.println("attachStr=" + attachStr);
        String signSoure = "amount=" + total +
                "&check_name=" + "NO_CHECK" + "&desc=" + "退款" +
                "&mch_appid=" + appid + "&mchid="
                + mch_id + "&nonce_str=" + nonce_str
                + "&openid=" + openId
                +"&partner_trade_no="+orderNo
                + "&spbill_create_ip=" + ip;

        String stringSignTemp = signSoure + "&key=" + key;
        String sign = MD5Util.MD5Encode(stringSignTemp, "utf-8").toUpperCase();
        String param = "<xml>" + "<amount>" + total + "</amount>"
               + "<check_name>" + "NO_CHECK" + "</check_name>"
                + "<desc>" + "退款" + "</desc>"
                + "<mch_appid>" + appid + "</mch_appid>"
                + "<mchid>" + mch_id + "</mchid>"
                + "<nonce_str>" + nonce_str + "</nonce_str>"
                + "<openid>" + openId + "</openid>"
                +"<partner_trade_no>" +orderNo+"</partner_trade_no>"
                + "<spbill_create_ip>" + ip + "</spbill_create_ip>"
                + "<sign>" + sign + "</sign>"
                + "</xml>";
        return param;
    }


    public static String getPreOrderParamNative(String orderNum, String body,
                                                String totalFee, String ip, HashMap attach) throws Exception {
//		totalFee="1";
        String attachStr = JSONObject.toJSONString(attach);

        String nonce_str = getNonceStr();

        String signSoure = "appid=" + appid + "&attach=" + attachStr + "&body="
                + body + "&mch_id=" + mch_id + "&nonce_str=" + nonce_str
                + "&notify_url=" + pay_notify_url + "&out_trade_no=" + orderNum
                + "&spbill_create_ip=" + ip + "&total_fee=" + totalFee
                + "&trade_type=NATIVE";

        String stringSignTemp = signSoure + "&key=" + key;
        String sign = MD5Util.MD5Encode(stringSignTemp, "utf-8").toUpperCase();
        String param = "<xml>" + "<appid>" + appid + "</appid>" + "<attach>"
                + attachStr + "</attach>" + "<body>" + body + "</body>"
                + "<mch_id>" + mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
                + "</nonce_str>" + "<notify_url>" + pay_notify_url
                + "</notify_url>" + "<out_trade_no>" + orderNum
                + "</out_trade_no>" + "<spbill_create_ip>" + ip
                + "</spbill_create_ip>" + "<total_fee>" + totalFee
                + "</total_fee>" + "<trade_type>NATIVE</trade_type>" + "<sign>"
                + sign + "</sign>" + "</xml>";


        return param;
    }

    public static String getNonceStr() throws Exception {
        Random random = new Random();
        return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "utf-8");
    }

    /**
     * 第一步：请求CODE
     *
     * @param state
     * @return
     */
    public static String getReqCodUrl(String state) {

        StringBuffer sb = new StringBuffer(getReqCodUrl);
        try {
            sb.append("appid=").append(appid);
            sb.append("&");
            sb.append("redirect_uri=").append(
                    URLEncoder.encode(userinfo_redirect_uri, "utf-8"));
            sb.append("&");
            sb.append("response_type=").append(response_type);
            sb.append("&");
            sb.append("scope=").append(scope);
            sb.append("&");
            sb.append("state=").append(state);
            sb.append("#wechat_redirect");
        } catch (Exception e) {

        }

        return sb.toString();
    }

    /**
     * 微信登陆第二步：获取CODE 通过code获取access_token
     *
     * @param code
     * @return
     */
    public static String getReqTokenUrl(String code) {

        StringBuffer sb = new StringBuffer(getReqTokenUrl);

        sb.append("appid=").append(appid);
        sb.append("&");
        sb.append("secret=").append(app_secret);
        sb.append("&");
        sb.append("grant_type=").append(grant_type);
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

    /**
     * 获取参数
     *
     * @param xml
     * @return
     */
    public static Map getParamMap(String xml) {

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

    public static boolean getSignVeryfy(Map Params) {
        String sign = Params.get("sign").toString();
        //过滤空值、sign与sign_type参数
        Map<String, String> sParaNew = paraFilter(Params);
        //获取待签名字符串
        String preSignStr = createLinkString(sParaNew);
        //获得签名验证结果
        boolean isSign = false;
        String signNew = MD5Util.MD5Encode(preSignStr + "&key=" + key, "utf-8").toUpperCase();
        if (sign.equals(signNew)) {
            return true;
        }
        return isSign;
    }

    /**
     * 除去数组中的空值和签名参数sign
     *
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

    /**
     * @param orderNo
     * @param total_amount 金额，单位元
     * @return
     * @throws Exception
     */
    public static String getRefundXml(String orderNo, String total_amount, String orderNo1,
                                      String total_amount1) throws Exception {
        Integer total = (int) (Double.valueOf(total_amount) * 100);
        Integer total1 = (int) (Double.valueOf(total_amount1) * 100);
        String nonce_str = getNonceStr();
        String out_refund_no = (orderNo + 0);
        String signSoure = "appid=" + appid
                + "&mch_id=" + mch_id
                + "&nonce_str=" + nonce_str
                + "&out_refund_no=" + orderNo1
                + "&out_trade_no=" + orderNo
                + "&refund_fee=" + total
                + "&total_fee=" + total1;
        String stringSignTemp = signSoure + "&key=" + key;
        String sign = MD5Util.MD5Encode(stringSignTemp, "utf-8").toUpperCase();
        String xml = "<xml><appid>" + appid + "</appid>" +
                "<mch_id>" + mch_id + "</mch_id>" +
                "<nonce_str>" + nonce_str + "</nonce_str>" +
                "<out_refund_no>" + orderNo1 + "</out_refund_no>" +
                "<out_trade_no>" + orderNo + "</out_trade_no>" +
                "<refund_fee>" + total + "</refund_fee>" +
                "<total_fee>" + total1 + "</total_fee><transaction_id></transaction_id>" +
                "<sign>" + sign + "</sign></xml>";
        return xml;
    }

    /**
     * appId, nonceStr, package, signType,timestamp,
     *
     * @param orderPay
     * @return
     */
    public static String getOrderPaySign(HashMap orderPay) {
        // TODO Auto-generated method stub
        String signSoure = "appId=" + appid + "&nonceStr="
                + orderPay.get("nonceStr") + "&package="
                + orderPay.get("package") + "&signType="
                + orderPay.get("signType") + "&timeStamp="
                + orderPay.get("timestamp");

        String stringSignTemp = signSoure + "&key=" + key;

        String sign = "";
        try {
            sign = MD5Util.MD5Encode(stringSignTemp, "utf-8").toUpperCase();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sign;
    }

    public static String getOpenidUrl(String code) {
        return "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + app_secret
                + "&js_code=" + code + "&grant_type=authorization_code";
    }

    public static String getUrl(String remoteUrl) {
        URL url = null;
        HttpURLConnection httpurlconnection = null;
        StringBuffer sb = new StringBuffer();
        try {
            url = new URL(remoteUrl);

            httpurlconnection = (HttpURLConnection) url.openConnection();
            httpurlconnection.setDoOutput(true);
            httpurlconnection.setRequestMethod("GET");
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
}
