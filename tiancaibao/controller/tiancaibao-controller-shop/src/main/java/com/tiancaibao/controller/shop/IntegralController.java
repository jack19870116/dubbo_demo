package com.tiancaibao.controller.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.AddInterestCashCoupons;
import com.tiancaibao.pojo.ElectronicCoupons;
import com.tiancaibao.pojo.IntegralRecords;
import com.tiancaibao.pojo.ShopTypes;
import com.tiancaibao.pojo.ShopVo;
import com.tiancaibao.pojo.Shops;
import com.tiancaibao.pojo.UserAddresses;
import com.tiancaibao.pojo.Users;
import com.tiancaibao.service.addinterest.AddInterestService;
import com.tiancaibao.service.shop.IntegralService;
import com.tiancaibao.service.shop.ShopService;
import com.tiancaibao.service.user.user.UserService;
import com.tiancaibao.utils.page.Pagination;

/**
 * 积分控制器
 * 
 * @author Mack
 *
 */
@Controller
@RequestMapping("/activity")
public class IntegralController {

	private static Logger logger = Logger.getLogger(IntegralController.class);

	@Resource
	private UserService userService;
	@Resource
	private ShopService shopService;
	@Resource
	private AddInterestService addInterestService;
	/*
	 * @Resource private CommodityExchangeService commodityExchangeService;
	 */
	@Resource
	private IntegralService integralService;

