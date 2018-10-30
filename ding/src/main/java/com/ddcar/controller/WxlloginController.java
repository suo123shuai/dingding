package com.ddcar.controller;

import com.common.BaseBean;
import com.common.Commonparam;
import com.ddcar.entity.SendMessage;
import com.ddcar.entity.TbUser;
import com.ddcar.service.RiderIndexService;
import com.ddcar.service.SendMessageService;
import com.ddcar.service.WxLonginService;
import com.ddcar.util.NoteUtil;
import com.ddcar.util.RemUtil;
import com.ddcar.util.UtilLog;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WxlloginController {

    private final String appId = "wx1c5a237b06797e5a";
    private final String secret = "da1d26700ef95403170e2185ba0387e7";

    @Resource
    private WxLonginService wxLonginService;

    @Resource
    private SendMessageService sendMessageService;
    @Autowired
    private RiderIndexService riderIndex;

    @RequestMapping("/login")
    public @ResponseBody
    BaseBean wxLogin(String code) {
        BaseBean bean = new BaseBean();
        // 我们需要进行请求的地址：
        String temp = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" +
                secret + "&js_code=" + code + "&grant_type=authorization_code";
        try {
            // 1.URL类封装了大量复杂的实现细节，这里将一个字符串构造成一个URL对象
            URL url = new URL(temp);
            // 2.获取HttpURRLConnection对象
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 3.调用connect方法连接远程资源
            connection.connect();
            // 4.访问资源数据，使用getInputStream方法获取一个输入流用以读取信息
            BufferedReader bReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "UTF-8"));

            // 对数据进行访问
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            // 关闭流
            bReader.close();
            // 关闭链接
            connection.disconnect();
            // 打印获取的结果
            System.out.println(stringBuilder.toString());

            // 将获得的String对象转为JSON格式
            JSONObject jsonObject = JSONObject.fromObject(stringBuilder.toString());
            if (null == jsonObject.get("openid")) {
                bean.setStatus(400);
                bean.setMsg("登陆失败");
            } else {
                TbUser user = wxLonginService.WxLongin(jsonObject.get("openid").toString());
                bean.setStatus(200);
                bean.setRows(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("cuowu", e);
        }
        return bean;
    }

    /**
     * 发送验证码
     *
     * @param phone
     * @return com.common.BaseBean
     * @author ZhangXuanWei
     * @date 2018/9/7 17:39
     */
    @ResponseBody
    @RequestMapping("/api/user/sendCode")
    public BaseBean sendCode(@RequestParam(value = "phone") String phone) {
        BaseBean baseBean = new BaseBean();
        try {
            if (phone != null) {
                phone = phone.trim();
                if (phone.length() == 11) {
                    Integer phoneCodeNum = sendMessageService.getSmsSum(phone);
                    if (phoneCodeNum < 5) {
                        Long codeTime = sendMessageService.getCodeTime(phone);
                        boolean flag = false;
                        if (codeTime == null) {
                            flag = true;
                        } else {
                            if (codeTime > 60) {
                                flag = true;
                            }
                        }
                        if (flag) {
                            final int mobileCode = (int) ((Math.random() * 9 + 1) * 100000);
                            SendMessage sendMessage = new SendMessage();
                            sendMessage.setSendPhone(phone);
                            sendMessage.setSendCode(String.valueOf(mobileCode));
                            sendMessage.setType(1);
                            //参数
                            String code = NoteUtil.noteCode(phone, String.valueOf(mobileCode)).getCode();
                            if (code.equals("OK")) {
                                sendMessageService.saveSendMessage(sendMessage);
                                baseBean.setStatus(200);
                                baseBean.setMsg("发送成功");
                            } else {
                                baseBean.setMsg("发送失败");
                            }
                        } else {
                            baseBean.setMsg("请60秒后再发送！");
                        }
                    } else {
                        baseBean.setMsg("当日发送验证码次数已达上限");
                    }
                } else {
                    baseBean.setMsg("手机号不正确");
                }
            } else {
                baseBean.setMsg("手机号为空");
            }
        } catch (Exception ex) {
            baseBean.setMsg(Commonparam.handle(ex));
            Log.logger.error("操作失败", ex);
        }
        return baseBean;
    }


    /**
     * 发送提醒短信
     */
    @ResponseBody
    @RequestMapping("/api/user/rem")
    public BaseBean Rem(@RequestParam(value = "phone") String phone) {
        BaseBean baseBean = new BaseBean();
        try {
            if (phone != null) {
                phone = phone.trim();
                if (phone.length() == 11) {
                    String code = RemUtil.noteCode(phone).getCode();
                    System.out.print(code);
                    if (code.equals("OK")) {
                        baseBean.setStatus(200);
                        baseBean.setMsg("发送成功");
                    } else {
                        baseBean.setMsg("发送失败");
                    }

                } else {
                    baseBean.setMsg("手机号不正确");
                }
            } else {
                baseBean.setMsg("手机号为空");
            }
        } catch (Exception ex) {
            baseBean.setMsg(Commonparam.handle(ex));
            Log.logger.error("操作失败", ex);
        }
        return baseBean;
    }


    @RequestMapping("/verification")
    public @ResponseBody
    BaseBean verification(String phone, String sendCode,
                          @RequestParam(value = "userId", defaultValue = "0") Long userId, String type) {
        Map map = new HashMap();
        BaseBean bean = new BaseBean();
        map.put("phone", phone);
        map.put("sendCode", sendCode);
        try {
            Long codeTime = sendMessageService.getCodeExpiredTime(map);
            if("1".equals(type) && (codeTime > 0)){
                TbUser user = new TbUser();
                user.setUserId(userId);
                user.setPhone(phone);
                riderIndex.updateUser(user);
            }
            if (null == codeTime){
                bean.setStatus(400);
                bean.setMsg("验证码错误");
            } else if (codeTime > 0){
                bean.setStatus(200);
                bean.setMsg("验证通过");
            } else {
                bean.setStatus(400);
                bean.setMsg("验证过时");
            }
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }

}
