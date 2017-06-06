package com.tiancaibao.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.system.SystemBannersMapper;
import com.tiancaibao.pojo.system.SystemBanners;
import com.tiancaibao.pojo.system.SystemBannersExample;
import com.tiancaibao.service.interfaces.system.ISystemBannerService;

@Service("systemBannerService")
public class SystemBannerServiceImpl implements ISystemBannerService {

	@Resource
	private SystemBannersMapper systemBannersMapper;

	@Override
	public List<SystemBanners> selectBannerListByMarkAndInset(Byte mark, Byte inset) {
		SystemBannersExample sb = new SystemBannersExample();
		sb.createCriteria().andMarkEqualTo(mark).andInsetEqualTo(inset);
		List<SystemBanners> systemBannersList = systemBannersMapper.selectByExample(sb);
		if (systemBannersList != null) {
			return systemBannersList;
		}
		return null;
	}

}
