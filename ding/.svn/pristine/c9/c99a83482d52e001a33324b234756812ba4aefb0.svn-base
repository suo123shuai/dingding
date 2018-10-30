package com.weixin;

import java.util.Map;

public class FukuanPay {

    public static String wxRefund(String keystoreFile,String keystorePass,String openId,
                                  String totalFee,
                                  String ip,String orderNo) {
        try {

            String xml=WeiXinUtilWap.getPreOrderParam1(openId,totalFee,ip,orderNo);
            String rt = ClientCustomSSL.doRefund(WeiXinUtilWap.tuiKuan, xml,keystoreFile,keystorePass).toString();
            if(rt.length()==0){
                return "请求失败";
            }else{
                Map entity = WeiXinUtilWap.getParamMap(rt);
                if (entity.get("return_code").toString().equals("SUCCESS")
                        && entity.get("result_code").toString().equals("SUCCESS")) {
                    return "success";
                }else{
                    if(entity.containsKey("err_code_des"))
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
