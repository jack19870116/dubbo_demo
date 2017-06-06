package com.tiancaibao.service.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.user.UserInviteLogsMapper;
import com.tiancaibao.pojo.user.UserInviteLogs;
import com.tiancaibao.service.interfaces.user.IUserInviteLogsService;
@Service("userInviteLogsService")
public class UserInviteLogsServiceImpl implements IUserInviteLogsService {

	@Resource
	UserInviteLogsMapper UserInviteLogsMapper;

	@Override
	public int insertintUserInviteLogs(Long inviter_id, Long be_inviter_id, String name, Integer type,
			String add_conpons_name, Integer add_integral, String remark) {

		UserInviteLogs record = new UserInviteLogs();

		record.setInviterId(inviter_id);
		record.setBeInviterId(be_inviter_id);
		record.setName(name);
		record.setType(type.byteValue());
		record.setAddConponsName(add_conpons_name);
		record.setAddIntegral(add_integral);
		record.setRemark(remark);

		return UserInviteLogsMapper.insert(record);
	}

}
