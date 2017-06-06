package com.tiancaibao.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
	public static String receivePostJson(HttpServletRequest request)
			throws IOException, UnsupportedEncodingException, ClassNotFoundException {
		// 读取请求内容
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		String reqBody = sb.toString();
		return URLDecoder.decode(reqBody,"UTF-8");
	}
}
