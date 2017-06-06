package com.tiancaibao.pojo.notice;

import java.io.Serializable;

/**
 * 发送消息对象
 * @author Mack
 *
 */
public class NoticeSendSMS implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phone;   //发送手机号
	private Integer type;   //发送短信内容类型
	private String content; //发送短信内容
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
