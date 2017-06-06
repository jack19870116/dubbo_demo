package com.tiancaibao.service.activity;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.mapper.activity.ActivityLotteryBillMapper;
import com.tiancaibao.mapper.activity.ActivityLotteryMapper;
import com.tiancaibao.mapper.activity.ActivityMapper;
import com.tiancaibao.mapper.coupons.CouponsCurrentInterestratesCouponsMapper;
import com.tiancaibao.mapper.coupons.CouponsFixedCashCouponsMapper;
import com.tiancaibao.mapper.integral.IntegralRecordsMapper;
import com.tiancaibao.mapper.integral.IntegralTalentRecordsMapper;
import com.tiancaibao.mapper.trade.TradeInvestRecordsMapper;
import com.tiancaibao.mapper.user.UsersMapper;
import com.tiancaibao.pojo.activity.Activity;
import com.tiancaibao.pojo.activity.ActivityExample;
import com.tiancaibao.pojo.activity.ActivityExample.Criteria;
import com.tiancaibao.pojo.activity.ActivityLottery;
import com.tiancaibao.pojo.activity.ActivityLotteryBill;
import com.tiancaibao.pojo.activity.ActivityLotteryBillExample;
import com.tiancaibao.pojo.activity.ActivityLotteryExample;
import com.tiancaibao.pojo.coupons.CouponsCurrentInterestratesCoupons;
import com.tiancaibao.pojo.coupons.CouponsFixedCashCoupons;
import com.tiancaibao.pojo.integral.IntegralRecords;
import com.tiancaibao.pojo.integral.IntegralTalentRecords;
import com.tiancaibao.pojo.trade.TradeInvestRecords;
import com.tiancaibao.pojo.trade.TradeInvestRecordsExample;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.activity.IActivityService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.RandomUtil;

@Service("activityService")
public class ActivityServiceImpl implements IActivityService {

	private static Logger logger = Logger.getLogger(ActivityServiceImpl.class);
	@Resource
	private ActivityMapper activesMapper;
	@Resource
	private TradeInvestRecordsMapper investRecordsMapper;
	@Resource
	private ActivityLotteryBillMapper lotteryBillMapper;
	@Resource
	private ActivityLotteryMapper lotteryMapper;
	@Resource
	private UsersMapper usersMapper;
	@Resource
	private IntegralTalentRecordsMapper changeTalentValueRecordsMapper;
	@Resource
	private CouponsFixedCashCouponsMapper cashCouponsMapper;
	@Resource
	private IntegralRecordsMapper integralRecordsMapper;
	@Resource
	private CouponsCurrentInterestratesCouponsMapper addInterestCouponsMapper;
	// @Resource
	// private JmsTemplate jmsTemplate;

	@Transactional
	@Override
	public void isValidActive() {
		ActivityExample ae = new ActivityExample();
		Criteria cc = ae.createCriteria();
		cc.andNameEqualTo("九宫格抽奖");
		cc.andIsCloseEqualTo(0);
		cc.andEndTimeGreaterThan(DateUtil.getDayStartDate());
		cc.andStartTimeLessThanOrEqualTo(DateUtil.getDayStartDate());
		List<Activity> activesList = activesMapper.selectByExample(ae);
		if (activesList == null || activesList.get(0) == null) {
			throw new ServiceException("该活动未开始或已结束!");
		}
	}

	@Transactional
	@Override
	public void isUserHaveQualification(Long userid) {
		TradeInvestRecordsExample ire = new TradeInvestRecordsExample();
		ire.createCriteria().andUserIdEqualTo(userid).andDaysGreaterThan(1);
		List<TradeInvestRecords> irList = investRecordsMapper.selectByExample(ire);
		if (irList == null || irList.get(0) == null) {
			throw new ServiceException("您需要完成实名认证，并且在抽奖之前，有至少一笔定期投资记录，才符合活动条件。");
		}
	}

	@Transactional
	@Override
	public void isAlreadyAttendToday(Long userid) {
		ActivityLotteryBillExample lbe = new ActivityLotteryBillExample();
		lbe.createCriteria().andUserIdEqualTo(userid).andCreatedAtGreaterThanOrEqualTo(DateUtil.getDayStartDate());
		;
		List<ActivityLotteryBill> lbeList = lotteryBillMapper.selectByExample(lbe);
		if (lbeList == null || lbeList.get(0) == null) {
			throw new ServiceException("明天再来抽奖吧!");
		}
	}

	@Transactional
	@Override
	public ActivityLottery extractRandomPrize() {
		// 查询所有的奖项
		ActivityLotteryExample le = new ActivityLotteryExample();
		le.createCriteria().andValidEqualTo((byte) 1);
		List<ActivityLottery> lotteryList = lotteryMapper.selectByExample(le);
		if (lotteryList == null) {
			throw new ServiceException("对不起,现在没有奖品");
		}
		// 取一个随机下标
		int index = RandomUtil.getIndexList(lotteryList.size());
		ActivityLottery prize = lotteryList.get(index);// 抽取的奖品
		return prize;
	}

