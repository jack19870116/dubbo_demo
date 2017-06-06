package com.tiancaibao.utils;

import java.io.File;
import java.util.Map;

/**
 * @author 作者 caochunmin
 * @version 创建时间：2017年3月30日 下午3:12:23 类说明
 */
public class Constants {
	public static final String INVEST_GURANTEE = "5";// 投担保
	public static final String PAYMENT_TYPE_MONTH = "0";// 按月付息，到期回本
	public static final String PAYMENT_TYPE_EQUAL = "1";// 等额本息
	public static final String PAYMENT_TYPE_DAY = "2";// 按日付息，到期回本
	public static final String DONATE_FLAG = "1";
	public static final String TRUE = "1";
	public static final String FALSE = "0";
	public static final String SUCCESS = "1";
	public static final String FAILURE = "0";
	public static final String SEND_SMS_SUCCESS = "0";
	public static final String SIGN_STATUS_OPEN = "1";
	public static final String SIGN_STATUS_CLOSE = "0";
	public static final String NOT_TRANSFER_FLAG = "0";
	public static final String TRANSFER_FLAG = "1";
	// 用户类型投资人
	public static final String USER_TYPE_INVEST = "1";
	// 用户类型借款人
	public static final String USER_TYPE_BORROW = "2";
	// 合同保存路径
	public static final String CONTACT_PATH = "d:" + File.separator + "contact";
	// 合同中平台服务名称
	public static final String PLATFORM_SERVICE_NAME = "华融普惠(北京)投资管理有限公司";
	// rest请求的标识
	public static final String REST_PATH = "lztou";
	// Session信息的key
	public static final String SESSION_INFONAME = "sessionInfo";
	// 业务异常信息的key,出现业务异常跳转后前台可以通过${errorMsg}来显示异常的信息
	public static final String BUSINESS_ERROR_MESSAGE = "errorMsg";
	// 业务成功的key
	public static final String BUSINESS_SUCCESS_MESSAGE = "successMsg";
	// 业务异常的默认跳转路径
	public static final String DEFAULT_BUSINESS_ERROR_PATH = "error/businessError";
	// 系统异常的默认跳转路径
	public static final String DEFAULT_SYSTEM_ERROR_PATH = "error/systemError";
	// 系统异常的错误信息
	public static final String SYSTEM_ERROR_MESSAGE = "系统异常,请联系管理员";

	// 传递给mybatis配置文件的分页和排序常量
	public static final String PAGE_SIZE = "pageSize";// 查询条数
	public static final String START_NUM = "startNum";// 第几个记录开始
	public static final String SORT_STR = "sortStr";// 排序的字符串
	public static final String SORT_ORDER = "sortOrder";// 排序规则 asc升序 ,desc 降序
	public static final String ASC = "asc";
	public static final String DESC = "desc";
	// 首页默认查询的项目条数
	public static final Integer INDEX_PRODUCT_DEFAULT_RECORDS = 4;
	// 用户当前是激活的状态
	public static final String USER_IS_ACTIVE = "1";
	// 用户当前已经锁定
	public static final String USER_IS_LOCK = "0";
	public static Map<String, Object> MENUMAP;
	public static Double ALLOW_MOST_INVEST_AMOUNT = 100000.0;
	// 邮箱激活
	public static final String EMAIL_ACTIVE = "1";
	// 验证系列默认值
	public static final String DEFAULT_ACTIVE = "0";
	// 用户默认等级
	public static final int DEFAULT_LEVEL = 0;
	// 默认排序方式
	public static final String DEFAULT_ORDER_DESC = "1";
	public static final String DEFAULT_ORDER_ASC = "2";
	// 媒体报道默认的排序字段
	public static final String DEFAULT_MEDIA_SORTSTR = "create_time";
	// 网站公告默认的排序字段
	public static final String DEFAULT_AFFICHE_SORTSTR = "start_date";

	// 项目状态常量
	public static final String PRO_FORECAST = "0";// 项目预告
	public static final String PRO_ABORTION = "1";// 流标
	public static final String PRO_FUND_RAISING = "2";// 正在募集
	public static final String PRO_RAISING_SUCCESS = "3";// 募集成功
	public static final String PRO_RECEIVING_FUND = "4";// 正在回款
	public static final String PRO_TRANSFER_SUCCESS = "5";// 转让完毕
	public static final String PRO_RECEIVE_FUND_SUCCESS = "6";// 回款完毕
	public static final String PRO_COMPANAY_AUDIT = "7";// 内部审核
	// 8 预约完成
	public static final String PRO_AUDIT_MANAGER = "9";// 经理审核放款

