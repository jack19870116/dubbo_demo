package com.tiancaibao.service.pay;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.constants.ServiceConstants;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.mapper.pay.PaySinaUserInfoMapper;
import com.tiancaibao.pojo.pay.PaySinaUserInfo;
import com.tiancaibao.pojo.pay.PaySinaUserInfoExample;
import com.tiancaibao.service.interfaces.pay.IPaySinaUserInfoService;

/**
 * dubbo服务接口---新浪用户本地信息
 * 
 * @author Mack 2017年2月4日 下午2:23:05
 */
@Service("sinaUserInfoService")
public class PaySinaUserInfoServiceImpl implements IPaySinaUserInfoService {

	@Resource
	private PaySinaUserInfoMapper sinaUserInfoMapper;

	private static final Logger log = LoggerFactory.getLogger(PaySinaUserInfoServiceImpl.class);
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	/**
	 * 暂未实名认证,返回code
	 * 
	 * @author Mack 2017年2月4日 下午2:49:40
	 * @param userId
	 * @return
	 */
	public Integer isRealName(Long userId) {
		PaySinaUserInfoExample suie = new PaySinaUserInfoExample();
		suie.createCriteria().andUserIdEqualTo(userId);
		List<PaySinaUserInfo> sinaUserInfoList = sinaUserInfoMapper.selectByExample(suie);
		if (sinaUserInfoList == null || sinaUserInfoList.size() == 0 || sinaUserInfoList.get(0) == null
				|| sinaUserInfoList.get(0).getPhone() == null) {
			return ServiceConstants.CODE_REALNAME_PHONE;
		} else if (sinaUserInfoList.get(0).getSinapayBankCard() == null) {
			return ServiceConstants.CODE_REALNAME_CARD;
		}
		return ServiceConstants.CODE_REALNAME_ALREADY;
	}

	/**
	 * 查询用户新浪存钱罐余额
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public Long selectSinapayAmountByUserId(Long userId) {
		PaySinaUserInfoExample suie = new PaySinaUserInfoExample();
		suie.createCriteria().andUserIdEqualTo(userId);
		List<PaySinaUserInfo> sinaUserInfoList = sinaUserInfoMapper.selectByExample(suie);
		if (sinaUserInfoList != null && sinaUserInfoList.size() > 0 && sinaUserInfoList.get(0) != null
				&& sinaUserInfoList.get(0).getSinapayAmount() != null) {
			Long amount = sinaUserInfoList.get(0).getSinapayAmount();
			log.info("使用参数userId= " + userId +  " 查询sinaUserInfo 用户余额结果是： " + amount +"; \n" );
			return amount;
		}
		return 0L;
	}

	/**
	 * 用用户ID查询新浪认证表
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public PaySinaUserInfo selectByUserId(Long userId) {
		PaySinaUserInfoExample suie = new PaySinaUserInfoExample();
		suie.createCriteria().andUserIdEqualTo(userId);
		List<PaySinaUserInfo> sinaUserInfoList = sinaUserInfoMapper.selectByExample(suie);
		if (sinaUserInfoList != null && sinaUserInfoList.size() > 0) {
			log.info("根据用户ID userId = " + userId + "查询 PaySinaUserInfo 结果是 = " +sinaUserInfoList.get(0) + ";\n" );
			return sinaUserInfoList.get(0);
		}
		log.info("根据用户ID userId = " + userId + "查询 PaySinaUserInfo 结果是 = " +sinaUserInfoList.get(0) + ";\n" );
		return null;
	}

	/**
	 * 更新新浪用户表
	 * 
	 * @param sinaUserInfo
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateByUserId(PaySinaUserInfo sinaUserInfo) {
		if (sinaUserInfo == null) {
			throw new ServiceException("参数异常");
		}
		PaySinaUserInfo sui = new PaySinaUserInfo();
		sui.setSinapayAmount(sinaUserInfo.getSinapayAmount());
		PaySinaUserInfoExample suie = new PaySinaUserInfoExample();
		suie.createCriteria().andUserIdEqualTo(sinaUserInfo.getUserId());
		sinaUserInfoMapper.updateByExampleSelective(sui, suie);
	}

	/**
	 * 根据用户ID更新新浪用户表存钱罐余额
	 * 
	 * @param queryBalance
	 * @param id
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateSinapayAmountById(Long queryBalance, Long userId) {
		PaySinaUserInfo sui = new PaySinaUserInfo();
		sui.setUserId(userId);
		sui.setSinapayAmount(queryBalance);
		sinaUserInfoMapper.updateByPrimaryKeySelective(sui);
		log.info("根据用户ID userId = " + userId + " 更新新浪存钱罐金额 SinapayAmount ＝ " + queryBalance * 10000 + "；\n");
	}

	/**
	 * 插入新浪用户表
	 * 
	 * @param userId
	 * @param bankCard
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void insertSinaUserInfoSetSinapayBankCardAndUserId1(Long userId, String bankCard) {
		PaySinaUserInfo sui = new PaySinaUserInfo();
		sui.setUserId(userId);
		sui.setSinapayBankCard(bankCard);
		sui.setCreatedAt(new Date());
		sinaUserInfoMapper.insertSelective(sui);
	}

	/**
	 * 根据ID更新用户新浪存钱罐余额
	 * 
	 * @param account_amount
	 * @param id
	 */
	@Transactional
	@Override
	public void updateSinaUserInfoById(Long account_amount, Long id) {
		PaySinaUserInfo sui = new PaySinaUserInfo();
		sui.setId(id);
		sui.setSinapayAmount(account_amount);
		sinaUserInfoMapper.updateByPrimaryKeySelective(sui);
		log.info("根据ID=" + id +"更新用户sinaUserInfo的account_amount =" + account_amount*10000 +"\n");
	}

