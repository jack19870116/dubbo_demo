package com.tiancaibao.service.user;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.mapper.user.UserBlackListsMapper;
import com.tiancaibao.mapper.user.UserSignInsMapper;
import com.tiancaibao.mapper.user.UsersMapper;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.pojo.user.UsersExample;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.utils.JedisUtil;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UsersMapper usersMapper;

	@Resource
	private UserSignInsMapper signInsMapper;
	@Resource
	private UserBlackListsMapper blackListsMapper;

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	/**
	 * 不推荐使用 使用token 查询用户ID
	 */
	@Transactional
	@Override
	public Long selectUserIdByToken(String token) {
		UsersExample ue = new UsersExample();
		ue.createCriteria().andRememberTokenEqualTo(token);
		List<Users> usersList = usersMapper.selectByExample(ue);
		if (usersList != null && usersList.size() == 1) {
			log.info("使用token: " + token + "查询数据库结果是：" + usersList.get(0));
			return usersList.get(0).getId();
		} else {
			throw new ServiceException("使用token= " + token + "取到的user为空" + "\n");
		}
	}

	/**
	 * 不推荐使用 使用token 查询用户
	 */
	@Transactional
	@Override
	@Cacheable(value = "UserCache", key = "'User_Token_' + #p0", cacheManager = "userRedisCacheManager")
	public Users selectUserByToken(String token) {
		UsersExample ue = new UsersExample();
		ue.createCriteria().andRememberTokenEqualTo(token);
		List<Users> usersList = usersMapper.selectByExample(ue);
		if (usersList != null && usersList.size() == 1) {
			log.info("使用token: " + token + "查询数据库结果是：" + usersList.get(0));
			return usersList.get(0);
		} else {
			throw new ServiceException("使用token= " + token + "取到的user为空" + "\n");
		}
	}

	/**
	 * 使用手机号 查询用户
	 */
	@Transactional
	@Override
	@Cacheable(value = "UserCache", key = "'User_Phone_' + #p0", cacheManager = "userRedisCacheManager")
	public Users selectUserByPhone(String phone) {
		if (StringUtils.isBlank(phone)) {
			throw new ServiceException("参数异常");
		}
		UsersExample ue = new UsersExample();
		ue.createCriteria().andPhoneEqualTo(phone);
		List<Users> usersList = usersMapper.selectByExample(ue);
		if (usersList != null && usersList.size() == 1) {
			log.info("使用phone= " + phone + "查询数据库结果是：" + usersList.get(0) + "\n");
			return usersList.get(0);
		}
		return null;
	}
	
	/**
	 * 使用weixin open_id 查询用户
	 */
	@Transactional
	@Override
	@Cacheable(value = "UserCache", key = "'User_OpenId_' + #p0", cacheManager = "userRedisCacheManager")
	public Users selectUserByOpenId(String openId) {
		if (StringUtils.isBlank(openId)) {
			throw new ServiceException("参数异常");
		}
		UsersExample ue = new UsersExample();
		ue.createCriteria().andOpenIdEqualTo(openId);
		List<Users> usersList = usersMapper.selectByExample(ue);
		if (usersList != null && usersList.size() == 1) {
			log.info("使用openId= " + openId + "查询数据库结果是：" + usersList.get(0) + "\n");
			return usersList.get(0);
		}
		return null;
	}

	/**
	 * 使用手机号 查询用户ID
	 */
	@Transactional
	@Override
	public Long selectUserIdByPhone(String phone) {
		if (StringUtils.isBlank(phone)) {
			throw new ServiceException("参数异常");
		}
		UsersExample ue = new UsersExample();
		ue.createCriteria().andPhoneEqualTo(phone);
		List<Users> usersList = usersMapper.selectByExample(ue);
		if (usersList != null && usersList.size() == 1) {
			log.info("使用phone= " + phone + "查询数据库结果是：" + usersList.get(0) + "\n");
			return usersList.get(0).getId();
		}
		return null;
	}

	/**
	 * 根据用户ID 查询用户表
	 */
	@Override
	@Cacheable(value = "UserCache", key = "'User_Id_' + #p0", cacheManager = "userRedisCacheManager")
	public Users selectUserById(final Long id) {
		Users user = usersMapper.selectByPrimaryKey(id);
		if (user != null) {
			log.info("使用userId= " + id + "查询数据库结果是：" + user + "\n");
		}
		return user;
	}

	/**
	 * 保存信息进用户表
	 */
	@Transactional
	@Override
	public Long saveToUsers(String phone, String password, Long userinvitedId, int channelId) {
		Users user = new Users();
		user.setIdcardName("");
		user.setAmount(0L);
		user.setFixedAmount(0L);
		user.setAccountAmount(0L);
		user.setIsEncryption(false);
		user.setOpenId("");
		user.setPhone(phone);
		user.setPassword(password);
		user.setTalentValue(60L);
		user.setTradingPassword(password);// 初始交易密码与登录密码相同
		user.setHuifuPassword(password);// 汇付密码
		user.setOneThousandAt(new Date());
		user.setTwoThousandAt(new Date());
		user.setFiveThousandAt(new Date());
		user.setInvitedByUserId(userinvitedId);
		user.setChannelId(channelId);
		user.setCreatedAt(new Date());
		user.setYbBankcard("");
		user.setYbBankinfo("");
		user.setMark(0);
		user.setIsDeal(0);
		user.setIsSend(0);
		user.setIntegral(0);
		user.setSignNum(0);
		user.setIsPromoter((short) 0);
		user.setIp("");
		user.setErrorCount(null);
		user.setIsLocking(null);
		Long sumInsertNumber = usersMapper.insertSelective(user);
		if (sumInsertNumber > 0) {
			log.info("向用户表插入一条记录 phone = " + phone + " password = " + password + " userinvitedId = " + userinvitedId
					+ "channelId = " + channelId + "\n");
			return sumInsertNumber;
		} else {
			log.info("向用户表插入一条记录 phone = " + phone + " password = " + password + " userinvitedId = " + userinvitedId
					+ "channelId = " + channelId + "\n");
			return null;
		}
	}

	/**
	 * 使用用户ID 更新用户表token字段
	 */
	@Transactional
	@Override
	@CacheEvict(value = "UserCache", key = "'User_Id_' + #p0", beforeInvocation = true, cacheManager = "userRedisCacheManager")
	public Boolean updateUserRememberTokenById(Long userId, String token, String oldToken) {
		UsersExample ue = new UsersExample();
		ue.createCriteria().andIdEqualTo(userId).andRememberTokenEqualTo(oldToken);
		Users user = new Users();
		user.setRememberToken(token);
		user.setUpdatedAt(new Date());
		Integer sumUpdateNumber = usersMapper.updateByExampleSelective(user, ue);
		return checkSumUpdateNumber(sumUpdateNumber, userId, "token", token, oldToken);
	}

	/**
	 * 使用用户ID 更新用户密码
	 */
	@Transactional
	@Override
	@CacheEvict(value = "UserCache", key = "'User_Id_' + #p0", beforeInvocation = true, cacheManager = "userRedisCacheManager")
	public Boolean updateUserPasswordById(Long userId, String password, String oldPassword) {
		// 参数校验
		if (StringUtils.isBlank(password)) {
			throw new ServiceException("参数异常执行失败");
		}

		UsersExample ue = new UsersExample();
		ue.createCriteria().andIdEqualTo(userId).andPasswordEqualTo(oldPassword);
		Users user = new Users();
		user.setPassword(password);
		user.setUpdatedAt(new Date());
		Integer sumUpdateNumber = usersMapper.updateByExampleSelective(user, ue);
		return checkSumUpdateNumber(sumUpdateNumber, userId, "password", password, oldPassword);
	}

	/**
	 * 使用用户ID修改登录密码并且把is_encryption置为1
	 */
	@Transactional
	@Override
	@CacheEvict(value = "UserCache", key = "'User_Id_' + #p0", beforeInvocation = true, cacheManager = "userRedisCacheManager")
	public Boolean updateUserPasswordByIdMD5(Long userId, String password, String oldPassword, boolean is_encryption) {
		if (StringUtils.isBlank(password)) {
			throw new ServiceException("参数异常执行失败");
		}

		UsersExample ue = new UsersExample();
		ue.createCriteria().andIdEqualTo(userId).andPasswordEqualTo(oldPassword);
		Users user = new Users();
		user.setPassword(password);
		user.setUpdatedAt(new Date());
		user.setIsEncryption(is_encryption);
		Integer sumUpdateNumber = usersMapper.updateByExampleSelective(user, ue);
		return checkSumUpdateNumber(sumUpdateNumber, userId, "password", password, oldPassword);
	}

	/**
	 * warning:oldInvitedByuserId必须是0，否则更新必定失败 更新用户推荐人
	 */
	@Transactional
	@Override
	@CacheEvict(value = "UserCache", key = "'User_Id_' + #p0", beforeInvocation = true, cacheManager = "userRedisCacheManager")
	public Boolean updateUserSetInvitedById(Long userId, Long invitedByuserId, Long oldInvitedByuserId) {
		UsersExample ue = new UsersExample();
		ue.createCriteria().andIdEqualTo(userId).andInvitedByUserIdEqualTo(oldInvitedByuserId);
		Users user = new Users();
		user.setInvitedByUserId(invitedByuserId);
		user.setUpdatedAt(new Date());
		Integer sumUpdateNumber = usersMapper.updateByExampleSelective(user, ue);
		return checkSumUpdateNumber(sumUpdateNumber, userId, "invitedByuserId", invitedByuserId, 0L);
	}

	/**
	 * 根据用户ID更新用户表
	 */
	@Transactional
	@Override
	@CacheEvict(value = "UserCache", key = "'User_Id_' + #p0", beforeInvocation = true, cacheManager = "userRedisCacheManager")
	public Boolean updateUserById(Long userId, String idcard_name, String idcard_number, String birthday) {
		Users user = new Users();
		user.setId(userId);
		user.setIdcardName(idcard_name);
		user.setIdcardNumber(idcard_number);
		user.setBirthday(birthday);
		user.setRealNameAt(new Date());
		user.setUpdatedAt(new Date());
		Integer sumUpdateNumber = usersMapper.updateByPrimaryKeySelective(user);
		if (sumUpdateNumber == 1) {
			log.info("把userId是: " + userId + "的数剧更新为：" + "idcard_name=" + idcard_name + "idcard_number=" + idcard_number
					+ "birthday=" + birthday + "更新成功！" + "\n");
			return true;
		} else if (sumUpdateNumber == 0) {
			log.error("把userId是: " + userId + "的数剧更新为：" + "idcard_name=" + idcard_name + "idcard_number="
					+ idcard_number + "birthday=" + birthday + "更新失败！" + "\n");
			return false;
		}
		return false;
	}

	/**
	 * 根据用户ID更新天财值
	 */
	@Transactional
	@Override
	@CacheEvict(value = "UserCache", key = "'User_Id_' + #p0", beforeInvocation = true, cacheManager = "userRedisCacheManager")
	public Boolean updateTalentValueById(Long userId, Long talentValue, Long oldTalentValue) {
		UsersExample ue = new UsersExample();
		ue.createCriteria().andIdEqualTo(userId).andTalentValueEqualTo(oldTalentValue);
		Users user = new Users();
		user.setTalentValue(talentValue);
		Integer sumUpdateNumber = usersMapper.updateByExampleSelective(user, ue);
		return checkSumUpdateNumber(sumUpdateNumber, userId, "talentValue", talentValue, oldTalentValue);
	}

	/**
	 * 根据用户ID更新积分
	 */
	@Transactional
	@Override
	@CacheEvict(value = "UserCache", key = "'User_Id_' + #p0", beforeInvocation = true, cacheManager = "userRedisCacheManager")
	public Boolean updateIntegralById(Long userId, Integer integral, Integer oldIntegral) {
		UsersExample ue = new UsersExample();
		ue.createCriteria().andIdEqualTo(userId).andIntegralEqualTo(oldIntegral);
		Users user = new Users();
		user.setIntegral(integral);
		Integer sumUpdateNumber = usersMapper.updateByExampleSelective(user, ue);
		return checkSumUpdateNumber(sumUpdateNumber, userId, "integral", integral, oldIntegral);
	}

	/**
	 * 根据用户ID更新活期金额
	 */
	@Transactional
	@Override
	@CacheEvict(value = "UserCache", key = "'User_Id_' + #p0", beforeInvocation = true, cacheManager = "userRedisCacheManager")
	public Boolean updateUserCurrentAmountById(Long userId, Long curramount, Long oldCurrentAmount) {
		UsersExample ue = new UsersExample();
		ue.createCriteria().andIdEqualTo(userId).andAmountEqualTo(oldCurrentAmount);
		Users user = new Users();
		user.setAmount(curramount);
		user.setUpdatedAt(new Date());
		Integer sumUpdateNumber = usersMapper.updateByExampleSelective(user, ue);
		return checkSumUpdateNumber(sumUpdateNumber, userId, "curramount", curramount, oldCurrentAmount);
	}

	/**
	 * 根据用户ID更新定期金额
	 */
	@Transactional
	@Override
	@CacheEvict(value = "UserCache", key = "'User_Id_' + #p0", beforeInvocation = true, cacheManager = "userRedisCacheManager")
	public Boolean updateUserFixedAmountById(Long userId, Long fixedamount, Long oldFixedAmount) {
		UsersExample ue = new UsersExample();
		ue.createCriteria().andIdEqualTo(userId).andFixedAmountEqualTo(oldFixedAmount);
		Users user = new Users();
		user.setFixedAmount(fixedamount);
		user.setUpdatedAt(new Date());
		Integer sumUpdateNumber = usersMapper.updateByExampleSelective(user, ue);
		return checkSumUpdateNumber(sumUpdateNumber, userId, "fixedamount", fixedamount, oldFixedAmount);
	}

	/**
	 * 根据用户ID更新OPENID
	 */
	@Transactional
	@Override
	@CacheEvict(value = "UserCache", key = "'User_Id_' + #p0", beforeInvocation = true, cacheManager = "userRedisCacheManager")
	public Boolean updateOpenIdById(Long userId, String open_id, String old_open_id) {
		UsersExample ue = new UsersExample();
		ue.createCriteria().andIdEqualTo(userId).andOpenIdEqualTo(old_open_id);
		Users user = new Users();
		user.setOpenId(open_id);
		user.setUpdatedAt(new Date());
		Integer sumUpdateNumber = usersMapper.updateByPrimaryKeySelective(user);
		return checkSumUpdateNumber(sumUpdateNumber, userId, "open_id", open_id, old_open_id);
	}

	/**
	 * 获取所有用户的活期金额
	 */
	@Override
	@Cacheable(value = "UserCache", key = "'User_CurrentAmount_' + #result", unless = "#result < 1", cacheManager = "userRedisCacheManager")
	public Long sumCurrentAmount() {
		Long sumCurrentAmount = usersMapper.sumCurrentAmount();
		log.info("当前总活期总金额是: " + sumCurrentAmount + "\n");
		return sumCurrentAmount;
	}

	/**
	 * 获取总用户注册数
	 */
	@Override
	@Cacheable(value = "UserCache", key = "'User_sumUser_' + #result", unless = "#result < 1", cacheManager = "userRedisCacheManager")
	public Integer selectRegisterCount() {
		UsersExample ue = new UsersExample();
		Integer userCount = usersMapper.countByExample(ue);
		log.info("当前总注册人数是: " + userCount + "\n");
		return userCount;
	}

	/**
	 * TODO 获取所有用户的定期金额
	 */
	@Override
	@Cacheable(value = "UserCache", key = "'User_sumFixedAmount_' + #result", unless = "#result < 1", cacheManager = "userRedisCacheManager")
	public Long sumFixedAmount() {
		Long sumFixedAmount = usersMapper.sumFixedAmount();
		log.info("当前总定期总金额是: " + sumFixedAmount + "\n");
		return sumFixedAmount;
	}

	/**
	 * 清除所有的用户缓存，非必要时不得使用
	 */
	@CacheEvict(value = "UserCache", allEntries = true, beforeInvocation = true, cacheManager = "userRedisCacheManager")
	public Boolean clearAllUserCache() {
		log.info("清除所有的用户缓存！！！" + "\n");
		return true;
	}

	private Boolean checkSumUpdateNumber(Integer sumUpdateNumber, Long userId, String updateStringName,
			String newUpdateData, String oldUpdateDate) {
		if (sumUpdateNumber == 1) {
			log.info("把userId是: " + userId + "的数剧更新为：" + updateStringName + "=" + newUpdateData + "更新成功，更新前的数据为"
					+ updateStringName + "=" + oldUpdateDate);
			return true;
		} else if (sumUpdateNumber == 0) {
			log.error("把userId = " + userId + "的数剧更新为：" + updateStringName + "=" + newUpdateData + "更新前的数据为"
					+ updateStringName + "=" + oldUpdateDate + "原因：可能是旧数据不符！" + "\n");
			return false;
		}
		return false;
	}
	
	public Boolean clearUserCache(Users user) {
		log.info("清除用户缓存！！！" + "\n");
		//清除缓存
		JedisUtil.getJedis().del("User_Token_" + user.getRememberToken());
		JedisUtil.getJedis().del("User_Phone_" + user.getPhone());
		JedisUtil.getJedis().del("User_Id_" + user.getId());
		JedisUtil.getJedis().del("User_OpenId_" + user.getOpenId());	
		return true;
	}
	
	

	private Boolean checkSumUpdateNumber(Integer sumUpdateNumber, Long userId, String updateStringName,
			Long newUpdateData, Long oldUpdateDate) {
		if (sumUpdateNumber == 1) {
			log.info("把userId是: " + userId + "的数剧更新为：" + updateStringName + "=" + newUpdateData + "更新成功，更新前的数据为"
					+ updateStringName + "=" + oldUpdateDate);
			return true;
		} else if (sumUpdateNumber == 0) {
			log.error("把userId = " + userId + "的数剧更新为：" + updateStringName + "=" + newUpdateData + "更新前的数据为"
					+ updateStringName + "=" + oldUpdateDate + "原因：可能是旧数据不符！" + "\n");
			return false;
		}
		return false;
	}

	private Boolean checkSumUpdateNumber(Integer sumUpdateNumber, Long userId, String updateStringName,
			Integer newUpdateData, Integer oldUpdateDate) {
		if (sumUpdateNumber == 1) {
			log.info("把userId是: " + userId + "的数剧更新为：" + updateStringName + "=" + newUpdateData + "更新成功，更新前的数据为"
					+ updateStringName + "=" + oldUpdateDate + "\n");
			return true;
		} else if (sumUpdateNumber == 0) {
			log.error("把userId = " + userId + "的数剧更新为：" + updateStringName + "=" + newUpdateData + "更新前的数据为"
					+ updateStringName + "=" + oldUpdateDate + "原因：可能是旧数据不符！" + "\n");
			return false;
		}
		return false;
	}

	@Transactional
	@Override
	public Long saveToUsers(Users users) {
		users.setIdcardName("");
		users.setAmount(0L);
		users.setFixedAmount(0L);
		users.setAccountAmount(0L);
		users.setIsEncryption(false);
		users.setOpenId("");
		users.setTradingPassword(users.getPassword());// 初始交易密码与登录密码相同
		users.setHuifuPassword(users.getPassword());// 汇付密码
		users.setCreatedAt(new Date());
		users.setYbBankcard("");
		users.setYbBankinfo("");
		users.setMark(0);
		users.setIsDeal(0);
		users.setIsSend(0);
		users.setIntegral(0);
		users.setSignNum(0);
		users.setIsPromoter((short) 0);
		users.setErrorCount(null);
		users.setIsLocking(null);
		Long sumInsertNumber = usersMapper.insertSelective(users);
		if (sumInsertNumber > 0) {
			log.info("向用户表插入一条记录成功 phone = " + users.getPhone() + " password = " + users.getPassword()
					+ " userinvitedId = " + users.getInvitedByUserId() + "channelId = " + users.getChannelId());
			return sumInsertNumber;
		} else {
			log.info("向用户表插入一条记录失败 phone = " + users.getPhone() + " password = " + users.getPassword()
					+ " userinvitedId = " + users.getInvitedByUserId() + "channelId = " + users.getChannelId() + "\n");
			return null;
		}
	}

	/**
	 * 根据用户ID更新其中某一个值
	 */
	@Transactional
	@Override
	@CacheEvict(value = "UserCache", key = "'User_Id_' + #p0", beforeInvocation = true, cacheManager = "userRedisCacheManager")
	public Boolean updateUsersById(Users users) {
		Integer sumUpdateNumber = usersMapper.updateByPrimaryKeySelective(users);
		if (sumUpdateNumber == 1) {
			return true;
		} else if (sumUpdateNumber == 0) {
			return false;
		}
		return false;
	}

	/**
	 * 更新单标总额
	 */
	@Override
	public int updateUserTenderAmountById(Long userId, Long tenderAmount) {
		Users users = usersMapper.selectByPrimaryKey(userId);
		long amount = users.getTenderAmount() + tenderAmount;
		Users record = new Users();
		record.setId(userId);
		record.setTenderAmount(amount);
		return usersMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 更新用户的积分
	 */
	@Override
	public int updateIntegralAndSignNum(Long id, int integral, int signNum) {
		Users record = new Users();
		record.setId(id);
		record.setIntegral(integral);
		record.setSignNum(signNum);
		return usersMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateUserAmount(Long userId, Long amount) {

		Users record = new Users();

		UsersExample example = new UsersExample();

		example.createCriteria().andIdEqualTo(userId);

		record.setId(userId);
		record.setFixedAmount(amount);
		return usersMapper.updateByExampleSelective(record, example);

	}

}
