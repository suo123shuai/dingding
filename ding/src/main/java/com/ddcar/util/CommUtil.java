package com.ddcar.util;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Time: 2018/9/25 18:26
 * Description:
 */
public class CommUtil {

    private static final String  STR_FORMAT = "00000";


    /**
     * 获取二维码编号
     * @param type 1.车辆  /  2.网点
     * @param maxId 当前数据库最大ID 数量
     * @return
     */
    public static String getCarCode(Integer type,Long maxId){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        Long num=0L;
        if (maxId!=null&&!maxId.toString().equals("")){
            num=maxId;
        }
        int i = Integer.parseInt(num.toString());
        i++;
        DecimalFormat dfm = new DecimalFormat(STR_FORMAT);
        String intnum="";
        if (type==1){
            intnum="C"+localTime+dfm.format(i)+getRandomString(4);
        }else if (type==2){
            intnum="D"+localTime+dfm.format(i)+getRandomString(4);
        } else if (type==3) {
            intnum="q"+localTime+dfm.format(i)+getRandomString(4);
        }
        return intnum;
    }

    //获取随机自定义长度的字符串
    public static String getRandomString(int length) {
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str = "1234567890";
        //由Random生成随机数
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        //长度为几就循环几次
        for (int i = 0; i < length; ++i) {
            //产生0-61的数字
            int number = random.nextInt(10);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getCarCode(2,0L));
    }

}
