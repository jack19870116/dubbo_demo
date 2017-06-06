package com.tiancaibao.constants;

import com.tiancaibao.utils.ReadProperties;

/**
 * 业务层常量
 * 
 * @author Mack 2017年2月4日 下午2:41:41
 */
public interface ServiceConstants {
	
	/**
	 * 业务层返回字段--已经实名认证
	 */
	public static final Integer CODE_REALNAME_ALREADY = 1000;
	/**
	 * 业务层返回字段--暂未实名认证phone为空
	 */
	public static final Integer CODE_REALNAME_PHONE = 1002;

	/**
	 * 业务层返回字段--暂未绑卡sinapay_bank_card为空
	 */
	public static final Integer CODE_REALNAME_CARD = 1003;
	/**
	 * 业务层返回字段--提现费用
	 */
	public static final Integer FIRSTWITHDRAWFEE = Integer.parseInt(ReadProperties.getValue("firstWithdraw"));
	
	public static final Integer NOTFIRSTWITHDRAWFEE = Integer.parseInt(ReadProperties.getValue("notFirstWithdraw"));
}