	@Transactional
	@Override
	public void savePrize(Users user, ActivityLottery prize) {
		ActivityLotteryBill lb = new ActivityLotteryBill();
		lb.setUserId(user.getId());
		lb.setGoodsId(prize.getId().intValue());
		lb.setGoodsName(prize.getGoodsName());
		lb.setCreatedAt(new Date());
		lotteryBillMapper.insertSelective(lb);
		switch (prize.getGoodsName()) {
		case "天才值30 *1":
			addTalentValue(user, 30L);
			break;
		case "天才值50 *1":
			addTalentValue(user, 50L);
			break;
		case "红包50元 *1":
			addCoupons(user.getId(), 50L, 25000);
			break;
		case "红包30元 *1":
			addCoupons(user.getId(), 30L, 15000);
			break;
		case "积分 *50":
			addIntegral(user, 50);
			break;
		case "加息券 1% *1":
			addInterest(user.getId(), 1L);
			break;
		case "加息券 2% *1":
			addInterest(user.getId(), 2L);
			break;
		case "保暖触屏手套 *1":
			// 给中实物的用户发送短信
			sendSMS(user.getPhone());
			break;
		case "每日坚果 *1":
			// 给中实物的用户发送短信
			sendSMS(user.getPhone());
			break;
		default:
			break;
		}

	}

	/**
	 * 增加积分
	 * 
	 * @param user
	 * @param integral
	 */
	public void addIntegral(Users user, Integer integral) {
		user.setIntegral(user.getIntegral() + integral);
		user.setUpdatedAt(new Date());
		usersMapper.updateByPrimaryKeySelective(user);
		IntegralRecords ir = new IntegralRecords();
		ir.setUserId(user.getId());
		ir.setShopindentId(0);
		ir.setSource(String.valueOf(7));
		ir.setUserCurrentIntegral(user.getIntegral());
		ir.setIntegral(integral);
		ir.setCreatedAt(new Date());
		integralRecordsMapper.insertSelective(ir);
	}

	/**
	 * 增加天财值
	 * 
	 * @param user
	 * @param value
	 */
	public void addTalentValue(Users user, Long value) {
		user.setTalentValue(user.getTalentValue() + value);
		user.setUpdatedAt(new Date());
		usersMapper.updateByPrimaryKeySelective(user);
		IntegralTalentRecords ctvr = new IntegralTalentRecords();
		ctvr.setUserId(user.getId());
		ctvr.setValue(value);
		ctvr.setDate(new Date()); // 确认此字段赋值多少
		ctvr.setUserCurrentValue(user.getTalentValue());
		ctvr.setCreatedAt(new Date());
		changeTalentValueRecordsMapper.insertSelective(ctvr);
	}

	/**
	 * 增加红包
	 * 
	 * @param userid
	 * @param value
	 */
	public void addCoupons(Long userid, Long value, Integer condition) {
		CouponsFixedCashCoupons cc = new CouponsFixedCashCoupons();
		cc.setUserId(userid);
		cc.setValue(value);
		// cc.setCondition(condition);
		cc.setStatus("AVAILABLE");
		cc.setStartline(new Date());
		cc.setDeadline(DateUtil.afterNDay(new Date(), 15));
		// cc.setSource(6L);
		cc.setCreatedAt(new Date());
		cc.setDays(0); // 确认此处字段赋值情况
		cashCouponsMapper.insertSelective(cc);
	}

	/**
	 * 加息券 value% *1
	 * 
	 * @param userid
	 * @param value
	 */
	public void addInterest(Long userid, Long value) {
		CouponsCurrentInterestratesCoupons ai = new CouponsCurrentInterestratesCoupons();
		ai.setUserId(userid);
		ai.setValue(value);
		ai.setStatus("AVAILABLE");
		ai.setStartline(new Date());
		ai.setDeadline(DateUtil.afterNDay(new Date(), 15));
		ai.setSource("6");
		ai.setCreatedAt(new Date());
		addInterestCouponsMapper.insertSelective(ai);
	}

	/**
	 * 实物发送短信
	 * 
	 * @param phone
	 */
	public void sendSMS(final String phone) {
		// 发送短信消息队列
		// NoticeSendSMS sms = new NoticeSendSMS();
		// sms.setPhone(phone);
		// sms.setType(SMS.SMS_TYPE_ACTIVITY);
		// final String smsjson = JSONObject.toJSONString(sms);
		// jmsTemplate.send(new MessageCreator() {
		// @Override
		// public Message createMessage(Session session) throws JMSException {
		// TextMessage textMessage = session.createTextMessage(smsjson);
		// logger.info("抽奖成功发送短信,手机号:" + phone);
		// return textMessage;
		// }
		// });
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public Activity selectActiveByNameAndIsClose(String name, Integer is_close) {
		ActivityExample ae = new ActivityExample();
		ae.createCriteria().andNameEqualTo(name).andIsCloseEqualTo(is_close);
		List<Activity> alist = activesMapper.selectByExample(ae);
		if (alist != null && alist.size() > 0) {
			return alist.get(0);
		}
		return null;
	}

}
