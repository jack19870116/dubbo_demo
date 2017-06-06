package com.tiancaibao.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PojoUtil {

	private static final Logger log = LoggerFactory.getLogger(PojoUtil.class);

	/**
	 * 根据属性名获取属性值
	 */
	private static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 获取属性名数组
	 */
	private String[] getFiledName(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getType());
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}

	/**
	 * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
	 */

	@SuppressWarnings({ "unused", "rawtypes" })
	public static List<Map> getFiledsInfo(Object o, String parms) {

		String[] split = parms.split(",");

		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		List<Map> list = new ArrayList<Map>();
		Map<String, Object> infoMap = null;
		for (int i = 0; i < fields.length; i++) {
			infoMap = new HashMap<String, Object>();
			// infoMap.put("type", fields[i].getType().toString());
			System.out.println(getFieldValueByName(fields[i].getName(), o));
			
			infoMap.put(checkout(parms, fields[i].getName()), getFieldValueByName(fields[i].getName(), o));
			list.add(infoMap);
		}
		return list;
	}

	/**
	 * 获取对象的所有属性值，返回一个对象数组
	 */
	public Object[] getFiledValues(Object o) {
		String[] fieldNames = this.getFiledName(o);
		Object[] value = new Object[fieldNames.length];
		for (int i = 0; i < fieldNames.length; i++) {
			value[i] = this.getFieldValueByName(fieldNames[i], o);
		}
		return value;
	}

	public static String checkout(String datapram, String objectprams ) {
		String newparm ="";
		String[] prams=datapram.split(",");
		System.out.println(prams.toString());
		for (String p : prams) {
			System.out.println("p:"+p);
			String ps = p;
			ps = ps.replace("_", "");
			System.out.println("ps:"+ps);
			if (ps.equalsIgnoreCase(objectprams)) {
				newparm = p;
				break;
			}else{
				newparm=objectprams;
			}

		}
		return newparm;
	}

	

}
