package com.tiancaibao.controller.shop;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.ShopRegions;
import com.tiancaibao.pojo.UserAddresses;
import com.tiancaibao.pojo.Users;
import com.tiancaibao.service.shop.ShopService;
import com.tiancaibao.service.user.user.UserService;

@Controller
@RequestMapping("/shop")
public class AddressManagementController {

	private static Logger logger = Logger.getLogger(AddressManagementController.class);
	@Resource
	private UserService userService;
	@Resource
	private ShopService shopService;

	/**
	 * 获取收货地址
	 * 
	 * @param token
	 * @return
	 */
	@RequestMapping("/addressIndexList.do")
	@ResponseBody
	public String addressIndexList(String token) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			List<UserAddresses> userAddresslist = userService.selectUserAddressListByUserIdOrder(user.getId());
			json.put("error", "");
			if (userAddresslist == null) {
				json.put("error", "没有找到地址");
			}
			json.put("success", true);
			json.put("data", userAddresslist);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取收货地址:" + e.getMessage());
		}
		return json.toString();
	}

	/**
	 * 获取默认收货地址
	 * 
	 * @param token
	 * @return
	 */
	@RequestMapping("/defaultAddressIndex.do")
	@ResponseBody
	public String defaultAddressIndex(String token) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			UserAddresses userAddress = userService.selectDefaultAddressByUserId(user.getId());
			json.put("success", true);
			json.put("error", "");
			json.put("data", userAddress);
			json.put("isHave", true);
			if (userAddress == null) {
				json.put("error", "没有找到默认地址");
				json.put("isHave", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取默认收货地址:" + e.getMessage());
		}
		return json.toString();
	}

	/**
	 * 新增地址
	 * 
	 * @param token
	 * @param phone
	 * @param name
	 * @param address
	 * @param is_default
	 * @return
	 */
	@RequestMapping("/addAddress.do")
	@ResponseBody
	public String addAddress(String token, String phone, String name, String address, Boolean is_default) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			if (StringUtils.isBlank(phone) || StringUtils.isBlank(name) || StringUtils.isBlank(address)
					|| is_default == null) {
				json.put("success", false);
				json.put("error", "确认参数是否全部填写");
				return json.toString();
			}
			// 是否更新默认地址
			if (is_default) {
				UserAddresses userAddress = userService.selectDefaultAddressByUserId(userid);
				if (userAddress != null) {
					userService.updateAddressIsDefaultById(userAddress.getAddressId(), false);// 未实现
				}
			}
			// 新增地址
			userService.insertUserAddress(name, address, userid, phone, is_default);
			json.put("success", true);
			json.put("error", "地址增加成功");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(" 新增地址:" + e.getMessage());
		}
		return json.toString();
	}

	/**
	 * 修改地址准备
	 * 
	 * @param token
	 * @param address_id
	 * @return
	 */
	@RequestMapping("/modifyAddressLoad.do")
	@ResponseBody
	public String modifyAddressLoad(String token, Integer address_id) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userId = user.getId();
			UserAddresses userAddress = userService.selectUserAddressByUserIdAndAddressIdOrderByIsDefault(userId,
					address_id);
			if (userAddress == null) {
				json.put("success", false);
				json.put("error", "没有找到地址");
				json.put("data", null);
				return json.toString();
			}
			String address = userAddress.getAddress();
			String[] addressarr = address.split("\\|");
			json.put("success", true);
			json.put("error", "");
			json.put("data", addressarr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("修改地址准备:" + e.getMessage());
		}
		return json.toString();
	}

	/**
	 * 修改地址
	 * @param token
	 * @param phone
	 * @param name
	 * @param address
	 * @param is_default
	 * @param address_id
	 * @return
	 */
	@RequestMapping("/modifyAddress.do")
	@ResponseBody
	public String modifyAddress(String token, String phone, String name, String address, Boolean is_default,
			Integer address_id) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			if(StringUtils.isBlank(phone)||StringUtils.isBlank(name)||StringUtils.isBlank(address)||is_default==null){
				json.put("success",false);
				json.put("error","确认参数是否全部填写");
				return json.toString();
			}
			//是否更新默认地址
			if (is_default) {
				UserAddresses userAddress = userService.selectDefaultAddressByUserId(userid);
				if (userAddress != null) {
					userService.updateAddressIsDefaultById(userAddress.getAddressId(), false);
				}
			}
			UserAddresses updateAddress = userService.selectUserAddressByUserIdAndAddressId(userid,address_id);
			if(updateAddress==null){
				json.put("success",false);
				json.put("error","修改的地址不存在");
				return json.toString();
			}
			userService.updateAddressById(updateAddress.getAddressId(),phone,address,is_default,name);
			json.put("success",true);
			json.put("error","地址修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("修改地址:"+e.getMessage());
		}
		return json.toString();
	}
	
	/**
	 * 删除地址
	 * @param token
	 * @param address_id
	 * @return
	 */
	@RequestMapping("/deleteAddress.do")
	@ResponseBody
	public String deleteAddress(String token,Integer address_id){
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			UserAddresses deleteAddress = userService.selectUserAddressByUserIdAndAddressId(userid,address_id);
			if(deleteAddress==null){
				json.put("success",false);
				json.put("error","删除的地址不存在");
				return json.toString();
			}
			userService.deleteAddressById(deleteAddress.getAddressId());
			json.put("success",true);
			json.put("error","删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除地址:"+e.getMessage());
		}
		return json.toString();
	}
	
	/**
	 * 修改默认地址
	 * @param token
	 * @param address_id
	 * @return
	 */
	@RequestMapping("/updateDefaultAddress.do")
	@ResponseBody
	public String updateDefaultAddress(String token,Integer address_id){
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			UserAddresses defaultAddress = userService.selectUserAddressByUserIdAndAddressId(userid,address_id);
			if(defaultAddress==null){
				json.put("success",false);
				json.put("error","修改的地址不存在");
				return json.toString();
			}
			if("true".equals(defaultAddress.getIsDefault())){
				json.put("success",true);
				json.put("error","此地址已为默认无需修改");
				return json.toString();
			}
			UserAddresses userAddress = userService.selectDefaultAddressByUserId(userid);
			if(userAddress!=null){
				userService.updateAddressIsDefaultById(userAddress.getAddressId(), false);
			}
			userService.updateAddressIsDefaultById(defaultAddress.getAddressId(),true);
			json.put("success",true);
			json.put("error","修改成功");
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("修改默认地址:"+e.getMessage());
		}
		return json.toString();
	}
	
	/**
	 * 获取地址
	 * @return
	 */
	@RequestMapping("/loadRegion.do")
	public List<ShopRegions> loadRegion(){
		List<ShopRegions> list1 = shopService.selectShopReionsByRegionTypeAndParentIdOrderByRegionId(1,1,"asc");
		for (ShopRegions shopRegions : list1) {
			List<ShopRegions> list2 = shopService.selectShopReionsByRegionTypeAndParentIdOrderByRegionId(2,shopRegions.getRegionId(),null);
			shopRegions.setList(list2);
			for (ShopRegions shopRegions2 : list2) {
				List<ShopRegions> list3 = shopService.selectShopReionsByRegionTypeAndParentIdOrderByRegionId(3,shopRegions2.getRegionId(),null);
				shopRegions2.setList(list3);
			}
		}
		return list1;
	}
}