	// 放款 转账类型
	public static final String PRO_AUDIT_TRANSFERTYPE = "1";// 1:投资 2：代偿 3：代偿还款
															// 4：债权转让 5：结算担保收益
	// 放款 转账方式
	public static final String PRO_AUDIT_TRANSFERMODE = "1";// 1:逐笔入账 2：批量入账
	// 放款 借款人账户类型
	public static final String PRO_AUDIT_TACCTTYPE = "1";// 0:机构 1：个人
	// 放款 出借人账户类型
	public static final String PRO_AUDIT_FACCTTYPE = "1";// 0:机构 1：个人
	// 放款 出借人手续费
	public static final String PRO_AUDIT_FTRDFEE = "0.00";// 格式 12.00

	// 债权转让项目的状态

	public static final String TRANSFER_PROJECT_COLLECT = "1";// 正在募集

	public static final String TRANSFER_PROJECT_COMPLETE = "2";// 募集完成

	public static final String TRANSFER_PROJECT_END = "3";// 结束

	// 交易常量
	public static final String REPAYMENT = "0";// 还款
	public static final String INVEST = "1";// 投资
	public static final String RECHARGE = "2";// 充值
	public static final String WITHDRAW_MONEY = "3";// 提现
	public static final String REWARD = "4";// 奖励
	public static final String OTHER = "5";// 其他
	public static final String FLOW = "6";// 流标
	public static final String LENDING = "7";// 放款
	public static final String RECEIVE_MONEY = "8";// 收款
	public static final String PAYBACK_MONEY = "9";// 项目还款
	public static final String RIGESTER_SUBJECT = "11";// 标的登记
	public static final String PAY_SCORE = "12";// 投资激活
	public static final String BUY_TRANSFER = "13";// 认购债权
	public static final String TRANSFER_BACK_MONEY = "14";// 债权回款
	public static final String DONATE_MONEY = "15";// 捐赠公益
	public static final String ABORTION_PAYBACK = "17";// 捐赠公益

	public static final String FLOW_SCORE = "8";
	// 投资的模式
	public static final String AUTO_INVEST = "0";// 自动
	public static final String MANUAL_INVEST = "1";// 手动

	// 订单的状态
	public static final String PAY_SUCCESS = "1";// 支付成功
	public static final String PAY_FAILURE = "2";// 支付失败
	public static final String PROCESSING = "3";// 处理中

	// 发送模板类型
	public static final String RAISE_FUND_SUCCESS = "1";// 筹款成功
	public static final String CHARGE_SUCCESS = "2";// 充值成功
	public static final String INVEST_SUCCESS = "3";// 投资成功
	public static final String RELEASE_REWARD = "4";// 奖励发放
	public static final String OBTAIN_CASH = "5";// 提现成功
	public static final String REGISTER_ACTIVE = "6";// 注册激活
	public static final String FETCH_PASSWORD = "7";// 修改密码
	public static final String OPENA_CCOUNT_SUCCESS = "8";// 开户成功
	public static final String REGISTER_SUCCESS = "9";// 注册成功提醒
	public static final String FETCH_PASSWORD_SUCCESS = "10";// 找回密码成功
	public static final String ABORTION = "11";// 流标
	public static final String REPAYMENT_SUCCESS = "12";// 还款
	public static final String DONATE_SUCCESS = "13";// 捐赠成功
	public static final String PUBLIC_WELFARE = "13";// 公益

	// 合作项目 passReason常量
	public static final String BAIHETEMP = "1";// 情投意合
	public static final String PUBLICWELFARETEMP = "2";// 公益标

	// 发送消息类型
	public static final String EMAIL_TEMPLATE = "1";// 邮件模板
	public static final String PHONE_TEMPLATE = "2";// 手机模板
	public static final String MESSAGE_TEMPLATE = "3";// 系统消息模板

	// 是否消息提醒的配置常量
	public static final String MESSAGE_PUSH = "1";// 消息推送
	public static final String MESSAGE_NOT_PUSH = "0";// 消息不推送

	// 三种角色
	public static final String AUTH_USER = "authUser";
	public static final String REGISTER_USER = "registerUser";
	public static final String INVEST_USER = "investUser";
	public static final String ADMIN_USER = "adminUser";// 管理员
	public static final String SERVICE_USER = "serviceUser";// 客服
	// 注册用户的默认角色
	public static final int REGISTER_USER_ROLE = 1;
	// 已投资角色
	public static final int INVEST_USER_ROLE = 2;
	// 开户后认证角色
	public static final int AUTH_USER_ROLE = 3;

	// 默认的消息推送设置
	public static final String DEFALUT_MESSAGE_CONFIG = "1";

	// 域名
	public static final String LOCAL = "http://www.laizhetou.com/invest/";// 验证链接请求地址

	public static final String DEFAULT_CREATEBY = "来这投";
	public static final String DEFAULT_ISREAD = "0";
	public static final String DEFAULT_MSGTITLE = "0";
	public static final String DEFAULT_OPENACCOUNTTITLE = "开户成功提示";

