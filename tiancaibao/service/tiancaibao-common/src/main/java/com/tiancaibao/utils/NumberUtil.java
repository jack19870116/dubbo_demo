package com.tiancaibao.utils;


public class NumberUtil {

	public static Long double2long(Double dou){
		return ((Double)(dou*100)).longValue();
	}
	
	public static Double long2double(Long lon){
		return NumberFormat.doubleSplitTwoDecimal((lon+0.0)/100);
	}
	
	public static void main(String[] args) {
		
	}
}
