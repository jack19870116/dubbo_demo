package com.tiancaibao.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberFormat {
	/**
	 * 保留double后两位小数(四舍五入)
	 * 
	 * @param number
	 * @return
	 */
	public static Double doubleSplitTwoDecimal(Double number) {
		DecimalFormat df = new DecimalFormat("#.00");
		String format = df.format(number);
		return Double.parseDouble(format);
	}

	/**
	 * 数据库取出换算
	 */
	public static Double outDataMoney(Long money) {
		BigDecimal b1 = new BigDecimal(money);

		BigDecimal b2 = new BigDecimal(10000);

		return b1.divide(b2).doubleValue();
	}
	/**
	 * 数据库存入换算
	 */
	public static Long intoDataMoney(Long money) {
		BigDecimal b1 = new BigDecimal(money);

		BigDecimal b2 = new BigDecimal(10000);

		return b1.multiply(b2).longValue();
	}
	
	

	/**
	 * 保留double后四位小数(四舍五入)
	 * 
	 * @param number
	 * @return
	 */
	public static Double doubleSplitFourDecimal(Double number) {
		DecimalFormat df = new DecimalFormat("#.0000");
		String format = df.format(number);
		return Double.parseDouble(format);
	}

	public static String leftAdd0(Long num) {
		// 0 代表前面补充0
		// 8代表长度为8
		// d 代表参数为正数型
		String str = String.format("%08d", num);
		return str;
	}

	/**
	 * 格式 %0Nd
	 * 
	 * @param prec
	 * @param num
	 * @return
	 */
	public static String leftAdd0(String prec, Object object) {
		// 0 代表前面补充0
		// N代表长度为N
		// d 代表参数为正数型

		DecimalFormat df = new DecimalFormat(prec);
		String format = df.format(object);
		return format;
	}

	public static void main(String[] args) {
		// stem.out.prin// Sytln(doubleSplitTwoDecimal(54657965.51934));
		double d = 3.1415926;

		String result = String.format("%.2f", d);
		System.out.println(leftAdd0("#.00", 123.65646549846));
		System.out.println(result);
	}
}
