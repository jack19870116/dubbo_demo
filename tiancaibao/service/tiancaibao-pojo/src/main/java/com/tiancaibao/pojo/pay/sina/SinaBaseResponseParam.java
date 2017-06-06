package com.tiancaibao.pojo.pay.sina;

import java.io.Serializable;

/**
 * 新浪接口返回参数
 * 
 * @author Mack
 *
 */
public class SinaBaseResponseParam implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 非空参数
	// 请求时间 格式yyyyMMddHHmmss
	private String response_time;
	//参数编码字符集
	private String _input_charset;
	//签名
	private String sign;
	//签名方式
	private String sign_type;
	//响应码
	private String response_code;
	
	
	//可空参数
	//合作者身份ID
	private String partner_id;
	//签名版本号
	private Double sign_version;
	//响应信息
	private String response_message;
	//备注
	private String memo;
	public String getResponse_time() {
		return response_time;
	}
	public void setResponse_time(String response_time) {
		this.response_time = response_time;
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
	public String getResponse_code() {
		return response_code;
	}
	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}
	public String getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}
	public String getResponse_message() {
		return response_message;
	}
	public void setResponse_message(String response_message) {
		this.response_message = response_message;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Double getSign_version() {
		return sign_version;
	}
	public void setSign_version(Double sign_version) {
		this.sign_version = sign_version;
	}
	
}
