package com.tiancaibao.controller.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.AddInterestCashCoupons;
import com.tiancaibao.pojo.ShopIndents;
import com.tiancaibao.pojo.ShopTypes;
import com.tiancaibao.pojo.Shops;
import com.tiancaibao.service.addinterest.AddInterestService;
import com.tiancaibao.service.shop.ShopService;
import com.tiancaibao.service.user.user.UserService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	@Resource
	private UserService userService;
	@Resource
	private ShopService shopService;
	@Resource
	private AddInterestService addInterestService;

	/**
	 * 商品列表(首页)
	 * 
	 * @return
	 */
	@RequestMapping("/listOfGoods.do")
	@ResponseBody
	public String listOfGoods(String token) {
		JSONObject json = new JSONObject();
		try {
			// 积分
			int integral = 0;
			if (StringUtils.isNotBlank(token)) {
				integral = userService.selectUserByToken(token).getIntegral();
			}
			List<ShopTypes> shopTypeList = shopService.selectShopTypeOrderBySorder();
			if (shopTypeList == null) {
				json.put("success", true);
				json.put("error", "暂无商品信息");
				json.put("data", null);
				return json.toString();
			}
			List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
			for (ShopTypes st : shopTypeList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("type_id", st.getId());
				map.put("name", st.getName());
				switch (st.getId()) {
				case 1:// 卡券
					map.put("type", "ticket");
					AddInterestCashCoupons acc = addInterestService
							.selectAddInterestCouponByShopClassIdAndSisShopLimitNum(st.getId(), (byte) 1, 8);
					map.put("shops", acc);
					data.add(map);
					break;
				case 2:// 电子礼券区
					map.put("type", "eepw_ticket");
					List<Shops> shoplist = shopService.selectShopByShopClassIdAndSisShopLimitNum(st.getId(), (byte) 1,
							4);
					map.put("shops", shoplist);
					data.add(map);
					break;
				default:
					map.put("type", "article");
					List<Shops> slist = shopService.selectShopByShopClassIdAndSisShopLimitNum(st.getId(), (byte) 1, 4);
					map.put("shops", slist);
					data.add(map);
					break;
				}
			}
			json.put("success", true);
			json.put("error", "");
			json.put("data", data);
			json.put("integral", integral);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	/**
	 * 分类更多展示
	 * 
	 * @param type_id
	 * @return
	 */
	@RequestMapping("/shopMore.do")
	@ResponseBody
	public String shopMore(Integer type_id) {
		JSONObject json = new JSONObject();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			if (type_id == null) {
				json.put("success", true);
				json.put("error", "客官,小序没有接受到正确的请求!");
				json.put("data", null);
			}
			switch (type_id) {
			case 1:// 卡券
				data.put("type", "ticket");
				List<AddInterestCashCoupons> acclist = addInterestService
						.selectAddInterestCouponByShopClassIdAndSisShop(type_id, (byte) 1);
				data.put("shops", acclist);
				break;
			case 2:// 电子礼券区
				data.put("type", "eepw_ticket");
				List<Shops> shoplist = shopService.selectShopByShopClassIdAndSisShop(type_id, (byte) 1);
				data.put("shops", shoplist);
				break;
			default:
				data.put("type", "article");
				List<Shops> slist = shopService.selectShopByShopClassIdAndSisShop(type_id, (byte) 1);
				data.put("shops", slist);
				break;
			}
			data.put("type_id", type_id);
			json.put("success", true);
			json.put("error", "");
			json.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	/**
	 * 实时记录
	 * 
	 * @return
	 */
	public String realexchange() {
		JSONObject json = new JSONObject();
		try {
			List<ShopIndents> silist = shopService.selectShopIndentListLimit(5);
			if (silist == null) {
				json.put("success", true);
				json.put("error", "暂无兑换信息");
				json.put("data", null);
			}
			List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
			for (ShopIndents si : silist) {
				Long userId = si.getUserId();
				String user_phone = userService.selectPhoneByUserId(userId);
				Map<String, Object> map = new HashMap<String, Object>();
				user_phone = user_phone.substring(0, 3) + "****" + user_phone.substring(7);
				map.put("phone", user_phone);
				Integer gquantity = si.getGquantity();
				switch (si.getShopClassId()) {
				case 1:
					String addInterestCashCouponName = addInterestService
							.selectAddInterestCashCouponNameById(si.getAddInterestCouponId());
					map.put("describe", "兑换" + gquantity + "张" + addInterestCashCouponName);
					data.add(map);
					break;
				case 2:
					String shopName = addInterestService.selectShopNameById(si.getSid());
					map.put("describe", "兑换" + gquantity + "张" + shopName);
					data.add(map);
					break;
				default:
					String shopname = addInterestService.selectShopNameById(si.getSid());
					map.put("describe", "兑换" + gquantity + "个" + shopname);
					data.add(map);
					break;
				}
			}
			json.put("success", true);
			json.put("error", "");
			json.put("data", data);
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	/**
	 * 商品详情页
	 * @param type_id
	 * @return
	 */
	@RequestMapping("/shopDetails.do")
	@ResponseBody
	public String shopDetails(String token, Integer type_id, Integer id) {
		JSONObject json = new JSONObject();
		try {
			// 积分
			int integral = 0;
			if (StringUtils.isNotBlank(token)) {
				integral = userService.selectUserByToken(token).getIntegral();
			}
			if (type_id == null || id == null) {
				json.put("success", true);
				json.put("error", "暂无商品信息");
				json.put("data", null);
				return json.toString();
			}
			Map<String, Object> map = new HashMap<String, Object>();
			switch (type_id) {
			case 1:
				AddInterestCashCoupons aicc = addInterestService
						.selectAddInterestCashCouponByShopClassIdAndSisshopAndId(type_id, (byte) 1, id);
				map.put("data", aicc);
				break;
			default:
				Shops shops = shopService.selectShopByShopClassIdAndSisShopAndId(type_id, (byte) 1, id);
				map.put("data", shops);
				break;
			}
			json.put("success", true);
			json.put("error", "");
			if (map.get("data") == null) {
				json.put("error", "此商品不存在");
			}
			json.put("data", map.get("data"));
			json.put("integral", integral);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}
}
