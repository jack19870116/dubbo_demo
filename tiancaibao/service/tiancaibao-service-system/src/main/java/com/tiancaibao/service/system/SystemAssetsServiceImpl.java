package com.tiancaibao.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.system.SystemAssetsMapper;
import com.tiancaibao.pojo.system.SystemAssets;
import com.tiancaibao.pojo.system.SystemAssetsExample;
import com.tiancaibao.service.interfaces.system.ISystemAssetsService;

@Service("systemService")
public class SystemAssetsServiceImpl implements ISystemAssetsService {

	@Resource
	private SystemAssetsMapper systemAssetsMapper;

	@Override
	public Long selectRateOfSystemAssetRateByDay(int day) {
		SystemAssetsExample sa = new SystemAssetsExample();
		sa.createCriteria().andDaysEqualTo(day);
		List<SystemAssets> salist = systemAssetsMapper.selectByExample(sa);
		if (salist != null) {
			return salist.get(0).getRate();
		}
		return null;
	}

	@Override
	public SystemAssets selectSystemAssetByDay(int days) {
		SystemAssetsExample sa = new SystemAssetsExample();
		sa.createCriteria().andDaysEqualTo(days);
		List<SystemAssets> salist = systemAssetsMapper.selectByExample(sa);
		if (salist != null) {
			return salist.get(0);
		}
		return null;
	}

	@Override
	public SystemAssets selectSystemAssetById(long id) {
		return systemAssetsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveSystemAsset(long amount, long remainAmount, Long rate, String productSign, Integer days) {
		SystemAssets sa = new SystemAssets();
		sa.setAmount(amount);
		sa.setRemainAmount(remainAmount);
		sa.setRate(rate);
		sa.setProductSign(productSign);
		sa.setDays(days);
		systemAssetsMapper.insertSelective(sa);

	}

	@Override
	public void updateSystemAssetsById(String productSign, Long rate, Long id) {
		SystemAssets sa = new SystemAssets();
		sa.setProductSign(productSign);
		sa.setRate(rate);
		systemAssetsMapper.updateByPrimaryKeySelective(sa);

	}

	@Override
	public List<SystemAssets> selectSystemAsset() {
		SystemAssetsExample sa = new SystemAssetsExample();
		List<SystemAssets> salist = systemAssetsMapper.selectByExample(sa);
		if (salist != null) {
			return salist;
		}
		return null;
	}

	@Override
	public List<SystemAssets> selectSystemAssetByNotDay(Integer days) {
		SystemAssetsExample sa = new SystemAssetsExample();
		sa.createCriteria().andDaysNotEqualTo(days);
		List<SystemAssets> salist = systemAssetsMapper.selectByExample(sa);
		if (salist != null) {
			return salist;
		}
		return null;
	}

	@Override
	public int updateRemainAmountByid(Long id, Long remainAmount) {

		SystemAssets sa = new SystemAssets();
		sa.setId(id);
		sa.setRemainAmount(remainAmount);

		// TODO Auto-generated method stub
		return systemAssetsMapper.updateByPrimaryKeySelective(sa);
	}

}
