package com.tiancaibao.service.notice.sms;


import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.notice.NoticeSmsMapper;
import com.tiancaibao.pojo.notice.NoticeSms;
import com.tiancaibao.service.interfaces.notice.INoticeSmsSaveService;

@Service("noticeSmsSaveService")
public class SmsSaveServiceImpl implements INoticeSmsSaveService {
	@Resource 
	private NoticeSmsMapper smsMapper;
	
	/**
	 * 保存数据进入短信表
	 * @param phone 手机号码
	 * @param content  短信内容
	 * @return
	 */
	@Transactional
	@Override
	public Long saveSmsToSmsTable(String phone, String content){
		NoticeSms sms = new NoticeSms();
		sms.setIsSuccess(false);
		sms.setPhone(phone);
		sms.setContent(content);
		sms.setCreatedAt(new Date());
		smsMapper.insertAndReturnId(sms);
		return sms.getId();
	}
	
	/**
	 * 更新短信发送状态，1为成功，0为失败
	 * @param smsId
	 * @param smsStatus
	 */
	@Transactional
	@Override
	public void updateSmsStatusToSmsTable(Long smsId,Boolean smsStatus){
		NoticeSms sms = new NoticeSms();
		sms.setId(smsId);
		sms.setIsSuccess(smsStatus);
		smsMapper.updateByPrimaryKeySelective(sms);
	}
}
