//package com.lvneng;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration
//public class Lvneng2ApplicationTests {
//
//
//	private static Integer j = 1000000;
//	public static String getOrderId(String orderNo) throws Exception{
//		String substring = orderNo.substring(0, 8);
//		String format1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
//		if (format1.equals(substring)){
//			String substring1 = orderNo.substring(12);
//			Integer integer = Integer.valueOf(substring1);
//			j = ++integer;
//		} else {
//			j = 1000000;
//		}
//
//		int i = (int) ((Math.random() * 9 + 1) * 1000);
//		StringBuffer ss = new StringBuffer(format1);
//		ss.append(i);
//		ss.append(j.toString());
//
//		return ss.toString();
//	}
//
//	public static void setJ(Integer i){
//		j = i;
//	}
//
//}