	/**
	 * 获得兑换记录
	 * 
	 * @param currPage
	 * @param pageSize
	 * @param type
	 * @return
	 */
	@RequestMapping("/exchangeRecord.do")
	@ResponseBody
	public String exchangeRecord(String token, Integer currPage, Integer pageSize, String type) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			List<ShopTypes> shopTypeList = shopService.selectShopTypeList();
			if (StringUtils.isBlank(type)) {
				type = "ticket";
			}
			Pagination pagination = null;
			switch (type) {
			case "ticket":
				pagination = shopService.selectShopIndentByUserIdAndShopClassIdWithPage(currPage, pageSize,
						user.getId(), (byte) 1);
				break;
			case "eepw_ticket":
				pagination = shopService.selectShopIndentByUserIdAndShopClassIdWithPage(currPage, pageSize,
						user.getId(), (byte) 2);
				break;
			default:
				pagination = shopService.selectShopIndentByUserIdAndShopClassIdNotInWithPage(currPage, pageSize,
						user.getId(), (byte) 1, (byte) 2);
				break;
			}
			Map<String, Object> data = new HashMap<>();
			data.put("record", pagination);
			data.put("record_types", shopTypeList);
			if (pagination == null || pagination.getList() == null) {
				json.put("success", true);
				json.put("weixin", false);
				json.put("error", "您没有兑换记录");
				json.put("data", data);
				return json.toString();
			}
			json.put("success", true);
			json.put("error", "");
			json.put("data", data);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	/**
	 * 卡卷兑换记录
	 * 
	 * @param token
	 * @param type_id
	 * @param id
	 * @param gquantity
	 * @return
	 */
	@RequestMapping("/commodityExchange.do")
	@ResponseBody
	public String commodityExchange(String token, Integer type_id, Integer id, Integer gquantity) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			ElectronicCoupons electronic = null;
			switch (type_id) {
			case 1:
				AddInterestCashCoupons addInterestCashCoupons = addInterestService.selectAddInterestCashCouponById(id);
				integralService.checkIntegralIsExchangeWithAddInterestCashCoupons(user, addInterestCashCoupons,
						gquantity);
				// 实现层记得补充代码
				integralService.commodityexchangeWithAddInterestCashCoupons(user, addInterestCashCoupons, gquantity,
						type_id.byteValue());
				break;
			default:
				Shops shops = shopService.selectShopById(id);
				integralService.checkIntegralIsExchangeWithShops(user, shops, gquantity);
				electronic = integralService.commodityexchangeWithShops(user, shops, gquantity, type_id.byteValue());
				break;
			}
			json.put("success", true);
			json.put("error", "兑换成功");
			json.put("data", electronic);
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(" 卡卷兑换记录:" + e.getMessage());
		}
		return json.toString();
	}

	/**
	 * 返回查询记录类型
	 * 
	 * @return
	 */
	@RequestMapping("/recordType.do")
	@ResponseBody
	public String recordType() {
		JSONObject json = new JSONObject();
		try {
			List<ShopTypes> shopTypeList = shopService.selectShopTypeOrderBySorder();
			if (shopTypeList == null) {
				json.put("success", false);
				json.put("error", "'客官!没有查到您要的数据");
			}
			json.put("data", shopTypeList);
			json.put("success", true);
			json.put("error", "");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("返回查询记录类型:" + e.getMessage());
		}
		return json.toString();
	}

	/**
	 * 积分明细
	 * 
	 * @return
	 */
	@RequestMapping("/integralDetail.do")
	@ResponseBody
	public String integralDetail(String token, Integer currPage, Integer pageSize) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			List<IntegralRecords> intefralRecordList = integralService.selectIntegralRecordWithPageByUserId(currPage,
					pageSize, user.getId());
			Map<String, Object> data = new HashMap<>();
			data.put("record", null);
			if (intefralRecordList == null) {
				json.put("success", true);
				json.put("weixin", false);
				json.put("integral", user.getIntegral());
				json.put("error", "您没有积分记录");
				json.put("data", data);
			}
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (IntegralRecords ir : intefralRecordList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("integral", ""); // 补全代码
				map.put("describe", "");
				map.put("date", "");
				map.put("gquantity", "");
				map.put("id", "");
				list.add(map);
			}
			data.put("record", list);
			json.put("success", true);
			json.put("integral", user.getIntegral());
			json.put("error", "");
			json.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("积分明细:" + e.getMessage());
		}
		return json.toString();
	}

	/**
	 * 提交订单
	 * 
	 * @param token
	 * @param id
	 * @param type_id
	 * @param address_id
	 * @param number
	 * @return
	 */
	@RequestMapping("/submitOrder.do")
	@ResponseBody
	public String submitOrder(String token, Integer id, Integer type_id, Integer address_id, Integer number) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			UserAddresses useraddress = userService.selectUserAddressByUserIdAndAddressId(user.getId(), address_id);
			if (useraddress == null) {
				json.put("success", false);
				json.put("error", "此地址已不存在");
				return json.toString();
			}
			integralService.submitOrderProcessing(user, id, number, type_id, address_id);
			json.put("success", true);
			json.put("error", "订单提交成功");
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("提交订单:" + e.getMessage());
		}
		return json.toString();
	}
	
	@RequestMapping("/submitOrderLoad.do")
	@ResponseBody
	public String submitOrderLoad(String token,Integer id,Integer number,Integer address_id){
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			UserAddresses userAddress = userService.selectDefaultAddressByUserId(userid);
			if(address_id!=null){
				userAddress = userService.selectUserAddressByUserIdAndAddressId(userid, address_id);
			}
			if(userAddress==null){
				userAddress = new UserAddresses();
				userAddress.setAddress("");
			}
			Shops shop = shopService.selectShopById(id);
			if(shop==null){
				json.put("success",false);
				json.put("error","此商品已不存在");
				return json.toString();
			}
			if(shop.getShopNum()-number<0){
				json.put("success",false);
				json.put("error","库存不足");
				return json.toString();
			}
			if(user.getIntegral()-number*shop.getSprice()<0){
				json.put("success",false);
				json.put("error","积分不定");
				return json.toString();
			}
			ShopVo shopVo = new ShopVo();
			BeanUtils.copyProperties(shop,shopVo);
			shopVo.setGtotal_price(number*shop.getSprice());
			shopVo.setNumber(number);
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("record",shopVo);
			data.put("address",userAddress);
			json.put("success",true);
			json.put("error","");
			json.put("data", data);
		}catch (ServiceException e) {
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("实物兑换准备:"+e.getMessage());
		}
		return json.toString();
	}
}
