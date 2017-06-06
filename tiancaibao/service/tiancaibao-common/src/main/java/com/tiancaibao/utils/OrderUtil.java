package com.tiancaibao.utils;

import java.util.Date;

/**
 * 生成订单ID工具类
 * @author Mack
 * 2017年2月13日 上午11:29:10
 */
public class OrderUtil {
	
	/**
	 * 创建订单号
	 * @author Mack
	 * 2017年2月13日 上午11:32:09 
	 * @param ingerfaceName
	 * @param direction
	 * @param userId
	 * @return
	 */
	public static String createOrderId(String ingerfaceName,String direction,Long userId){

			long start = System.nanoTime(); // 毫微秒
			return ingerfaceName + "^" + direction + "^" + DateUtil.formatDateTOyMdHmsForSina(new Date()) + "^" + NumberFormat.leftAdd0(userId);
		}
}
