package com.tiancaibao.controller.core.sinauserinfo;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.tiancaibao.constants.ServiceConstants;
import com.tiancaibao.constants.TCB;
import com.tiancaibao.exception.ControllerException;
import com.tiancaibao.pojo.SinaUserInfo;
import com.tiancaibao.sinauserinfo.service.SinaUserInfoService;

@Controller
public class SinaUserInfoController {

	@Resource
	private SinaUserInfoService sinaUserInfoService;
	
	public void validateRealName(Long userId) {
		Integer realNameCode = sinaUserInfoService.isRealName(userId);
		if (ServiceConstants.CODE_REALNAME_PHONE.equals(realNameCode)) {
			throw new ControllerException(TCB.NOT_REAL_NAME);
		}
		if (ServiceConstants.CODE_REALNAME_CARD.equals(realNameCode)) {
			throw new ControllerException(TCB.NOT_BIND_CARD);
		}

	}

	public void updateSinaUserInfoByUserId(Long sinaBalance, Long userId) {
		SinaUserInfo sui = new SinaUserInfo();
		sui.setSinapayAmount(sinaBalance);
		sui.setUserId(userId);
		sinaUserInfoService.updateByUserId(sui);
	}
}
