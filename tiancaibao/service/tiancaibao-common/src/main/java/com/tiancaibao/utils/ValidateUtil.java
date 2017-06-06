package com.tiancaibao.utils;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;
import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pay.sina.PropertiesUtil;
import com.tiancaibao.pay.sina.SignUtil;

/**
 * 正则校验
 * 
 * @author Mack
 *
 */
public class ValidateUtil {

	private static JSONObject json = new JSONObject();

	/**
	 * 校验字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static Boolean isBlank(String str) {
		Boolean blank = StringUtils.isBlank(str);
		if (blank == false) {
			json.put("", "不能为空");
		}
		return blank;
	}

	/**
	 * 校验字符串是否为N位的数字
	 * 
	 * @param str
	 * @param num
	 * @return
	 */
	public static Boolean isNumDigit(String str, int num) {
		String pattern = "^\\d{" + num + "}$";
		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);
		// 现在创建 matcher 对象
		Matcher mt = r.matcher(str);
		boolean matches = mt.matches();
		return matches;
	}

	/**
	 * 校验字符串位数
	 * 
	 * @param str
	 * @param n
	 * @param m
	 * @return
	 */
	public static Boolean isBetween(String str, int n, int m) {

		String pattern = "^\\d{" + n + "," + m + "}$";
		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);
		// 现在创建 matcher 对象
		Matcher mt = r.matcher(str);
		boolean matches = mt.matches();
		return matches;
	}

	/**
	 * 校验字符串必须全部由字母和数字构成
	 * 
	 * @param str
	 * @return
	 */
	public static Boolean isAlphaNum(String str) {
		// 按指定模式在字符串查找
		String pattern = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);
		// 现在创建 matcher 对象
		Matcher m = r.matcher(str);
		boolean matches = m.matches();
		return matches;
	}

	/*
	 * 正则表达匹配
	 * 
	 * @param pattern 正则表达式
	 * 
	 * @param subject 需要匹配检索的对象
	 * 
	 * @return 存储匹配结果
	 */
	public static List<String> pregMatch(String pattern, String subject) {
		List<String> titles = new ArrayList<String>();
		Matcher matcher = Pattern.compile(pattern).matcher(subject);
		while (matcher.find()) {
			titles.add(matcher.group(1));
		}

		return titles;
	}

	public static boolean checkSignMsg(Map<String, String> data, String sign_type) {
		boolean returns = false;
		StringBuilder params_str = new StringBuilder();
		Set<String> keySet = data.keySet();
		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			if (!key.equals("sign") && !key.equals("sign_type") && !key.equals("sign_version") && data.get(key) != null
					&& !data.get(key).equals("")) {
				params_str.append("&" + key + "=" + data.get(key));
			}
		}
		params_str = params_str.deleteCharAt(0);
		String signKey = null;
		switch (sign_type) {
		case "RSA":
			signKey = PropertiesUtil.getValue("DEBUG_SINAPAY_RSA_SIGN_PUBLIC_KEY");
			break;
		case "MD5":
			signKey = "";
			break;
		default:
			break;
		}
		try {
			// 计算签名

			String sign_result = data.get("sign").toString();
			String sign_type_result = data.get("sign_type").toString();
			String _input_charset_result = data.get("_input_charset").toString();
			try {
				returns = SignUtil.Check_sign(params_str.toString(), sign_result, sign_type_result, signKey,
						_input_charset_result);
			} catch (ServiceException se) {
				throw new ServiceException(se.getMessage());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return returns;

	}

	public static Map<String, String> getMap(HttpServletRequest request) {
		Map<String, String> map = new TreeMap<String, String>(new Comparator<String>() {
			public int compare(String obj1, String obj2) {
				// 升序排序
				return obj1.compareTo(obj2);
			}
		});
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			map.put(paraName, request.getParameter(paraName));
		}
		return map;
	}

	public static ModelMap getParameters(HttpServletRequest request) {
		ModelMap modelmap = new ModelMap();
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			modelmap.put(paraName, request.getParameter(paraName));
		}
		return modelmap;
	}

}
