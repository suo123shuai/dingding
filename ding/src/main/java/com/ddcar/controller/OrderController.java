package com.ddcar.controller;

import com.common.BaseBean;
import com.common.Commonparam;
import com.common.DoubleOperation;
import com.ddcar.entity.PatchOrder;
import com.ddcar.entity.TbOrder;
import com.ddcar.service.OrderPayService;
import com.weixin.WeiXinUtilWap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/weixin")
public class OrderController {
    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderPayService orderPayService;

    /**
     * 获取小程序支付参数
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/createWeixinPreorder")
    public @ResponseBody
    BaseBean createWeixinPreorder(
            @RequestParam("orderNo") String orderNo,
            @RequestParam("wxOpenId") String wxOpenId,
            HttpServletRequest request){
            BaseBean bean = new BaseBean();
        try {
            String substring = orderNo.substring(0, 1);
            Long payMoney = 0L;//单位分
            if("z".equals(substring)) {
                TbOrder order = orderPayService.getOrderByOrderId(orderNo);
                payMoney = (long)DoubleOperation.mul(order.getTotalMoney(), 100);
            } else {
                PatchOrder order = orderPayService.findPatchOrder(orderNo);
                payMoney = (long)DoubleOperation.mul(order.getMoney(), 100);
            }
            String body="丁丁租车";
            HashMap atach = new HashMap();
            atach.put("orderNo", orderNo);
            String param = WeiXinUtilWap.getPreOrderParam(orderNo, wxOpenId, body,
                    payMoney + "", "115.159.51.111", atach);
            String rt = WeiXinUtilWap.postUrl(WeiXinUtilWap.getPreOrderUrl, param);
            Pattern pattern = Pattern.compile("<prepay_id>(.*)</prepay_id>");
            Matcher matcher = pattern.matcher(rt);
            String prepay_id = "";
            while (matcher.find()) {
                prepay_id = matcher.group(1);
            }
            if (prepay_id.length() == 0) {
                pattern = Pattern.compile("<return_msg>(.*)</return_msg>");
                matcher = pattern.matcher(rt);
                while (matcher.find()) {
                    prepay_id = matcher.group(1);
                }
                bean.setStatus(400);
                bean.setMsg(prepay_id);
            } else {
                prepay_id = prepay_id.substring(prepay_id.indexOf("<![CDATA[") + 9);
                prepay_id = prepay_id.substring(0, prepay_id.indexOf("]]>"));

                bean.setStatus(200);
                HashMap orderPay = new HashMap();
                orderPay.put("timestamp", (new Date()).getTime()); // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
                orderPay.put("nonceStr", WeiXinUtilWap.getNonceStr());
                orderPay.put("package", "prepay_id=" + prepay_id);
                orderPay.put("signType", "MD5");
                orderPay.put("paySign", WeiXinUtilWap.getOrderPaySign(orderPay));
                bean.setRows(orderPay);
            }
        } catch (Exception e) {
            logger.error(Commonparam.handle(e));
            bean.setMsg("操作错误");
            bean.setStatus(400);
        }
		return bean;
    }

    @RequestMapping(value = "/notifyWeiXin")
    public void notifyWeiXin(HttpServletRequest request,
                                         HttpServletResponse response) throws Exception {

        try {

            /**
             * <xml><appid><![CDATA[wxecf6f4bb763dab3c]]></appid>
             * <attach><![CDATA
             * [{"orderNum":"2015070707232600000108"}]]></attach>
             * <bank_type><![CDATA[ICBC_DEBIT]]></bank_type>
             * <cash_fee><![CDATA[100]]></cash_fee>
             * <fee_type><![CDATA[CNY]]></fee_type>
             * <is_subscribe><![CDATA[N]]></is_subscribe>
             * <mch_id><![CDATA[1251896001]]></mch_id>
             * <nonce_str><![CDATA[65173795697
             * C8229DD202AD94E821BAB]]></nonce_str>
             * <openid><![CDATA[oZA3Bvr9wDmTDNu0k2YESs3NCFG8]]></openid>
             * <out_trade_no><![CDATA[2015070707232600000108]]></out_trade_no>
             * <result_code><![CDATA[SUCCESS]]></result_code>
             * <return_code><![CDATA[SUCCESS]]></return_code>
             * <sign><![CDATA[C842A1F89DB7C62E628492DCD52EB1BD]]></sign>
             * <time_end><![CDATA[20150707161604]]></time_end>
             * <total_fee>100</total_fee>
             * <trade_type><![CDATA[APP]]></trade_type>
             * <transaction_id><![CDATA[
             * 1007770114201507070363731397]]></transaction_id> </xml>
             */

            InputStream in = request.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] b = new byte[1024];
            int i = 0;
            while ((i = in.read(b)) != -1) {
                sb.append(new String(b, 0, i, "UTF-8"));
            }
            logger.error("notifyWeiXin =" + sb.toString());
            Map  entity = WeiXinUtilWap.getParamMap(sb.toString());
            if(WeiXinUtilWap.getSignVeryfy(entity)){
                if (entity.get("return_code").toString().equals("SUCCESS")
                        && entity.get("result_code").toString().equals("SUCCESS")) {

                        // 更新付款状态，付款方式，保存微信交易订单号
                    //支付成功后更新
                    orderPayService.paySuccess(entity);
                    response.getOutputStream().write(
                                "SUCCESS".getBytes("UTF-8"));
                    logger.error("return_code Success notifyWeiXin");

                } else {
                    logger.error("return_code failed notifyWeiXin");
                    response.getOutputStream().write("FAIL".getBytes("UTF-8"));
                }
            }else{
                logger.error("Veryfy failed notifyWeiXin");
                response.getOutputStream().write("FAIL".getBytes("UTF-8"));
            }


        } catch (Exception e) {
            logger.error("notifyWeiXin faield Exception="+e.getLocalizedMessage());

        }

    }
    @RequestMapping("/findOpenId")
    public @ResponseBody
    BaseBean findOpenId(@RequestParam("code") String code){
        BaseBean bean = new BaseBean();
        try {
            String rt = WeiXinUtilWap.getUrl(WeiXinUtilWap.getOpenidUrl(code));
            logger.error(rt);

        } catch (Exception e) {
            logger.error(Commonparam.handle(e));
            bean.setMsg("操作错误");
            bean.setStatus(400);
        }
        return bean;
    }
}
