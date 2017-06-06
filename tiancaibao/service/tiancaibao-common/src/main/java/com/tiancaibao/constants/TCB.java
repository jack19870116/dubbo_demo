package com.tiancaibao.constants;

import com.tiancaibao.utils.ReadProperties;

/**
 * 系统常量
 * @author Mack
 * 2017年2月4日 下午2:38:48
 */
public interface TCB {

	/**mack
	 *单笔提现限制
	 */
	public static final Integer SINGLEWITHDRAWLIMIT = Integer.parseInt(ReadProperties.getValue("singlewithdrawlimit"));
	public static final String SINGLEWITHDRAWLIMIT_MSG = "单笔提现金额不可超过"+Integer.parseInt(ReadProperties.getValue("singlewithdrawlimit_msg"))+"万";
	/**
	 *系统提现限制 
	 */
	public static final Integer SYSTEMWITHDRAWLIMIT = Integer.parseInt(ReadProperties.getValue("systemwithdrawlimit"));
	
	/**mack
	 * json 返回值
	 */
	public static final String RETURN_SUCCESS = "success";
	public static final String RETURN_ERROR = "error";
	public static final String RETURN_ERRNO = "errno";
	public static final String RETURN_DATA = "data";
	/**
	 * 异常返回
	 */
	public static final String EXCEPTION_MSG = "操作失败";
	/**
	 * 实名认证返回值
	 */
	public static final String NOT_REAL_NAME = "暂未实名认证";
	/**
	 * 暂未绑卡
	 */
	public static final String NOT_BIND_CARD = "暂未绑卡";
	/**
	 * 提现返回值
	 */
	public static final String WITHDRAW_FAIL = "提现失败";
	public static final String OVERSYSTEMLIMIT_MSG="目前提现总额已超过新浪保证金限额，您该笔提现预计两个工作日内到账，如果希望尽快到账，建议第二个工作日再操作提现。是否继续?";
	public static final Integer OVERSYSTEMLIMIT_CODE=21001;
	public static final String  FEE_MSG = "本笔提现需收取2元手续费,提现金额不得低于2元";
	public static final String LESSBALANCE = "账户余额不足,无法提现";
	/**
	 * 关闭赎回时间-节假日
	 */
	public static final String HOLIDAYSTART = "2016-12-31 00:00:00";
	public static final String HOLIDAYEND = "2017-01-03 09:00:00";
}
