package com.tiancaibao.service.trade.invest.biz;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.integral.IntegralRecords;
import com.tiancaibao.pojo.integral.IntegralSources;
import com.tiancaibao.pojo.integral.IntegralTalentSource;
import com.tiancaibao.pojo.trade.TradeInvestRecords;
import com.tiancaibao.pojo.trade.TradeInvestRecordsExample;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.integral.IIntegralRecordsService;
import com.tiancaibao.service.interfaces.integral.IIntegralSourcesService;
import com.tiancaibao.service.interfaces.integral.ITalentSourcesService;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.notice.INoticeInternalMessageService;
import com.tiancaibao.service.interfaces.notice.biz.INoticeBizSendSMSOnMqService;
import com.tiancaibao.service.interfaces.talent.ITalentService;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestRecordsService;
import com.tiancaibao.service.interfaces.trade.invest.biz.ITradeInvestSuccessEventService;
import com.tiancaibao.service.interfaces.user.IUserInviteLogsService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.StringUtil;

@Service("tradeInvestSuccessEventService")
public class TradeInvestSuccessEventServiceImpl implements ITradeInvestSuccessEventService {

	/**
	 * 调用用户接口
	 */
	@Resource
	private IUserService userService;

	@Resource
	private IIntegralSourcesService integralSourcesService;

	@Resource
	private ITradeInvestRecordsService tradeInvestRecordsService;

	@Resource
	private IIntegralRecordsService integralRecordsService;

	@Resource
	private IUserInviteLogsService userInviteLogsService;

	@Resource
	private ITalentSourcesService talentSourcesService;

	@Resource
	IMqMessageService mqMessageSender;

	@Resource
	ITalentService talentsService;

	@Resource
	INoticeBizSendSMSOnMqService sendSmsOnMqService;

	@Resource
	INoticeInternalMessageService internalMessageService;

