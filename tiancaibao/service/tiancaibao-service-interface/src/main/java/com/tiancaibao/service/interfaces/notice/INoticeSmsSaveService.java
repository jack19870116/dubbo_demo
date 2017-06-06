package com.tiancaibao.service.interfaces.notice;

public interface INoticeSmsSaveService {
	
	/**
	 * 保存数据进入短信表
	 * @param phone 手机号码
	 * @param content  短信内容
	 * @return
	 */
	public Long saveSmsToSmsTable(String phone, String content);

	/**
	 * 更新短信发送状态，1为成功，0为失败
	 * @param smsId
	 * @param smsStatus
	 */
	public void updateSmsStatusToSmsTable(Long smsId, Boolean smsStatus);
}
