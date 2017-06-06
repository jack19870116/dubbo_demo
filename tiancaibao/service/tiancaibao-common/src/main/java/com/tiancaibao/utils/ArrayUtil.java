package com.tiancaibao.utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

	/**
	 * byte数组转list集合(不要改成Object)
	 * 
	 * @param shopclassid
	 * @return
	 */
	public static List<Byte> arrayToList(byte[] arr) {
		List<Byte> list = new ArrayList<Byte>();
		for (Byte b : arr) {
			list.add(b);
		}
		return list;
	}
}
