package com.tiancaibao.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

	public static final String FormatDayToChinaTime24H = "yyyy年MM月dd日";
	public static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static String DATE_FORMAT = "yyyy-MM-dd";
	public static String TIME_FORMAT = "HH:mm:ss";

	/**
	 * 判断当前时间是否在两个时间段之间
	 * 
	 * @param star
	 * @param end
	 */
	public static boolean isNowDateBetween(String star, String end) {
		SimpleDateFormat localTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date sdate = localTime.parse(star);
			Date edate = localTime.parse(end);
			Date date = new Date();
			// System.out.println(sdate.getTime()+"##"+sdate.getTime()+"##"+edate.getTime());
			if (date.after(sdate) && date.before(edate)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Parse date like "yyyy-MM-dd".
	 */
	public static Date parseDate(String d) {
		try {
			return new SimpleDateFormat(DATE_FORMAT).parse(d);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Parse date like "yyyy-MM-dd HH:mm:ss".
	 */
	public static Date parseDateTime(String d) {
		try {
			return new SimpleDateFormat(DATETIME_FORMAT).parse(d);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Parse date like "HH:mm:ss".
	 */
	public static Date parseTime(String d) {
		try {
			return new SimpleDateFormat(TIME_FORMAT).parse(d);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 以指定的格式来格式化日期
	 * 
	 * @param date
	 *            Date
	 * @param format
	 *            String
	 * @return String
	 */
	public static String formatDateByFormat(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 常用的格式化日期 yyyy-MM-dd
	 * 
	 * @param date
	 *            Date
	 * @return String
	 */
	public static String formatDate(Date date) {
		return formatDateByFormat(date, "yyyy-MM-dd");
	}

	/**
	 * 常用的格式化日期 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            Date
	 * @return String
	 */
	public static String formatDateTOyMdHms(Date date) {
		return formatDateByFormat(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 常用的格式化日期 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            Date
	 * @return String
	 */
	public static String formatDateTOyMdHmsForSina(Date date) {
		return formatDateByFormat(date, "yyyyMMddHHmmss");
	}

	/**
	 * @根据当前日期计算n天后的日期
	 * @return String
	 */
	public static Date afterNDay(Date date, int n) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, n);
		Date destDay = c.getTime();
		return destDay;
	}

	/**
	 * 两个日期间的天数
	 */
	public static int getIntervalDays(Date startday, Date endday) {
		if (startday.after(endday)) {
			Date cal = startday;
			startday = endday;
			endday = cal;
		}
		long sl = startday.getTime();
		long el = endday.getTime();
		long ei = el - sl;
		return (int) (ei / (1000 * 60 * 60 * 24));
	}

	/**
	 * 判断两个日期是否相同
	 */
	public static boolean isEqual(Date startday, Date endday) {
		if (startday.after(endday)) {
			Date cal = startday;
			startday = endday;
			endday = cal;
		}
		long sl = startday.getTime();
		long el = endday.getTime();
		int ei = (int) (el - sl);
		if (ei == 0) {
			return true;
		}
		return false;
	}

	/*
	 * public static boolean verifyDate(String birthday){ String [] array =
	 * birthday.split("-"); if(null == array || array.length != 3 ||
	 * array[0].length() !=4 || array[1].length() != 2 || array[2].length() !=
	 * 2) return false; int curyear = DateUtil.getYear(new Date()); try { int
	 * studyear = Integer.parseInt(array[0]); if(studyear <= 1900 || studyear >
	 * curyear) return false; String curDateStr = formatDateByFormat(new Date(),
	 * DATE_FORMAT); if(birthday.compareTo(curDateStr) >= 0) return false;
	 * return checkDate(birthday); } catch (NumberFormatException e) { return
	 * false; } }
	 */

	@SuppressWarnings("unused")
	private static boolean checkDate(String date) {
		// System.out.println(date);
		// 判断年月日的正则表达式，接受输入格式为2010-12-24，可接受平年闰年的日期
		String regex = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcherObj = pattern.matcher(date);
		return matcherObj.matches();
	}

	/**
	 * 获得当前天的开始时间
	 * 
	 * @param args
	 */
	@SuppressWarnings({ "deprecation" })
	public static Date getDayStartDate() {
		Date date = new Date();
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		return date;
	}

	/**
	 * 获得当天的的date--对应mysql中的date
	 * 
	 * @param args
	 */
	@SuppressWarnings({ "deprecation" })
	public static Date todayDate() {
		Date date = new Date();
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		return date;
	}

	/**
	 * 获得当前天的结束时间
	 * 
	 * @param args
	 */
	@SuppressWarnings({ "deprecation" })
	public static Date getDayEndDate() {
		Date date = new Date();
		date.setHours(23);
		date.setMinutes(59);
		date.setSeconds(59);
		return date;
	}

	/**
	 * 判断时间是否在两个整点之间
	 */
	@SuppressWarnings("deprecation")
	public static Boolean isBetweenNHourWithMHour(int n, int m) {
		Date currenDate = new Date(); // 当前时间
		Date NHour = new Date();
		NHour.setHours(n);
		NHour.setMinutes(0);
		NHour.setSeconds(0);
		Date MHour = new Date();
		MHour.setHours(m);
		NHour.setMinutes(0);
		NHour.setSeconds(0);
		if (currenDate.compareTo(NHour) >= 0 && currenDate.compareTo(MHour) <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 获得当前月开始时间
	 * 
	 * @param args
	 */
	public static Date getMonthStartDate() {
		Calendar calendar = Calendar.getInstance();// 获取当前日期
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		System.out.println(calendar.getTimeInMillis());
		return calendar.getTime();
	}

	/**
	 * 获得当前月结束时间
	 * 
	 * @param args
	 */
	public static Date getMonthEndDate() {
		Calendar calendar = Calendar.getInstance();// 获取当前日期
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		System.out.println(calendar.getTimeInMillis());
		return calendar.getTime();
	}

	/**
	 * 获得当前月开始时间
	 * 
	 * @param args
	 */
	public static Date getLastMonthStartDate() {
		Calendar calendar = Calendar.getInstance();// 获取当前日期
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		System.out.println(calendar.getTimeInMillis());
		return calendar.getTime();
	}

	/**
	 * 获得当前月结束时间
	 * 
	 * @param args
	 */
	public static Date getLastMonthEndDate() {
		Calendar calendar = Calendar.getInstance();// 获取当前日期
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		System.out.println(calendar.getTimeInMillis());
		return calendar.getTime();
	}

	/**
	 * 获得当前时间的年月 201609
	 * 
	 * @return
	 */
	public static String currentYearMonth() {
		return DateUtil.formatDateByFormat(new Date(), "yyyyMM");
	}

	/**
	 * 计算两个日期相隔的秒
	 * 
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */
	public static int nSecondBetweenTwoDate(String firstString, String secondString) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date firstDate = null;
		Date secondDate = null;
		try {
			firstDate = df.parse(firstString);
			secondDate = df.parse(secondString);
		} catch (Exception e) {
			// 日期型字符串格式错误
		}
		int nDay = (int) ((firstDate.getTime() - secondDate.getTime())) / 1000;
		return nDay;
	}

	/**
	 * 当前时间是否为周六周天
	 * 
	 * @return
	 */
	public static Boolean isWeekendToday() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (week == 6 || week == 0) {// 0代表周日，6代表周六
			return true;
		}
		return false;
	}

	/**
	 * 判断是否是天财宝会员日20
	 * 
	 * @return
	 */
	public static boolean isMembersDay() {
		String mm = DateUtil.formatDateByFormat(new Date(), "dd");
		if ("20".equals(mm)) {
			return true;
		}
		return false;
	}
	/**
	 * 判断是否是天财宝会员日20
	 * 
	 * @return
	 */
	public static boolean isMembersDay(Date parm) {
		String mm = DateUtil.formatDateByFormat(parm, "dd");
		if ("20".equals(mm)) {
			return true;
		}
		return false;
	}

	/**
	 * 当前时间增加多少天
	 * 
	 * @author Mack 2017年2月8日 下午1:16:52
	 * @param args
	 */
	public static String addDays(int day) {
		Date t1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(t1);
		cal.add(Calendar.DAY_OF_MONTH, day);
		Date time = cal.getTime();
		return DateUtil.formatDateTOyMdHms(time);
	}

	/**
	 * 当前时间增加多少天
	 * 
	 * 
	 */
	public static Date addDaysTime(int day) {
		Date t1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(t1);
		cal.add(Calendar.DAY_OF_MONTH, day);
		Date time = cal.getTime();

		return time;
	}
	/**
	 * 当前时间增加多少分钟
	 * 
	 * 
	 */
	public static Date addMinuteTime(int minute) {
		Date t1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(t1);
		cal.add(Calendar.MINUTE, minute);
		Date time = cal.getTime();
		
		return time;
	}

	/**
	 * 检测当前时间是否在凌晨与规定的时间之间
	 * 
	 * @param args
	 */
	public static boolean betweenDate(int hours) {

		Calendar c = Calendar.getInstance();
		Date time_now = new Date();
		c.setTime(time_now);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date time_wee = c.getTime();// 当天凌晨
		c.add(Calendar.HOUR, hours);// 当天凌晨之后几小时
		Date time_late = c.getTime();

		if (time_now.after(time_wee) && time_now.before(time_late)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( addMinuteTime(-3)));
	}

}
