package com.tiancaibao.service.interfaces.system;

import java.util.List;

import com.tiancaibao.pojo.system.SystemAssets;

public interface ISystemAssetsService {
	/**
	 * 根据产品日期返回产品利率
	 * 
	 * @param day
	 * @return
	 */
	Long selectRateOfSystemAssetRateByDay(int days);

	/**
	 * 根据产品日期返回产品对象
	 * 
	 * @param i
	 * @return
	 */
	SystemAssets selectSystemAssetByDay(int i);

	/**
	 * 根据产品ID返回产品对象
	 * 
	 * @param id
	 * @return
	 */
	SystemAssets selectSystemAssetById(long id);

	/**
	 * 保存产品信息
	 * 
	 * @param amount
	 * @param remain_amount
	 * @param rate
	 * @param product_sign
	 * @param days
	 */
	void saveSystemAsset(long amount, long remainAmount, Long rate, String productSign, Integer days);

	/**
	 * 更新产品表
	 * 
	 * @param product_sign
	 * @param rate
	 * @param id
	 */
	void updateSystemAssetsById(String productSign, Long rate, Long id);

	/**
	 * 更新余额
	 * 
	 * @return
	 */

	int updateRemainAmountByid(Long id, Long remainAmount);

	/**
	 * 返回所有的产品列表
	 * 
	 * @return
	 */
	List<SystemAssets> selectSystemAsset();

	/**
	 * 返回不满足条件的产品
	 * 
	 * @param days
	 * @return
	 */
	List<SystemAssets> selectSystemAssetByNotDay(Integer days);

}
