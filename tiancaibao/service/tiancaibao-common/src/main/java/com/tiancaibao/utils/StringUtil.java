package com.tiancaibao.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if (null == str || "".equals(StringUtils.trimWhitespace(str))) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean empty(Object str) {
		if (null == str || (str!=null && "".equals(str))) {
			return true;
		} else {
			return false;
		}
	}

	public static List<Integer> getUserCanzUseScoreByPattern(int hasScore, boolean flag, double investAmount,
			int existTime) {
		List<Integer> list = new ArrayList<Integer>();
		// 如果是按月付息
		if (flag) {
			int canActive = 0;
			int realActive = 0;
			if (StringUtil.compareTwoDigit(investAmount, 1000) == 1
					|| StringUtil.compareTwoDigit(investAmount, 1000) == 0) {
				if (existTime <= 30) {
					canActive = Double.valueOf(MoneyUtil.mul(investAmount, 0.001)).intValue();
					realActive = hasScore < canActive ? hasScore : canActive;
				} else if (existTime <= 60 && existTime > 30) {
					canActive = Double.valueOf(MoneyUtil.mul(investAmount, 0.002)).intValue();
					realActive = hasScore < canActive ? hasScore : canActive;
				} else if (existTime <= 90 && existTime > 60) {
					canActive = Double.valueOf(MoneyUtil.mul(investAmount, 0.003)).intValue();
					realActive = hasScore < canActive ? hasScore : canActive;
				} else if (existTime <= 180 && existTime > 90) {
					canActive = Double.valueOf(MoneyUtil.mul(investAmount, 0.007)).intValue();
					realActive = hasScore < canActive ? hasScore : canActive;
				} else if (existTime <= 360 && existTime > 180) {
					canActive = Double.valueOf(MoneyUtil.mul(investAmount, 0.015)).intValue();
					realActive = hasScore < canActive ? hasScore : canActive;
				}
			}
			list.add(realActive);
		} else {
			// 如果是等额本息
			int canActive = 0;
			int realActive = 0;
			if (StringUtil.compareTwoDigit(investAmount, 1000) == 1
					|| StringUtil.compareTwoDigit(investAmount, 1000) == 0) {
				int days = existTime * 30;
				if (days <= 30) {
					canActive = Double.valueOf(MoneyUtil.mul(investAmount, 0.001)).intValue();
					realActive = hasScore < canActive ? hasScore : canActive;
				} else if (days <= 60 && days > 30) {
					canActive = Double.valueOf(MoneyUtil.mul(investAmount, 0.002)).intValue();
					realActive = hasScore < canActive ? hasScore : canActive;
				} else if (days <= 90 && days > 60) {
					canActive = Double.valueOf(MoneyUtil.mul(investAmount, 0.003)).intValue();
					realActive = hasScore < canActive ? hasScore : canActive;
				} else if (days <= 180 && days > 90) {
					canActive = Double.valueOf(MoneyUtil.mul(investAmount, 0.007)).intValue();
					realActive = hasScore < canActive ? hasScore : canActive;
				} else if (days <= 360 && days > 180) {
					canActive = Double.valueOf(MoneyUtil.mul(investAmount, 0.015)).intValue();
					realActive = hasScore < canActive ? hasScore : canActive;
				}
			}
			list.add(realActive);
		}
		return list;
	}

	/**
	 * 验证是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * 返回数字
	 * 
	 * @param str
	 * @return
	 */
	public static Integer strNumber(String str) {
		try {

			return Integer.parseInt(str);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 判断数组中是否有该int
	 * 
	 * @param str
	 * @return
	 */
	public static boolean inArray(int type, int[] types) {
		try {
			for (int integer : types) {
				if (type == integer) {
					return true;
				}
			}

		} catch (Exception ex) {
			return false;
		}
		return false;
	}

	/**
	 *
	 * @Title: compareTwoDigit @Description: TODO(比较两个数的大小) @param value1 @param
	 *         value2 @param @return int 返回类型-1 小于 0 等于 1 大于 （前后关系) @throws
	 */
	public static int compareTwoDigit(double value1, double value2) {
		BigDecimal bd1 = new BigDecimal(value1);
		BigDecimal bd2 = new BigDecimal(value2);
		return bd1.compareTo(bd2);
	}

	/**
	 * 是否是正整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPositiveInteger(String str) {
		if (isEmpty(str)) {
			return false;
		} else if (!str.matches("^[1-9]\\d*$")) {
			return false;
		} else {
			return true;
		}
	}

	public static String generateUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String getSuffixByFileName(String fileName) {
		if (isEmpty(fileName)) {
			return "";
		}
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		return suffix;
	}

	// 生成订单流水号的方法
	public static String getOrderUUID() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String dateStamp = format.format(new Date());
		StringBuffer buffer = new StringBuffer();
		// UUID加密+八位时间戳，保证不重复性
		buffer.append(MD5Util.md5Sixteen(UUID.randomUUID().toString())).append(dateStamp);
		return buffer.toString();
	}

	/**
	 * 转换带有根路径的url,方便登录成功后跳转
	 * 
	 * @param urlWithRoot
	 *            /invest/lztou/user/goAccountOverview这种格式的url
	 * @return
	 */
	public static String changeUrl(String urlWithRoot) {
		String tempUrl = urlWithRoot.substring(urlWithRoot.indexOf(Constants.REST_PATH));
		return tempUrl;
	}

	/**
	 * 验证身份证号码
	 * 
	 * @param idCard
	 *            居民身份证号码15位或18位，最后一位可能是数字或字母
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean isIdCard(String idCard) {
		String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
		return Pattern.matches(regex, idCard);
	}

	/**
	 * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
	 * 
	 * @param mobile
	 *            移动、联通、电信运营商的号码段
	 *            <p>
	 *            移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
	 *            、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）
	 *            </p>
	 *            <p>
	 *            联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）
	 *            </p>
	 *            <p>
	 *            电信的号段：133、153、180（未启用）、189
	 *            </p>
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean isMobile(String mobile) {
		String regex = "^((13[0-9]{1})|(15[^4]{1})|(18[0,2,3,5-9]{1})|(14[5,7]{1})|(17[0,8,7,6]{1}))\\d{8}$";
		return Pattern.matches(regex, mobile);
	}

	/**
	 * 验证固定电话号码
	 * 
	 * @param phone
	 *            电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
	 *            <p>
	 *            <b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9
	 *            的一位或多位数字， 数字之后是空格分隔的国家（地区）代码。
	 *            </p>
	 *            <p>
	 *            <b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
	 *            对不使用地区或城市代码的国家（地区），则省略该组件。
	 *            </p>
	 *            <p>
	 *            <b>电话号码：</b>这包含从 0 到 9 的一个或多个数字
	 *            </p>
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean isPhone(String phone) {
		String regex = "^(\\d){1,4}([-]{1}(\\d){1,8}){1}$";
		return Pattern.matches(regex, phone);
	}

	public static boolean isPositiveFloat(String str) {
		String regex = "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$";
		return Pattern.matches(regex, str);
	}

	public static boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	public static String getMoneyDisplay(BigDecimal amount) {
		if (amount == null) {
			return "0.00";
		} else {
			DecimalFormat df = new DecimalFormat("##.00");
			return df.format(amount.setScale(2, BigDecimal.ROUND_DOWN));
		}
	}

	// 是否是正整的double 4.00
	public static boolean isIntegerDouble(String str) {
		if (isDouble(str) && Double.valueOf(str).doubleValue() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * public static void main(String[] args) {
	 * changeUrl("/invest/lztou/user/goAccountOverview");
	 * System.out.println(formatDoubleToMoneyDisplay(0.1));
	 * System.out.println(formatDoubleToMoneyDisplay(0.1345));
	 * System.out.println(formatDoubleToMoneyDisplay(2.113));
	 * System.out.println(formatDoubleToMoneyDisplay(64444.E7));
	 * System.out.println(MoneyUtil.div(4.2, 1.24));
	 * System.out.println(formatDoubleToMoneyDisplay(MoneyUtil.div(4.2, 1.24)));
	 * try { System.out.println(daysBetween("2014-7-2", "2014-9-2")); } catch
	 * (ParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
	public static String formatStringToNeedMoneyDisplay(String str) {
		BigDecimal bg = new BigDecimal(str);
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(bg.setScale(2, BigDecimal.ROUND_HALF_UP));
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 字符串的日期格式的计算
	 */
	public static int daysBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	public static String formatDoubleToMoneyDisplay(double doubleValue) {
		Double value = new Double(doubleValue);
		String disValue = formatStringToNeedMoneyDisplay(value.toString());
		return disValue;
	}

	/*
	 * 判断 字符串是否全部是汉字 param 要判断的字符串
	 */
	public static boolean isCN(String str) {
		if (str.getBytes().length == str.length() * 2) {
			return true;
		}
		return false;
	}

	// 对电话号码进行正则匹配
	public static boolean checkPhone(String candidate) {
		String regex = "^0\\d{2,3}-\\d{4,8}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(candidate);
		String val = null;
		while (m.find()) {
			val = m.group();
		}
		if (val == null) {
			return false;
		}
		return true;
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("http_client_ip");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		// 如果是多级代理，那么取第一个ip为客户ip
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
		}
		return ip;
	}

	/**
	 * 处理字符串将中间的字符变成*
	 * 
	 * @param leaveLength
	 * @param oldStr
	 * @return
	 */
	public static String getDealString(int leaveLength, String oldStr) {
		if (StringUtil.isEmpty(oldStr) || oldStr.length() <= leaveLength) {
			return "";
		}
		int end = oldStr.length() - leaveLength;
		StringBuffer buffer = new StringBuffer();
		buffer.append(oldStr.substring(0, leaveLength));
		for (int i = 0; i < oldStr.substring(leaveLength, end).length(); i++) {
			buffer.append("*");
		}
		buffer.append(oldStr.substring(end, oldStr.length()));
		return buffer.toString();
	}

	public static void dealUserMap(Map<String, Object> userMap) {
		String realname = (String) userMap.get("realname");
		StringBuffer buffer = new StringBuffer();
		if (!StringUtil.isEmpty(realname)) {
			buffer.append(realname.substring(0, 1));
			for (int i = 1; i < realname.length(); i++) {
				buffer.append("*");
			}
			userMap.put("realname", buffer.toString());
		} else {
			userMap.put("realname", "");
		}
		String idNum = (String) userMap.get("id_num");
		if (!StringUtil.isEmpty(idNum)) {
			userMap.put("id_num", getDealString(3, idNum));
		} else {
			userMap.put("id_num", "");
		}
		String username = (String) userMap.get("username");
		if (!StringUtil.isEmpty(username)) {
			userMap.put("username", getDealString(1, username));
		} else {
			userMap.put("username", "");
		}

	}

	public static List<Map<String, Object>> dealCriticList(List<Map<String, Object>> criticList) {
		List<Map<String, Object>> bigList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> rootList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : criticList) {
			Integer pid = (Integer) map.get("parent_id");
			if (null == pid) {
				rootList.add(map);
			}
		}
		for (Map<String, Object> rootMap : rootList) {
			List<Map<String, Object>> sonList = new ArrayList<Map<String, Object>>();
			for (Map<String, Object> map : criticList) {
				Integer rootId = (Integer) rootMap.get("critic_id");
				Integer parentId = (Integer) map.get("parent_id");
				// 用户名加*处理
				map.put("user_name", (String) map.get("user_name"));
				if (null != parentId && (parentId - rootId) == 0) {
					sonList.add(map);
				}
			}
			Map<String, Object> bigMap = new HashMap<String, Object>();
			bigMap.put("content", (String) rootMap.get("critic_content"));
			bigMap.put("time", (Date) rootMap.get("critic_time"));
			bigMap.put("sonList", sonList);
			// 用户名加*处理
			StringBuffer buffer = new StringBuffer();
			String criticUser = (String) rootMap.get("user_name");
			buffer.append(criticUser.charAt(0)).append("****").append(criticUser.charAt(criticUser.length() - 1));
			bigMap.put("username", buffer.toString());
			bigList.add(bigMap);
		}
		return bigList;
	}

	/**
	 * 得到两日期相差几个月
	 * 
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return
	 */
	public static int getMonth(Date startDate, Date endDate) {
		int monthday;
		// 开始时间与今天相比较
		Calendar starCal = Calendar.getInstance();
		starCal.setTime(startDate);

		int sYear = starCal.get(Calendar.YEAR);
		int sMonth = starCal.get(Calendar.MONTH);
		int sDay = starCal.get(Calendar.DATE);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);
		int eYear = endCal.get(Calendar.YEAR);
		int eMonth = endCal.get(Calendar.MONTH);
		int eDay = endCal.get(Calendar.DATE);

		monthday = ((eYear - sYear) * 12 + (eMonth - sMonth));

		if (sDay < eDay) {
			monthday = monthday + 1;
		}
		return monthday;
	}

	public static Date getEndDateByDays(Date start, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(start);
		c.add(Calendar.DAY_OF_MONTH, days);
		Date e = c.getTime();
		return e;
	}

	public static List<Map<String, Object>> dealUserDisplayList(List<Map<String, Object>> heroList) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if (null != heroList && heroList.size() > 0) {
			for (Map<String, Object> map : heroList) {
				String investUser = (String) map.get("invest_user");
				StringBuffer buffer = new StringBuffer();
				buffer.append(investUser.charAt(0)).append("****").append(investUser.charAt(investUser.length() - 1));
				map.put("invest_user", buffer.toString());
				list.add(map);
			}
		}
		return list;
	}

	/**
	 * @Description:TODO 处理用户名字 加*
	 * @param heroList
	 * @param username
	 * @return List<Map<String,Object>>
	 * @author: Doom.
	 * @time:2014-10-21 下午1:55:36
	 */
	public static List<Map<String, Object>> dealUserDisplayList(List<Map<String, Object>> heroList, String username) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if (null != heroList && heroList.size() > 0) {
			for (Map<String, Object> map : heroList) {
				String investUser = (String) map.get(username);
				StringBuffer buffer = new StringBuffer();
				buffer.append(investUser.charAt(0)).append("****").append(investUser.charAt(investUser.length() - 1));
				map.put(username, buffer.toString());
				list.add(map);
			}
		}
		return list;
	}

	// 简单 判断是否是邮箱
	public static boolean isEmail(String email) {
		return Pattern.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$", email);
	}

	public static String getPayString(List<Map<String, Object>> payList) {
		StringBuffer buffer = new StringBuffer();
		for (Map<String, Object> map : payList) {
			buffer.append("<tr>").append("<td>").append((String) map.get("date")).append("</td>").append("<td>")
					.append((int) map.get("day")).append("</td>").append("<td>").append((String) map.get("investment"))
					.append("</td>").append("<td>").append((String) map.get("money")).append("</td>").append("</tr>");
		}
		return buffer.toString();
	}

	public static String getPlanString(List<Map<String, Object>> payList) {
		StringBuffer buffer = new StringBuffer();
		for (Map<String, Object> map : payList) {
			buffer.append("<tr>").append("<td style='border: 1px solid;height: 20px;'>")
					.append((String) map.get("date")).append("</td>")
					.append("<td style='border: 1px solid;height: 20px;'>").append((int) map.get("day")).append("</td>")
					.append("<td style='border: 1px solid;height: 20px;'>").append((String) map.get("investment"))
					.append("</td>").append("<td style='border: 1px solid;height: 20px;'>")
					.append((String) map.get("money")).append("</td>").append("</tr>");
		}
		return buffer.toString();
	}

	public static String getEmailPlanString(List<Map<String, Object>> payList) {
		StringBuffer buffer = new StringBuffer();
		for (Map<String, Object> map : payList) {
			buffer.append("<tr>").append("<td style='border: 1px solid;height: 20px;'>")
					.append((String) map.get("payTime")).append("</td>")
					.append("<td style='border: 1px solid;height: 20px;'>").append((int) map.get("payDays"))
					.append("</td>").append("<td style='border: 1px solid;height: 20px;'>")
					.append((String) map.get("capital")).append("</td>")
					.append("<td style='border: 1px solid;height: 20px;'>").append((String) map.get("interest"))
					.append("</td>").append("</tr>");
		}
		return buffer.toString();
	}

	public static String getNewUserProjectPayString(Map<String, Object> map) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<tr>").append("<td style='border: 1px solid;height: 20px;'>").append((String) map.get("date"))
				.append("</td>").append("<td style='border: 1px solid;height: 20px;'>").append((int) map.get("day"))
				.append("</td>").append("<td style='border: 1px solid;height: 20px;'>")
				.append((String) map.get("investment")).append("</td>")
				.append("<td style='border: 1px solid;height: 20px;'>").append((String) map.get("money"))
				.append("</td>").append("</tr>");
		return buffer.toString();
	}

	// 还款计划
	public static String getPlaneStringForEmail(List<Map<String, Object>> payList) {
		StringBuffer buffer = new StringBuffer();
		int index = 1;
		for (Map<String, Object> map : payList) {
			buffer.append("<tr>").append("<td style='border: 1px solid;'>").append(index).append("</td>")
					.append("<td style='border: 1px solid;'>").append((String) map.get("payTime")).append("</td>")
					.append("<td style='border: 1px solid;'>").append((String) map.get("payAmount")).append("</td>")
					.append("<td style='border: 1px solid;'>").append((String) map.get("capital")).append("</td>")
					.append("<td style='border: 1px solid;'>").append((String) map.get("interest")).append("</td>")
					.append("<td style='border: 1px solid;'>").append((String) map.get("leftAmount")).append("</td>")
					.append("</tr>");
			index++;
		}
		return buffer.toString();
	}

	// 等额本息计划
	public static String getProjectEqualPayForEmail(List<Map<String, Object>> payList) {
		StringBuffer buffer = new StringBuffer();
		int index = 1;
		for (Map<String, Object> map : payList) {
			buffer.append("<tr>").append("<td style='border: 1px solid;'>").append(index).append("</td>")
					.append("<td style='border: 1px solid;'>").append((String) map.get("payDate")).append("</td>")
					.append("<td style='border: 1px solid;'>").append((String) map.get("everyMonthPay")).append("</td>")
					.append("<td style='border: 1px solid;'>").append((String) map.get("payCapital")).append("</td>")
					.append("<td style='border: 1px solid;'>").append((String) map.get("payInterest")).append("</td>")
					.append("<td style='border: 1px solid;'>").append((String) map.get("leftCapitalAndInterest"))
					.append("</td>").append("</tr>");
			index++;
		}
		return buffer.toString();
	}

	/**
	 * @Description:TODO logger时间戳
	 * @return String
	 * @author: I'm Doom.
	 * @time:2014-10-17 下午4:02:53
	 */
	public static String getLoggerTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}

	public static double getPayInterestByBetweenDays(Double amount, int days) {
		double everyPay = MoneyUtil.div(amount, Constants.ONE_YEAR_DAYS);
		return MoneyUtil.mul(everyPay, days);
	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * @param sdate
	 * @return
	 * @throws ParseException
	 */
	public static String getWeek(String sdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// 再转换为时间
		Date date = sdf.parse(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	public static String getWeekStr(String sdate) throws ParseException {
		String str = "";
		str = getWeek(sdate);
		if ("1".equals(str)) {
			str = "星期日";
		} else if ("2".equals(str)) {
			str = "星期一";
		} else if ("3".equals(str)) {
			str = "星期二";
		} else if ("4".equals(str)) {
			str = "星期三";
		} else if ("5".equals(str)) {
			str = "星期四";
		} else if ("6".equals(str)) {
			str = "星期五";
		} else if ("7".equals(str)) {
			str = "星期六";
		}
		return str;
	}

	/**
	 * @Description:TODO 求 一周剩余天数 包含当天
	 * @param param
	 * @return
	 * @throws ParseException
	 *             int
	 * @author: I'm Doom.
	 * @time:2014-11-14 下午6:33:04
	 */
	public static int getDayOfWeek(String param) throws ParseException {
		int days = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.setTime(sdf.parse(param));
		// ca.add(Calendar.DATE,1);
		System.out.println(sdf.format(ca.getTime()));
		int a = ca.get(Calendar.DAY_OF_WEEK);
		switch (a) {
		case 1:
			days = 1;
			break;

		case 2:
			days = 7;
			break;

		case 3:
			days = 6;
			break;

		case 4:
			days = 5;
			break;

		case 5:
			days = 4;
			break;

		case 6:
			days = 3;
			break;

		case 7:
			days = 2;
			break;

		}
		return days;
	}

	/**
	 * 根据最高可使用投资金和已经使用的投资金获取和一个项目最高可使用的投资金获取可激活投资金的list
	 * 
	 * @param mostUseScore
	 *            在投资额度下可以使用的最多的投资金
	 * @param hasUse
	 *            在一个项目下已经使用的投资金
	 * @param hasScore
	 *            用户拥有的投资金
	 * @return
	 */
	public static List<Integer> getCanUseScoreByHasUseAndMostUse(int mostUseScore, int hasUse, int hasScore) {
		List<Integer> intList = new ArrayList<Integer>();
		// 一个项目上最高可以使用多少
		int mostCanUseInProject = 100;
		// 还可以使用多少
		int leftUse = mostCanUseInProject - hasUse;
		if (mostUseScore >= leftUse) {
			if (hasScore >= leftUse) {
				int count = leftUse / 10;
				for (int i = count; i >= 0; i--) {
					intList.add(i * 10);
				}
				return intList;
			} else {
				int count = hasScore / 10;
				for (int i = count; i >= 0; i--) {
					intList.add(i * 10);
				}
				return intList;
			}

		} else {
			if (hasScore >= mostUseScore) {
				int count = mostUseScore / 10;
				for (int i = count; i >= 0; i--) {
					intList.add(i * 10);
				}
				return intList;
			} else {
				int count = hasScore / 10;
				for (int i = count; i >= 0; i--) {
					intList.add(i * 10);
				}
				return intList;
			}

		}
	}

	/**
	 * @Description:TODO 筛选符合签约的担保公司
	 * @param guaList
	 *            签约时 担保公司列表
	 * @param guaId
	 *            当前项目担保公司Id
	 * @return boolean
	 * @author: Doom.
	 * @time:2014-11-24 下午1:28:24
	 */
	public static boolean checkSignAndProductGuaId(String guaList, String guaId) {
		String[] guaIds = guaList.split(",");
		for (int i = 0; i < guaIds.length; i++) {
			if (Integer.parseInt(guaId) == Integer.parseInt(guaIds[i])) {
				return true;
			}
		}
		return false;
	}

	public static Map<String, Object> getMondayAndSundayDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 获取本周一的日期
		String mondayDate = df.format(cal.getTime());
		// 这种输出的是上个星期周日的日期，因为老外那边把周日当成第一天
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		// 增加一个星期，才是我们中国人理解的本周日的日期
		cal.add(Calendar.WEEK_OF_YEAR, 1);
		String sundayDate = df.format(df.format(cal.getTime()));
		Map<String, Object> map = new HashMap<>();
		map.put("mondayDate", mondayDate);
		map.put("sundayDate", sundayDate);
		return map;
	}

	public static int compareTimeString(Map<String, String> o1, Map<String, String> o2) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1 = format.parse(o1.get("payTime"));
			Date d2 = format.parse(o2.get("payTime"));
			if (d1.getTime() > d2.getTime()) {
				return 1;
			}
			if (d1.getTime() == d2.getTime()) {
				return 0;
			} else {
				return -1;
			}
		} catch (ParseException e) {
			return 0;
		}

	}

	public static void main(String[] args) throws ParseException {
		for (int i = 0; i < 1000; i++) {
			System.out.println(getRandomUsername());
		}
	}

	/**
	 * 根据最高可使用投资金和已经使用的投资金获取和一个项目最高可使用的投资金获取可激活投资金的list
	 * 
	 * @param mostUseScore
	 *            在投资额度下可以使用的最多的投资金
	 * @param hasUse
	 *            在一个项目下已经使用的投资金
	 * @param hasScore
	 *            用户拥有的投资金
	 * @return
	 */
	public static List<Integer> getCanUseScoreByHasUseAndMostUse(int mostUseScore, int hasUse, int hasScore,
			boolean flag) {
		List<Integer> intList = new ArrayList<Integer>();
		// 一个项目上最高可以使用多少
		int mostCanUseInProject = 100;
		// 还可以使用多少
		int leftUse = mostCanUseInProject - hasUse;
		int temp = 0;
		if (flag) {
			temp = 10;
		} else {
			temp = 2;
			mostUseScore = mostUseScore / 5;
		}
		if (mostUseScore >= leftUse) {
			if (hasScore >= leftUse) {
				int count = leftUse / temp;
				for (int i = count; i >= 0; i--) {
					intList.add(i * temp);
				}
				return intList;
			} else {
				int count = hasScore / temp;
				for (int i = count; i >= 0; i--) {
					intList.add(i * temp);
				}
				return intList;
			}

		} else {
			if (hasScore >= mostUseScore) {
				int count = mostUseScore / temp;
				for (int i = count; i >= 0; i--) {
					intList.add(i * temp);
				}
				return intList;
			} else {
				int count = hasScore / temp;
				for (int i = count; i >= 0; i--) {
					intList.add(i * temp);
				}
				return intList;
			}

		}
	}

	public static String getEmailEqualPlanString(List<Map<String, Object>> payList) {
		StringBuffer buffer = new StringBuffer();
		for (Map<String, Object> map : payList) {
			buffer.append("<tr>").append("<td style='border: 1px solid;height: 20px;'>")
					.append((String) map.get("payDate")).append("</td>")
					.append("<td style='border: 1px solid;height: 20px;'>").append((int) map.get("payDays"))
					.append("</td>").append("<td style='border: 1px solid;height: 20px;'>")
					.append((String) map.get("payCapital")).append("</td>")
					.append("<td style='border: 1px solid;height: 20px;'>").append((String) map.get("payInterest"))
					.append("</td>").append("</tr>");
		}
		return buffer.toString();
	}

	public static String getRandomUsername() {
		StringBuffer buffer = new StringBuffer();
		Random r = new Random();
		String a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ赵钱孙李周吴郑王哭覅饿嫩旅客脾车速雕欧四局渐酒";
		String b = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		buffer.append(a.charAt(r.nextInt(a.length() - 1))).append("TESTDATA")
				.append(b.charAt(r.nextInt(b.length() - 1)));
		return buffer.toString();
	}

	public static boolean isBetweenTodayAndAfterGiveDays(Date date, int days) {
		boolean flag = false;
		Date start = getNowStartTime();
		Date afterDay = getBeforeDateBetweenDays(days);
		if (date.getTime() <= afterDay.getTime() && date.getTime() >= start.getTime()) {
			flag = true;
		}
		return flag;
	}

	public static Date getNowStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.setTime(new Date());
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		return todayStart.getTime();
	}

	public static Date getNowEndTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.setTime(new Date());
		todayStart.set(Calendar.HOUR_OF_DAY, 23);
		todayStart.set(Calendar.MINUTE, 59);
		todayStart.set(Calendar.SECOND, 59);
		return todayStart.getTime();
	}

	public static Date getBeforeDateBetweenDays(int days) {
		Calendar todayStart = Calendar.getInstance();
		todayStart.setTime(new Date());
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.add(Calendar.DAY_OF_MONTH, days);
		return todayStart.getTime();
	}

}
