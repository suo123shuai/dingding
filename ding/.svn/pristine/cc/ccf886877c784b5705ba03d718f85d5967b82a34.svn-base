package com.common;

import java.math.BigDecimal;

public class DoubleOperation {
    /**
     * 对double数据进行取精度.
     *
     * @param value        double数据.
     * @param scale        精度位数(保留的小数位数).
     * @param roundingMode 精度取值方式.
     * @return 精度计算后的数据.
     */
    public static double round(double value, int scale,
                               int roundingMode) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(scale, roundingMode);
        double d = bd.doubleValue();
        bd = null;
        return d;
    }

    //两个Double数相减
    public static Double sub(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.subtract(b2).doubleValue();
    }

    /**
     * double 相加
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double sum(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.add(bd2).doubleValue();
    }

    /**
     * double 乘法
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double mul(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.multiply(bd2).doubleValue();
    }

    // 进行除法运算

    public static double div(double d1, double d2, int len) {// 进行除法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
