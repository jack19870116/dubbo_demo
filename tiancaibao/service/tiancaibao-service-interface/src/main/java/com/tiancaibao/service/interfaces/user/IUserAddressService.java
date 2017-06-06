package com.tiancaibao.service.interfaces.user;

import java.util.List;

import com.tiancaibao.pojo.user.UserAddresses;


public interface IUserAddressService {
	
	
	/**
	 * 根据用户ID查询用户收货地址
	 * @param userid
	 * @return
	 */
	public List<UserAddresses> selectUserAddressListByUserIdOrder(Long userid);

	/**
	 * 获取默认收货地址
	 * @param userid
	 * @return
	 */
	public UserAddresses selectDefaultAddressByUserId(Long userid);
	
	/**
	 * 更新默认收货地址
	 * @param userid
	 * @return
	 */
	public void updateAddressIsDefaultById(Integer addressId, boolean is_default);
	
	/**
	 * 插入新的默认收货地址
	 * @param userid
	 * @return
	 */
	public void insertUserAddress(String name, String address, Long userid, String phone, Boolean is_default);
	
	/**
	 * 根据用户ID和收货地址ID返回收货地址记录并排序
	 * @param userid
	 * @return
	 */
	public UserAddresses selectUserAddressByUserIdAndAddressIdOrderByIsDefault(Long userId, Integer address_id) ;
	
	/**
	 * 根据用户ID和收货地址ID返回收货地址记录
	 * @param userid
	 * @return
	 */
	public UserAddresses selectUserAddressByUserIdAndAddressId(Long userid, Integer address_id);
	
	/**
	 * 根据收货地址ID 更新收货地址记录
	 * @param userid
	 * @return
	 */
	public void updateAddressById(Integer addressId, String phone, String address, Boolean is_default, String name);
	
	/**
	 * 根据收货地址ID删除记录
	 * @param addressId
	 */
	public void deleteAddressById(Integer addressId);
}