	// 积分
	public static final String SCORE_TYPE_REGISTER = "1";// 注册
	public static final String SCORE_TYPE_FIRST_CHARGE = "2";// 第一次充值
	public static final String SCORE_TYPE_FIRST_INVEST = "3";// 第一次投资
	public static final String SCORE_TYPE_AWARD = "4";// 投资奖励
	public static final String SCORE_TYPE_OTHER = "5";// 其他

	// 公告状态
	public static final String ISACTIVE_NO = "1";
	// 公告状态
	public static final String ISACTIVE_YES = "0";
	/*
	 * //导出excel public static final String DELCRITIC_EXCEL =
	 * "D:/excel/delCritic_excel.xls";
	 */

	// 是否启用html模式
	public static boolean IS_HTML = true;
	// 发送者用户名
	public static final String USER_NAME = "postmaster@lztou.com";
	// 发件人密码
	public static final String PASSWORD = "huarong2014";
	// 字符编码
	public static final String ENCODING = "utf-8";
	// 是否启用群发模式
	public static final boolean IS_MULTIPART = true;
	// 发件人昵称
	public static final String NICK_NAME = "来这投";
	// 发送邮件mail server
	public static final String HOST = "smtp.lztou.com";
	// 是否进行服务器验证
	public static final boolean IS_SERVERS = true;

	public static String getEmailStyle() {
		StringBuffer sb = new StringBuffer();
		sb.append("<div style='margin:0; padding:0;width:700px;");
		sb.append("height:auto; color:#666; font:normal 12px/24px");
		sb.append("SimSun; margin:0 auto;-webkit-box-shadow: 0px");
		sb.append("1px 3px rgba(0, 0, 0, 0.15); -moz-box-shadow: 0px");
		sb.append("1px 3px rgba(0, 0, 0, 0.15); -o-box-shadow: 0px");
		sb.append("1px 3px rgba(0, 0, 0, 0.15); box-shadow: 0px 1px");
		sb.append("3px rgba(0, 0, 0, 0.15); margin-top:30px;");
		sb.append("font-family:SimSun, Verdana, Helvetica, sans-serif;");
		sb.append("color: #717171;font-weight: normal;'>");
		return sb.toString();

	}

	// 警戒邮件数
	public static final int LowestSmsTotal = 2000;
	// 警戒时发送邮件给谁
	public static final String GetEmailPerson = "zhaoqian_199109@sina.com";
	// 查看警戒邮件数 时间
	public static final String QuartzTime = "0 10 17 * * ?";

	public static final String AUDIT_STATUS_NOT_PASS = "0";// 审核不通过
	public static final String AUDIT_STATUS_READY_FOR_RISKAUDIT = "1";// 等待风控审核
	public static final String AUDIT_STATUS_RISKAUDIT_PASS = "2";// 风控审核通过
	public static final String AUDIT_STATUS_MARKET_PASS = "3";// 市场审核通过
	public static final String AUDIT_STATUS_MANAGER_PASS = "4";// 经理审核通过
	public static final String AUDIT_STATUS_ALREADY_PUBLISH = "5";// 已发布
	public static final String AUDIT_STATUS_ADD_SUCCESS = "6";// 添加完成
	public static final String FINAL_AUDIT_BYBORROW = "7";// 经理审核通过 放款
	public static final String FINAL_STATUS = "8";// 已放款

	public static final String UPDATE_PRODUCT_NOTICE_TITLE = "项目修改通知";// 项目修改通知标题
	public static final String UPDATE_PRODUCT_NOTICE_TYPE = "1";// 项目修改通知
	public static final String SYSTEM_NOTICE_TYPE = "2";// 系统通知
	/**
	 * 1：担保新手项目，2：简单新手福利3：投车贷 A 4：投车贷D 5：投担保
	 */
	public static final String NEWBIE_PROJECT_TYPE = "1";// 新手项目
	public static final String PROJECT_TYPE_SIMPLE_NEWBIE = "2";
	public static final String PROJECT_TYPE_CAR_LOAN = "3";// 投车贷A
	public static final String PROJECT_TYPE_GENERAL_PROJECT = "5"; // 投担保
	public static final String PROJECT_TYPE_CAR_D = "4";// 投车贷D
	public static final String PROJECT_TYPE_CAR_E = "6";// 投车贷E
	public static final String PROJECT_TYPE_CAR_B = "7";// 投车贷B
	public static final String DONATE_PROJECT = "2";// 捐赠项目

	public static final String SCORE_TYPE_FIRST = "1"; // 一马当先奖
	public static final String SCORE_TYPE_MOST = "2"; // 投资最多奖
	public static final String INVESTSCORE_FIRST = "3";// 投资送积分 第一档
	public static final String INVESTSCORE_SECOND = "4";
	public static final String INVESTSCORE_THIRD = "5";

	public static final int ONE_YEAR_DAYS = 365;

	public static final String SHOW_EXTRA = "2";
	public static final String HIDE_EXTRA = "0";
	public static final String INVEST_CAR = "3";
}
