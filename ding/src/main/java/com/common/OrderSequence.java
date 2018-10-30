package com.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderSequence {

    private static Integer j = 1000000;

    public static String getOrderId(String orderNo, String state) throws Exception {
        String format1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
        StringBuffer ss = new StringBuffer(state);
        int i = (int) ((Math.random() * 9 + 1) * 1000);
        if (null == orderNo) {
            ss.append(format1);
            ss.append(i);
            ss.append(j.toString());
        } else {
            String substring = orderNo.substring(1, 9);
            if (format1.equals(substring)) {
                String substring1 = orderNo.substring(13);
                Integer integer = Integer.valueOf(substring1);
                j = ++integer;
            } else {
                j = 1000000;
            }
            ss.append(format1);
            ss.append(i);
            ss.append(j.toString());
        }
        return ss.toString();
    }

    public static void setJ(Integer i) {
        j = i;
    }
}
