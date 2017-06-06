package com.tiancaibao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取properties配置文件
 * 
 * @author Mack 2017年2月4日 下午3:26:54
 */
public class ReadProperties {
	/**
	 * 通过key 获取 value
	 * 
	 * @author Mack 2017年2月4日 下午3:27:19
	 * @param key
	 *            属性文件key
	 * @return
	 */
	public static String getValue(String key) {
		Properties prop = new Properties();
		InputStream inStream = null;
		try {
			inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("constants.properties");
			prop.load(inStream);
			return prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != inStream)
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(ReadProperties.getValue("user"));
	}
}
