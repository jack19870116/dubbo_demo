package com.tiancaibao.service.interfaces.system;

import java.util.List;

import com.tiancaibao.pojo.integral.IntegralSources;
import com.tiancaibao.pojo.system.SystemAssets;
import com.tiancaibao.pojo.integral.IntegralTalentSource;

public interface ISystemAssetService {

	Long selectRateOfSystemAssetRateByDay(int day);

	SystemAssets selectSystemAssetByDay(int i);

	SystemAssets selectSystemAssetById(long id);

	IntegralTalentSource selectTalentSourceById(int id);

	IntegralSources selectIntegralSourceById(int id);

	Integer selectCountSystemAssetAddRecordsByRequestNo(String request_no);

	void saveSystemAssetAndSystemAssetAddRecords(Long amount, Integer days, String product_sign, String request_no);

	void addRemainamountByIdAndSaveSystemAssetAddRecords(Long id, Long remainamount, String product_sign, Long amount,
			Integer days, String request_no);

	void saveSystemAsset(long amount, long remain_amount, Long rate, String product_sign, Integer days);

	void updateSystemAssetsById(String product_sign, Long rate, Long id);

	SystemAssets selectSystemAssetById(String product_sign);

	List<SystemAssets> selectSystemAsset();

	List<SystemAssets> selectSystemAssetByNotDay(Integer days);

}
