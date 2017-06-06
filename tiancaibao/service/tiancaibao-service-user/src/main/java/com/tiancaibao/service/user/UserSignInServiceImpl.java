package com.tiancaibao.service.user;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.tiancaibao.mapper.user.UserSignInsMapper;
import com.tiancaibao.mapper.user.UsersMapper;
import com.tiancaibao.pojo.user.UserSignIns;
import com.tiancaibao.pojo.user.UserSignInsExample;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.pojo.user.UserSignInsExample.Criteria;
import com.tiancaibao.service.interfaces.user.IUserSignInService;
import com.tiancaibao.utils.DateUtil;

@Service("signInService")
public class UserSignInServiceImpl implements IUserSignInService {

	@Resource
	private UserSignInsMapper signInsMapper;

	@Resource
	private UsersMapper usersMapper;

	@Override
	public void insertTableSignIns(Long userId) {
		try {
			UserSignIns si = new UserSignIns();
			si.setUserId(userId);
			si.setSignDate(new Date());
			si.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			si.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			signInsMapper.insertSelective(si);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUserForUserSignIn(Long userId, Integer integralrecordIntegral, Integer userIntegral,
			Integer signNum) {
		Users user = new Users();
		user.setId(userId);
		user.setIntegral(userIntegral + integralrecordIntegral);
		user.setSignNum(signNum);
		user.setUpdatedAt(new Date());
		usersMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<UserSignIns> selectSignInListByUserIdAndCreateAtOrderByCreateAt(Long userid, String order,
			String month) {
		UserSignInsExample si = new UserSignInsExample();
		si.setFields("sign_date");
		Criteria criteria = si.createCriteria();
		criteria.andUserIdEqualTo(userid);
		if ("current".equals(month)) {
			criteria.andCreatedAtBetween(DateUtil.getMonthStartDate(), DateUtil.getMonthEndDate());
		}
		if ("last".equals(month)) {
			criteria.andCreatedAtBetween(DateUtil.getLastMonthStartDate(), DateUtil.getLastMonthEndDate());
		}
		si.setOrderByClause("created_at " + order);
		return signInsMapper.selectByExample(si);
	}

	@Override
	public UserSignIns selectSignInByUserIdAndOrderByCreateAtFirst(Long userId, String orderBy) {
		UserSignInsExample sie = new UserSignInsExample();
		sie.setOrderByClause("created_at " + orderBy);
		sie.createCriteria().andUserIdEqualTo(userId);
		List<UserSignIns> signinlist = signInsMapper.selectByExample(sie);
		if (signinlist != null && signinlist.size() > 0) {
			return signinlist.get(0);
		}
		return null;
	}

	@Override
	public Integer selectSignInCountByUserId(Long userId) {
		UserSignInsExample sie = new UserSignInsExample();
		sie.createCriteria().andUserIdEqualTo(userId);
		return signInsMapper.countByExample(sie);
	}

	public Boolean selectUserIsSignInByUserId(Long userId) {
		List<UserSignIns> usiList = null;
		try {
			String dateStr = DateUtil.formatDateByFormat(new Date(), DateUtil.DATE_FORMAT);
			UserSignInsExample usie = new UserSignInsExample();
			usie.createCriteria().andUserIdEqualTo(userId)
					.andSignDateEqualTo(new SimpleDateFormat(DateUtil.DATE_FORMAT).parse(dateStr));
			usiList = signInsMapper.selectByExample(usie);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (usiList != null && usiList.size() > 0) {
			return true; // 已签到
		}
		return false; // 未签到
	}
}
