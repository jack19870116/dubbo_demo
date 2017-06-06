package com.tiancaibao.utils;

import java.text.ParseException;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 作者 caochunmin
 * @version 创建时间：2017年3月30日 下午2:54:59 类说明 计息类
 */
public class MoneyUtil {
	// 默认除法运算精度

	private static final int DEF_DIV_SCALE = 10;

	// 这个类不能实例化

	private MoneyUtil() {

	}

	/**
	 *
	 * 提供精确的加法运算。
	 *
	 * @param v1
	 *            被加数
	 *
	 * @param v2
	 *            加数
	 *
	 * @return 两个参数的和
	 *
	 */

	public static double add(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.add(b2).doubleValue();

	}

	/**
	 *
	 * 提供精确的减法运算。
	 *
	 * @param v1
	 *            被减数
	 *
	 * @param v2
	 *            减数
	 *
	 * @return 两个参数的差
	 *
	 */

	public static double sub(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.subtract(b2).doubleValue();

	}

	/**
	 *
	 * 提供精确的乘法运算。
	 *
	 * @param v1
	 *            被乘数
	 *
	 * @param v2
	 *            乘数
	 *
	 * @return 两个参数的积
	 *
	 */

	public static double mul(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.multiply(b2).doubleValue();

	}

	/**
	 *
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
	 *
	 * 小数点以后10位，以后的数字四舍五入。
	 *
	 * @param v1
	 *            被除数
	 *
	 * @param v2
	 *            除数
	 *
	 * @return 两个参数的商
	 *
	 */

	public static double div(double v1, double v2) {

		return div(v1, v2, DEF_DIV_SCALE);

	}

	/**
	 *
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	 *
	 * 定精度，以后的数字四舍五入。
	 *
	 * @param v1
	 *            被除数
	 *
	 * @param v2
	 *            除数
	 *
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 *
	 * @return 两个参数的商
	 *
	 */

	public static double div(double v1, double v2, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException(

					"The scale must be a positive integer or zero");

		}

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	/**
	 *
	 * 提供精确的小数位四舍五入处理。
	 *
	 * @param v
	 *            需要四舍五入的数字
	 *
	 * @param scale
	 *            小数点后保留几位
	 *
	 * @return 四舍五入后的结果
	 *
	 */

	public static double round(double v, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException(

					"The scale must be a positive integer or zero");

		}

		BigDecimal b = new BigDecimal(Double.toString(v));

		BigDecimal one = new BigDecimal("1");

		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	/**
	 * @throws ParseException
	 * @Title: getPayPlanList
	 * @Description: 获取还款计划列表: 只符合借款期限为30，60，90天的项目（按月付息到期还本）《后台》
	 * @param proAmount项目金额
	 * @param percent
	 *            利率
	 * @param startDate
	 *            开始日期
	 * @param Months
	 *            项目周期
	 * @param @return
	 *            List<Map<String,Object>> 返回类型
	 */
	public static List<Map<String, Object>> getPayPlanList(Double proAmount, Double percent, Date startDate,
			int existDays, Date payTime) throws ParseException {
		// 项目总金额的string格式
		Date payDateTime = StringUtil.getEndDateByDays(payTime, 1);
		Date payDate = StringUtil.getEndDateByDays(payDateTime, existDays);
		int months = existDays / 30;
		// 用来验证
		String proAmountString = StringUtil.formatStringToNeedMoneyDisplay(proAmount.toString());
		// 每天还的利息钱
		Double dayPayAmount = MoneyUtil.div(MoneyUtil.mul(proAmount, percent), 360, 3);
		// 还款计息天数
		int day = existDays;
		// 一共需要还的钱
		Double totalPay = MoneyUtil.add(proAmount, MoneyUtil.mul(dayPayAmount, day));
		// 应还利息
		Double interestPayble = MoneyUtil.round(MoneyUtil.mul(dayPayAmount, existDays), 2);
		// 每月应还利息
		Double everyMonthPayble = MoneyUtil.div(interestPayble, months, 3);
		List<Map<String, Object>> plans = new ArrayList<Map<String, Object>>();
		for (int i = 1; i <= months; i++) {
			Map<String, Object> pMap = new HashMap<String, Object>();
			pMap.put("proAmount", proAmount);// 借款总额
			pMap.put("totalPay", totalPay);// 应还总额
			pMap.put("interestPayble", interestPayble);// 应还利息
			if (i != months) {
				pMap.put("everyMonthPayble", everyMonthPayble);// 应还金额本息
			} else {
				pMap.put("everyMonthPayble", MoneyUtil.add(everyMonthPayble, proAmount));// 应还金额本息
			}
			pMap.put("terms", i);
			Double lastPay = MoneyUtil.add(proAmount, MoneyUtil.mul(dayPayAmount, 30));
			String lastPayString = StringUtil.formatStringToNeedMoneyDisplay(lastPay.toString());
			int time = i * 30;
			if (i != months) {
				pMap.put("payTime", StringUtil.getEndDateByDays(payDateTime, time));
			} else {
				pMap.put("payTime", payDate);
			}
			// 本息
			if (i != months) { // 按月还息到期还本
				pMap.put("payAmount", StringUtil.formatDoubleToMoneyDisplay(MoneyUtil.mul(30, dayPayAmount)));
			} else {
				pMap.put("payAmount", lastPayString);
			}
			// 利息
			pMap.put("interest", StringUtil.formatDoubleToMoneyDisplay(MoneyUtil.mul(30, dayPayAmount))); // 每月应该还的利息
			// 本金
			if (i != months) {
				pMap.put("capital", "0.00");
			} else {
				pMap.put("capital", proAmountString);
			}
			// 每月还的利息
			Double everyMonth = MoneyUtil.mul(30, dayPayAmount);
			// 已经还的利息
			Double alreadyInterest = MoneyUtil.mul(everyMonth, i);
			// 剩余本息为本金加上剩余天数的利息
			Double leftAmount = MoneyUtil.sub(alreadyInterest, totalPay);
			// 剩余本息
			if (i != months) {
				pMap.put("leftAmount", StringUtil.formatStringToNeedMoneyDisplay(leftAmount.toString()));
			} else {
				pMap.put("leftAmount", "0.00");
			}
			plans.add(pMap);
		}
		return plans;
	}

	/**
	 * @throws ParseException
	 * @Title: getPayPlanList
	 * @Description: 获取还款计划列表:一次性还本付息《后台》
	 * @param proAmount项目金额
	 * @param percent
	 *            利率
	 * @param startDate
	 *            开始日期
	 * @param Months
	 *            项目周期
	 * @param @return
	 *            List<Map<String,Object>> 返回类型
	 */
	public static Map<String, Object> getPayPlanList2(Double proAmount, Double percent, Date startDate, int existDays,
			Date payTime) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		// 项目总金额的string格式
		Date payDateTime = StringUtil.getEndDateByDays(payTime, 1);
		// 还款日期
		Date payDate = StringUtil.getEndDateByDays(payDateTime, existDays);
		// 每天还的利息钱
		Double dayPayAmount = MoneyUtil.div(MoneyUtil.mul(proAmount, percent), 360, 3);
		// 一共需要还的钱
		Double totalPay = MoneyUtil.add(proAmount, MoneyUtil.mul(dayPayAmount, existDays));
		// 应还利息
		Double interestPayble = MoneyUtil.round(MoneyUtil.mul(dayPayAmount, existDays), 2);
		map.put("totalPay", totalPay);// 应还总金额
		map.put("interestPayble", interestPayble);// 应还利息
		map.put("payDate", payDate);// 还款日期
		return map;
	}
}