	@Override
	public void investSuccess(TradeInvestRecords investRecords) {

		if (investRecords.getDays() != 1) {

			// 发送电子合同队列请求
			/**
			 * 
			 * 暂缓
			 */
			Users user = userService.selectUserById(investRecords.getUserId());
			Users inviter = null;

			if (!StringUtil.empty(user) && !StringUtil.empty(user.getInvitedByUserId())) {
				inviter = userService.selectUserById(user.getId());
			}
			// 定期投资积分值变动
			IntegralSources integralSource3 = integralSourcesService.selectIntegralSourcesById(3);
			integralSource3.setIntegral((int) (investRecords.getDays() * investRecords.getAmount()) / 3000);

			int sum = tradeInvestRecordsService.selectTradeInvestRecords(user.getId(), 1);

			if (!StringUtil.empty(inviter) && sum == 1 && investRecords.getAmount() < 2000) {
				// 发送积分
				userService.updateIntegralById(inviter.getId(), inviter.getIntegral() + integralSource3.getIntegral(),
						inviter.getIntegral());

				IntegralRecords integralRecords = new IntegralRecords();
				integralRecords.setUserId(inviter.getId());
				integralRecords.setIntegral(integralSource3.getIntegral());
				integralRecords.setSource("4");
				integralRecords.setUserCurrentIntegral(inviter.getIntegral());
				integralRecords.setRemark(investRecords.getId().toString());
				integralRecordsService.saveIntegralRecords(integralRecords);

				// 被邀请人首次投资定期且<2000元只送积分,加入邀请奖励记录
				userInviteLogsService.insertintUserInviteLogs(user.getInvitedByUserId(), user.getId(), user.getPhone(),
						2, null, integralSource3.getIntegral(), investRecords.getId().toString());

				// 站内信
				JSONObject noticeQueue = new JSONObject();
				noticeQueue.put("userId", inviter.getId());
				noticeQueue.put("title", "邀请首投定期");
				noticeQueue.put("info", 5);
				noticeQueue.put("status", 0);
				noticeQueue.put("amount", integralSource3.getIntegral().toString());
				noticeQueue.put("phone", user.getPhone());
				noticeQueue.put("remark", "'ID:" + investRecords.getId() + "完成投资");
				noticeQueue.put("serviceName", "investService");

				mqMessageSender.sendMessage("noticeQueue", noticeQueue.toString());

			}
			if (!StringUtil.empty(user) && investRecords.getAmount() >= 2000) {
				TradeInvestRecordsExample ire = new TradeInvestRecordsExample();

				ire.createCriteria().andUserIdEqualTo(user.getId()).andDaysGreaterThan(1)
						.andAmountGreaterThan(20000000L);
				// 判断定期投资是否是首次大于2000元
				int sun = tradeInvestRecordsService.selectCountInvestRecordByCondition(ire);
				int limitDate = DateUtil.getIntervalDays(user.getRealNameAt(), new Date()) - 60;
				// 情况一:实名注册60天内 首次投资单笔满2000(又是首次定投又是定投首次单笔满2000) 5%加息券 积分 均送
				if (limitDate <= 0 && !StringUtil.empty(inviter) && sum == 1 && sun == 1) {
					// 发放5%加息券
					JSONObject couponsGrant = new JSONObject();
					couponsGrant.put("userId", user.getId());
					couponsGrant.put("type", "firstInvest");
					couponsGrant.put("serviceName", "investService");
					mqMessageSender.sendMessage("couponsGrant", couponsGrant.toString());
					// 发送积分
					userService.updateIntegralById(inviter.getId(),
							inviter.getIntegral() + integralSource3.getIntegral(), inviter.getIntegral());

					IntegralRecords integralRecords = new IntegralRecords();
					integralRecords.setUserId(inviter.getId());
					integralRecords.setIntegral(integralSource3.getIntegral());
					integralRecords.setSource("4");
					integralRecords.setUserCurrentIntegral(inviter.getIntegral());
					integralRecords.setRemark(investRecords.getId().toString());
					integralRecordsService.saveIntegralRecords(integralRecords);

					// 加入邀请奖励记录
					userInviteLogsService.insertintUserInviteLogs(user.getInvitedByUserId(), user.getId(),
							user.getPhone(), 3, "5%加息券", integralSource3.getIntegral(),
							investRecords.getId().toString());

					// 站内信
					JSONObject noticeQueue = new JSONObject();
					noticeQueue.put("userId", inviter.getId());
					noticeQueue.put("title", "邀请首投定期");
					noticeQueue.put("info", 6);
					noticeQueue.put("status", 0);
					noticeQueue.put("amount", integralSource3.getIntegral().toString());
					noticeQueue.put("phone", user.getPhone());
					noticeQueue.put("remark", "'ID:" + investRecords.getId() + "完成投资");
					noticeQueue.put("serviceName", "investService");

				}
				// 情况二:实名注册60天内 定投首次单笔满2000(已不是首次定投,是定投首次单笔满2000) 只送5%加息券
				// 不送积分(之前的小于2000的首笔定投已送积分)
				if (limitDate <= 0 && !StringUtil.empty(inviter) && sum > 1 && sun == 1) {
					// 发放5%加息券
					JSONObject couponsGrant = new JSONObject();
					couponsGrant.put("userId", user.getId());
					couponsGrant.put("type", "firstInvest");
					couponsGrant.put("serviceName", "investService");
					mqMessageSender.sendMessage("couponsGrant", couponsGrant.toString());

					// 加入邀请奖励记录
					userInviteLogsService.insertintUserInviteLogs(user.getInvitedByUserId(), user.getId(),
							user.getPhone(), 3, "5%加息券", 0, investRecords.getId().toString());

					// 站内信
					JSONObject noticeQueue = new JSONObject();
					noticeQueue.put("userId", inviter.getId());
					noticeQueue.put("title", "邀请首投定期");
					noticeQueue.put("info", 7);
					noticeQueue.put("status", 0);
					noticeQueue.put("amount", integralSource3.getIntegral().toString());
					noticeQueue.put("phone", user.getPhone());
					noticeQueue.put("remark", "'ID:" + investRecords.getId() + "完成投资");
					noticeQueue.put("serviceName", "investService");

				}

				// 情况三:实名注册>60天 首投定期单笔满2000(是首次定投,是定投首次单笔满2000) 因为过60天 只送积分
				// 不发加息券
				if (limitDate > 0 && !StringUtil.empty(inviter) && sum == 1 && sun == 1) {
					// 发放积分
					userService.updateIntegralById(inviter.getId(),
							inviter.getIntegral() + integralSource3.getIntegral(), inviter.getIntegral());
					IntegralRecords integralRecords = new IntegralRecords();
					integralRecords.setUserId(inviter.getId());
					integralRecords.setIntegral(integralSource3.getIntegral());
					integralRecords.setSource("4");
					integralRecords.setUserCurrentIntegral(inviter.getIntegral());
					integralRecords.setRemark(investRecords.getId().toString());
					integralRecordsService.saveIntegralRecords(integralRecords);
					// 加入邀请奖励记录
					userInviteLogsService.insertintUserInviteLogs(user.getInvitedByUserId(), user.getId(),
							user.getPhone(), 2, null, 0, investRecords.getId().toString());
					// 站内信
					JSONObject noticeQueue = new JSONObject();
					noticeQueue.put("userId", inviter.getId());
					noticeQueue.put("title", "邀请首投定期");
					noticeQueue.put("info", 8);
					noticeQueue.put("status", 0);
					noticeQueue.put("amount", integralSource3.getIntegral().toString());
					noticeQueue.put("phone", user.getPhone());
					noticeQueue.put("remark", "'ID:" + investRecords.getId() + "完成投资");
					noticeQueue.put("serviceName", "investService");

				}

			}

			if (DateUtil.isMembersDay(investRecords.getCreatedAt()) && investRecords.getDays() != 1) {

				integralSource3.setIntegral((investRecords.getDays() * investRecords.getAmount().intValue()) / 1500);
			}

			// 发送积分
			userService.updateIntegralById(user.getId(), user.getIntegral() + integralSource3.getIntegral(),
					user.getIntegral());
			IntegralRecords integralRecords = new IntegralRecords();
			integralRecords.setUserId(user.getId());
			integralRecords.setIntegral(integralSource3.getIntegral());
			integralRecords.setSource(integralSource3.getId().toString());
			integralRecords.setUserCurrentIntegral(user.getIntegral());
			integralRecords.setRemark(investRecords.getId().toString());
			integralRecordsService.saveIntegralRecords(integralRecords);

			IntegralTalentSource talentSource9 = talentSourcesService.selectIntegralTalentSource(9);
			talentSource9
					.setTalent(Short.parseShort(((investRecords.getDays() * investRecords.getAmount()) / 3000) + ""));

			if (talentSource9.getTalent() > 9) {
				userService.updateTalentValueById(user.getId(), user.getTalentValue() + talentSource9.getTalent(),
						user.getTalentValue());
				talentsService.insertChangeTalentValueRecord(user.getId(), Long.parseLong(talentSource9.getTalent().toString()),
						user.getTalentValue(), new Date(), talentSource9.getSourceId());

			}
		}
		// 投资成功发短信
		sendInvestSmsEvent(investRecords);

		// TODO Auto-generated method stub

	}

