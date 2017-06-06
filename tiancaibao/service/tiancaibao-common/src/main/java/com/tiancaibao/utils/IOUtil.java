package com.tiancaibao.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class IOUtil {
	/**
	 * 读取pem文件中的内容去头尾换行
	 * 
	 * @param path
	 * @return
	 */
	public static String readContext(String path) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(path)));
			String s = br.readLine();
			String str = "";
			s = br.readLine();
			while (s.charAt(0) != '-') {
				str += s + "\r";
				s = br.readLine();
				
			}
			br.close();
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String inputStream2String(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i = -1;
		while ((i = is.read()) != -1) {
			baos.write(i);
		}
		return baos.toString();
	}
}