	/**
	 * 根据用户ID和手机号向新浪用户表中新增一条记录
	 * 
	 * @param userid
	 * @param phone
	 */
	@Transactional
	@Override
	public void insertUserIdAndPhoneToSinaUserInfo(Long userid, String phone) {
		PaySinaUserInfo sui = new PaySinaUserInfo();
		sui.setUserId(userid);
		sui.setPhone(phone);
		sinaUserInfoMapper.insertSelective(sui);
	}

	/**
	 * 根据新浪表ID更新手机号
	 * 
	 * @param phone
	 * @param id
	 */
	@Transactional
	@Override
	public void updateSinaUserInfoSetPhoneById(String phone, Long id) {
		PaySinaUserInfo sui = new PaySinaUserInfo();
		sui.setId(id);
		sui.setPhone(phone);
		sinaUserInfoMapper.updateByPrimaryKeySelective(sui);
	}

	/**
	 * 向新浪用户表插入一条记录
	 * 
	 * @param userid
	 * @param phone
	 */
	@Transactional
	@Override
	public void insertSinaUserInfo(Long userid, String phone) {
		PaySinaUserInfo sui = new PaySinaUserInfo();
		sui.setUserId(userid);
		sui.setPhone(phone);
		sui.setCreatedAt(new Date());
		sinaUserInfoMapper.insertSelective(sui);
	}

	/**
	 * 插入新浪用户表
	 * 
	 * @param userId
	 * @param bankCard
	 */
	@Transactional
	@Override
	public void insertSinaUserInfoSetSinapayBankCardAndUserId(Long userid, String sinapay_bank_card) {
		PaySinaUserInfo sui = new PaySinaUserInfo();
		sui.setUserId(userid);
		sui.setSinapayBankCard(sinapay_bank_card);
		sui.setCreatedAt(new Date());
		sinaUserInfoMapper.insertSelective(sui);
	}

	@Override
	public void insertUserIdAndIdcardToSinaUserInfo(Long userid, String idcardNumber) {
		PaySinaUserInfo sui = new PaySinaUserInfo();
		sui.setUserId(userid);
		sui.setSinaidcardnumber(idcardNumber);
		sui.setCreatedAt(new Date());
		sinaUserInfoMapper.insertSelective(sui);
	}

	@Override
	public int updateIdcardNumberSinaUserInfoById(Long id, String idcardNumber) {
		PaySinaUserInfo sui = new PaySinaUserInfo();
		sui.setId(id);
		sui.setSinaidcardnumber(idcardNumber);
		int updateByPrimaryKeySelective = sinaUserInfoMapper.updateByPrimaryKeySelective(sui);
		return updateByPrimaryKeySelective;
	}

	@Override
	public void insertoSinaUserInfo(Long userid, String phone, String sinapay_bank_card, String card_id) {
		PaySinaUserInfo sui = new PaySinaUserInfo();
		sui.setUserId(userid);
		sui.setPhone(phone);
		sui.setBankPhone(phone);
		sui.setSinapayBankCard(sinapay_bank_card);
		sui.setCardId(card_id);
		sui.setCreatedAt(new Date());
		sui.setUpdatedAt(new Date());
		sinaUserInfoMapper.insertSelective(sui);
		log.info("插入 SinaUserInfo 数据 " + sui + "\n");
	}

	@Override
	public void updateSinaUserInfoBnakCardById(Long id, String bank_card, String phone, String card_id) {
		PaySinaUserInfo sui = new PaySinaUserInfo();
		sui.setId(id);
		sui.setSinapayBankCard(bank_card);
		sui.setPhone(phone);
		sui.setCardId(card_id);
		sinaUserInfoMapper.updateByPrimaryKeySelective(sui);

	}

}
