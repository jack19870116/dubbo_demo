package com.tiancaibao.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class MD5Util {
	static Logger log = Logger.getLogger(MD5Util.class);
	private static final String encryModel = "MD5";

	/**
	 * 32λmd5. 32位小写md5加密
	 * 
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		return encrypt(encryModel, str);
	}

	/**
	 * 32λmd5. 32位大写md5加密
	 * 
	 * @param str
	 * @return
	 */
	public static String MD5(String str) {
		return encrypt(encryModel, str).toUpperCase();
	}

	public static String encrypt(String algorithm, String str) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(str.getBytes());
			StringBuffer sb = new StringBuffer();
			byte[] bytes = md.digest();
			for (int i = 0; i < bytes.length; i++) {
				int b = bytes[i] & 0xFF;
				if (b < 0x10) {
					sb.append('0');
				}
				sb.append(Integer.toHexString(b));
			}

			return sb.toString();
		} catch (Exception e) {
			return "";
		}
	}

	public static String md5Sixteen(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] byteDigest = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < byteDigest.length; offset++) {
				i = byteDigest[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密小写
			return buf.toString().substring(8, 24).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			log.error("", e);
			return null;
		}
	}
}