	public void sendInvestSmsEvent(TradeInvestRecords investRecords) {
		String content = "";
		int month_num = 0;

		JSONObject json = new JSONObject();
		
		if (investRecords.getDays() == 1) {
			content = "恭喜您在天财宝完成一笔活期投资，投资金额" + investRecords.getAmount() + "元，可登录平台查看更多收益。天财宝，正当年【天财宝】";
		} else {
			switch (investRecords.getDays()) {
			case 30:
				month_num = 1;
				break;
			case 90:
				month_num = 3;
				break;
			case 180:
				month_num = 6;
				break;
			case 360:
				month_num = 12;
				break;

			}
			if (investRecords.getDays() > 360) {
				content = "恭喜您在天财宝投资一笔定期，投资金额" + investRecords.getAmount() + "元，到期时间" + investRecords.getExpireDate()
						+ "预计收益" + investRecords.getInterest() + "元。天财宝，正当年【天财宝";
			} else {
				content = "恭喜您在天财宝投资一笔定期" + month_num + "个月，投资金额" + investRecords.getAmount() + "元，到期时间"
						+ investRecords.getExpireDate() + "预计收益" + investRecords.getInterest() + "元。天财宝，正当年【天财宝】";
			}

		}
		Users user = userService.selectUserById(investRecords.getUserId());

		json.put("content", content);
		sendSmsOnMqService.sendSMSOnMq(user.getPhone(), "investService",json);

		// 站内信
		internalMessageService.insertNotice(user.getId(), "投资", content, Byte.parseByte("0"),
				investRecords.getId().toString());

	}

}
