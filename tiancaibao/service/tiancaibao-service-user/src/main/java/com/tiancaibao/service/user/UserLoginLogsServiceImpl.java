package com.tiancaibao.service.user;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.user.UserLoginLogsMapper;
import com.tiancaibao.pojo.user.UserLoginLogs;
import com.tiancaibao.pojo.user.UserLoginLogsExample;
import com.tiancaibao.service.interfaces.user.IUserLoginLogsService;
import com.tiancaibao.utils.DateUtil;

@Service("loginLogService")
public class UserLoginLogsServiceImpl implements IUserLoginLogsService {
	
	@Resource
	private UserLoginLogsMapper userLoginLogsMapper;
	
	/**
	 * 使用用户ID 设备号查询登陆记录 更新用户密码
	 * @param userid
	 * @param agent_num
	 * @return
	 */
	@Transactional
	@Override
	public UserLoginLogs selectUserLoginLogsByuserIdAndAgentNum(Long userid, String agent_num) {
		UserLoginLogsExample ull = new UserLoginLogsExample();
		ull.setYearmonth(DateUtil.currentYearMonth());
		ull.createCriteria().andUserIdEqualTo(userid).andAgentNumEqualTo(agent_num);
		List<UserLoginLogs> ullList = userLoginLogsMapper.selectByExample(ull);
		if (ullList != null && ullList.size() == 1) {
			return ullList.get(0);
		}
		return null;
	}
	
	/**
	 * 保存用户登陆信息
	 * @param userid
	 * @param agent_num
	 * @param source
	 * @param system
	 * @param token
	 */
	@Transactional
	@Override
	public void saveUserLoginLogs(Long userid, String agent_num, String source, String system, String token) {
		UserLoginLogs userLoginLogs = new UserLoginLogs();
		userLoginLogs.setUserId(userid);
		userLoginLogs.setAgentNum(agent_num);
		userLoginLogs.setSource(source);
		userLoginLogs.setSystem(system);
		userLoginLogs.setRememberToken(token);
		// 设置年月，操作动态表
		userLoginLogs.setYearmonth(DateUtil.currentYearMonth());
		userLoginLogs.setCreatedAt(new Date());
		userLoginLogsMapper.insertSelective(userLoginLogs);
	}
	
	/**
	 * 更新用户登陆信息
	 * @param token
	 * @param system
	 * @param id
	 */
	@Transactional
	@Override
	public void updateUserLoginLogsById(String token, String system, Long id) {
		UserLoginLogs userLoginLogs = new UserLoginLogs();
		userLoginLogs.setId(id);
		userLoginLogs.setUpdatedAt(new Date());
		userLoginLogs.setRememberToken(token);
		userLoginLogs.setSystem(system);
		// 设置年月，操作动态表
		userLoginLogs.setYearmonth(DateUtil.currentYearMonth());
		userLoginLogs.setUpdatedAt(new Date());
		userLoginLogsMapper.updateByPrimaryKeySelective(userLoginLogs);
	}
}
