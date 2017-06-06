package com.tiancaibao.service.notice.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tiancaibao.pojo.notice.NoticeSms;
import com.tiancaibao.service.interfaces.notice.INoticeSendSMSService;
import com.tiancaibao.utils.MD5Util;

import com.tiancaibao.utils.HttpRequest;

@Service("noticeSendSMSServivce")
public class SendSMSServiceImpl implements INoticeSendSMSService {
	
	private static Logger logger = LoggerFactory.getLogger(SendSMSServiceImpl.class);

	@Override
	public Boolean sendSMS(String phone,String content) {
		try{
			String url = "http://sdk2.entinfo.cn:8061/mdsmssend.ashx?";
			String pwd = MD5Util.md5("SDK-BBX-010-23312150628").toUpperCase();
			String rrid = "151427031105596686";
			String param = "sn=SDK-BBX-010-23312&pwd=" + pwd + "&mobile=" + phone + "&content=" + content + "&rrid="
					+ rrid;
			String result = HttpRequest.sendPost(url, param);
			if (rrid.equals(result)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(phone + ":短信发送失败");
			return false;
		}
	}
	
	@Override
	public NoticeSms createSms(String phone, int type) {
		// 发送消息
		String content = "";
		switch (type) {
		case 1: // 注册短信
			content = "恭喜您完成初步注册，快去实名认证哦。实名认证可得5000元体验金、20%加息券、80元现金红包。【天财宝】";
			break;
		case 2: // 实名短信
			content = "恭喜您实名注册成功！送您新手专享大礼包，包括5000元体验金，20%加息券一张，还有80元现金红包。请到账户查收使用。首投定期满5000元，再送3%加息券一张。【天财宝】";
			break;
		case 3:// 抽奖短信
			content = "恭喜您九宫格抽到实物，客服将尽快联系您，获取您的地址以便发货。您也可到微信服务号“天财宝理财”，联系小编。天财宝，正当年！【天财宝】";
		default:
		}
		NoticeSms sms = new NoticeSms();
		sms.setPhone(phone);
		sms.setContent(content);
		return sms;
	}
}
