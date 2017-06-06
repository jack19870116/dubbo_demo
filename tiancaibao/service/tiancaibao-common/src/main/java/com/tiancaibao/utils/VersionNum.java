package com.tiancaibao.utils;

public class VersionNum {
	/**
	 * 判断版本号大小 ver1是否小于ver2
	 */
	public static Boolean isSmall(String ver1, String ver2) {
		String[] arr1 = ver1.split("\\.");
		String[] arr2 = ver2.split("\\.");
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i].compareTo(arr2[i]) < 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		/*String str = "2.0.0";
		String[] split = str.split("\\.");
		
		 * for (String string : split) { System.out.println(string); }
		 
		int compareTo = "1".compareTo("2");
		System.out.println(compareTo);*/
	}
}
