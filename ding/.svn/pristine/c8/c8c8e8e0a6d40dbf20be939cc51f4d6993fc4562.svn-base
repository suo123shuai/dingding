package com.weixin;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.common.Commonparam;

import java.util.Map;

public class PayRefund {

//	public static String alipayRefund(String orderNo, String total_amount) {
//		try {
//			// 获得初始化的AlipayClient
//			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
//					AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
//					AlipayConfig.sign_type);
//
//			// 设置请求参数
//			AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
//
//			// 请求
//			AlipayTradeRefundModel model = new AlipayTradeRefundModel();
//			model.setOutTradeNo(orderNo);
//			model.setRefundAmount(total_amount);
//			alipayRequest.setBizModel(model);
//
//			AlipayTradeRefundResponse respon = alipayClient.execute(alipayRequest);
//
//			if (respon.isSuccess()) {
//				return "success";
//			} else {
//				return respon.getMsg() + respon.getSubMsg();
//			}
//		} catch (AlipayApiException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "failed";
//	}

    public static String wxRefund(String keystoreFile,
                                  String keystorePass, String orderNo, String total_amount,
                                  String orderNo1, String total_amount1) {
        try {


            String xml = WeiXinUtilWap.getRefundXml(orderNo, total_amount,orderNo1,total_amount1);
            String rt = ClientCustomSSL.doRefund(WeiXinUtilWap.wx_refund, xml, keystoreFile, keystorePass).toString();
            if (rt.length() == 0) {
                return "请求失败";
            } else {
                Map entity = WeiXinUtilWap.getParamMap(rt);
                if (entity.get("return_code").toString().equals("SUCCESS")
                        && entity.get("result_code").toString().equals("SUCCESS")) {
                    return "success";
                } else {
                    if (entity.containsKey("err_code_des"))
                        return entity.get("err_code_des").toString();
                    else
                        return entity.get("return_msg").toString();
                }
            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return e.getLocalizedMessage();
        }
    }

}
