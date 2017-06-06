package com.tiancaibao.service.user;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.user.UserAddressesMapper;
import com.tiancaibao.pojo.user.UserAddresses;
import com.tiancaibao.pojo.user.UserAddressesExample;
import com.tiancaibao.service.interfaces.user.IUserAddressService;

@Service("userAddressService")
public class UserAddressServiceImpl implements IUserAddressService {

	@Resource
	private UserAddressesMapper userAddressesMapper;

	/**
	 * 根据用户ID查询用户收货地址
	 */
	@Transactional
	@Override
	public List<UserAddresses> selectUserAddressListByUserIdOrder(Long userid) {
		UserAddressesExample uae = new UserAddressesExample();

		uae.createCriteria().andUserIdEqualTo(userid.intValue()).andDeletedAtIsNull();
		// 添加or条件
		// Criteria createCriteria = uae.createCriteria();
		// createCriteria.andUserIdEqualTo(userid.intValue()).andDeletedAtIsNotNull();
		//
		// uae.or(createCriteria);
		return userAddressesMapper.selectByExample(uae);
	}

	/**
	 * 获取默认收货地址
	 * 
	 * @param userid
	 * @return
	 */

	@Transactional
	@Override
	public UserAddresses selectDefaultAddressByUserId(Long userid) {
		UserAddressesExample uae = new UserAddressesExample();
		uae.createCriteria().andUserIdEqualTo(userid.intValue()).andIsDefaultEqualTo("true");
		List<UserAddresses> uaelist = userAddressesMapper.selectByExample(uae);
		if (uaelist != null) {
			return uaelist.get(0);
		}
		return null;
	}

	/**
	 * 更新默认收货地址
	 * 
	 * @param userid
	 * @return
	 */
	@Transactional
	@Override
	public void updateAddressIsDefaultById(Integer addressId, boolean is_default) {
		// 查出这个地址全部信息
		UserAddresses selectByPrimaryKey = userAddressesMapper.selectByPrimaryKey(addressId);

		// 更改这个地址所有人所属的默认地址为非默认地址
		UserAddressesExample example = new UserAddressesExample();
		example.createCriteria().andUserIdEqualTo(selectByPrimaryKey.getUserId()).andIsDefaultEqualTo("true");
		UserAddresses record = new UserAddresses();
		record.setIsDefault("false");
		userAddressesMapper.updateByExampleSelective(record, example);

		// 设置该ID地址为默认地址
		UserAddresses userAddress = new UserAddresses();
		userAddress.setAddressId(addressId);
		userAddress.setIsDefault(is_default + "");
		userAddressesMapper.updateByPrimaryKeySelective(userAddress);
	}

	/**
	 * 插入新的默认收货地址
	 * 
	 * @param userid
	 * @return
	 */
	@Transactional
	@Override
	public void insertUserAddress(String name, String address, Long userid, String phone, Boolean is_default) {
		UserAddresses userAddress = new UserAddresses();
		userAddress.setName(name);
		userAddress.setAddress(address);
		userAddress.setUserId(userid.intValue());
		userAddress.setPhone(phone);
		userAddress.setIsDefault(is_default + "");
		userAddressesMapper.insertSelective(userAddress);
	}

	/**
	 * 根据用户ID和收货地址ID返回收货地址记录并排序
	 * 
	 * @param userid
	 * @return
	 */
	@Transactional
	@Override
	public UserAddresses selectUserAddressByUserIdAndAddressIdOrderByIsDefault(Long userId, Integer address_id) {
		UserAddressesExample uae = new UserAddressesExample();
		uae.setOrderByClause("is_default asc");
		uae.createCriteria().andUserIdEqualTo(userId.intValue()).andAddressIdEqualTo(address_id);
		List<UserAddresses> userAddresseslist = userAddressesMapper.selectByExample(uae);
		if (userAddresseslist != null && userAddresseslist.size() == 1) {
			return userAddresseslist.get(0);
		}
		return null;
	}

	/**
	 * 根据用户ID和收货地址ID返回收货地址记录
	 * 
	 * @param userid
	 * @return
	 */
	@Transactional
	@Override
	public UserAddresses selectUserAddressByUserIdAndAddressId(Long userid, Integer address_id) {
		UserAddressesExample uae = new UserAddressesExample();

		uae.createCriteria().andUserIdEqualTo(userid.intValue()).andAddressIdEqualTo(address_id);
		List<UserAddresses> userAddresseslist = userAddressesMapper.selectByExample(uae);
		if (userAddresseslist != null && userAddresseslist.size() == 1) {
			return userAddresseslist.get(0);
		}
		return null;
	}

	/**
	 * 根据收货地址ID 更新收货地址记录
	 * 
	 * @param userid
	 * @return
	 */
	@Transactional
	@Override
	public void updateAddressById(Integer addressId, String phone, String address, Boolean is_default, String name) {
		UserAddresses ua = new UserAddresses();
		ua.setAddressId(addressId);
		ua.setPhone(phone);
		ua.setAddress(address);
		ua.setIsDefault(is_default + "");
		ua.setName(name);
		ua.setCreatedAt(new Date());
		userAddressesMapper.insertSelective(ua);
	}

	/**
	 * 根据收货地址ID删除记录
	 * 
	 * @param addressId
	 */
	@Override
	public void deleteAddressById(Integer addressId) {
		// 逻辑删除
		UserAddresses userAddress = new UserAddresses();
		userAddress.setAddressId(addressId);
		userAddress.setDeletedAt(new Date());
		userAddressesMapper.updateByPrimaryKeySelective(userAddress);

		// userAddressesMapper.deleteByPrimaryKey(addressId);

	}
}
