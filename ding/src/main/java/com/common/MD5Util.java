package com.common;

import java.security.MessageDigest;




public class MD5Util {
	/**
	 * 将字符串采用MD5算法加密
	 * 
	 * @param str
	 *            原字符串
	 * @return 加密后结
	 * @throws Exception
	 */
	public static String digest(String psd) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(psd.getBytes());
		byte b[] = md.digest();

		int i;

		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0)
				i += 256;
			if (i < 16)
				buf.append("0");
			buf.append(Integer.toHexString(i));
		}
		return buf.toString().toUpperCase();
	}

	public static void main(String[] args) throws Exception {
		 System.out.println(MD5Util.digest("123456"));
	}

}
