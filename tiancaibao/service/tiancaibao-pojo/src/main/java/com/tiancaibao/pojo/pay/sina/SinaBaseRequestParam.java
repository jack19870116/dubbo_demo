package com.tiancaibao.pojo.pay.sina;

import java.io.Serializable;

import java.util.Date;
import com.tiancaibao.pay.sina.PropertiesUtil;
import com.tiancaibao.utils.DateUtil;

/**
 * 新浪接口请求参数
 * 
 * @author Mack
 *
 */
public class SinaBaseRequestParam implements Serializable {
	/**
	 * 
	 */
	{
		sign_type = "RSA";
		version = Double.parseDouble(PropertiesUtil.getValue("SINAPAY_VERSION"));
		request_time = DateUtil.formatDateByFormat(new Date(), "yyyyMMddHHmmss");
		partner_id = PropertiesUtil.getValue("DEBUG_SINAPAY_PARTNER_ID");
		_input_charset = PropertiesUtil.getValue("SINAPAY_INPUT_CHARSET");
	}
	private static final long serialVersionUID = 1L;

	// 接口名称
	private String service;
	// 接口版本
	// 必须参数
	private Double version;
	// 请求时间 格式yyyyMMddHHmmss
	private String request_time;
	// 合作者身份ID
	private String partner_id;
	// 参数编码字符集
	private String _input_charset;
	// 签名
	private String sign;
	// 签名方式
	private String sign_type;

	// 非必须参数
	// 签名版本号
	private Integer sign_version;
	// 加密版本号
	private Integer encrypt_version;
	// 系统异步回调通知地址
	private String notify_url;
	// 页面跳转同步返回页面路径
	private String return_url;
	// 备注
	private String memo;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Double getVersion() {
		return version;
	}

	public void setVersion(Double version) {
		this.version = version;
	}

	public String getRequest_time() {
		return request_time;
	}

	public void setRequest_time(String request_time) {
		this.request_time = request_time;
	}

	public String getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}

	public String get_input_charset() {
		return _input_charset;
	}

	public void set_input_charset(String _input_charset) {
		this._input_charset = _input_charset;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public Integer getSign_version() {
		return sign_version;
	}

	public void setSign_version(Integer sign_version) {
		this.sign_version = sign_version;
	}

	public Integer getEncrypt_version() {
		return encrypt_version;
	}

	public void setEncrypt_version(Integer encrypt_version) {
		this.encrypt_version = encrypt_version;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
