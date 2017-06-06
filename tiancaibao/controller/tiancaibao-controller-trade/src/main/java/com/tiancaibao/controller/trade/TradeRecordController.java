/*package com.tiancaibao.controller.trade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.InvestBills;
import com.tiancaibao.pojo.SystemAssets;
import com.tiancaibao.pojo.ThemisContracts;
import com.tiancaibao.pojo.Users;
import com.tiancaibao.service.system.SystemService;
import com.tiancaibao.service.trade.InvestService;
import com.tiancaibao.service.user.UserService;

 
@Controller
@RequestMapping("/trade")
public class TradeRecordController {

	private static Logger logger = Logger.getLogger(TradeRecordController.class);

	@Resource
	private UserService userService;
	@Resource
	private InvestService investService;
	@Resource
	private SystemService systemService;

	*//**
	 * 获取交易记录
	 * 
	 * @param token
	 * @param currPage
	 * @param pageSize
	 * @param type
	 * @return
	 *//*
	@RequestMapping("/tradeRecord.do")
	@ResponseBody
	public String tradeRecord(String token, Integer currPage, Integer pageSize, String type) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			switch (type) {
			case "invest":
				List<InvestBills> investbillList = investService
						.selectInvestBillListByUserIdAndCreateAtGreatThanDateOrderByCreateAtWithPage(userid,
								"2016-04-06 00:00:00", "DESC", currPage, pageSize);

				if (investbillList == null) {
					json.put("success", true);
					json.put("record", null); // 返回null待确认
					return json.toString();
				}
				List<Map<String, Object>> record = new ArrayList<Map<String, Object>>();
				for (InvestBills ib : investbillList) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("amount", ib.getAmount());
					map.put("time", ib.getCreatedAt());
					if ("all".equals(type)) {
						ThemisContracts tc = investService.selectThemisContractsByOrderCode(ib.getOrderCode());
						if (tc == null) {
							map.put("preservation_id", null); // 返回null待确认
						} else {
							map.put("preservation_id", tc.getPreservationId());
						}
					}
					switch (ib.getStatus()) {
					case "WAITING_CONFIRM":
						map.put("status", "处理中...");
						break;
					case "CONFIRMED":
						map.put("status", "交易成功");
						break;
					case "CANCELLED":
						map.put("status", "交易失败");
						break;
					}
					switch (ib.getDays().intValue()) {
					case 1:
						map.put("name", "[活期] 购买");
						SystemAssets sa1 = systemService.selectSystemAssetByDay(1);
						map.put("rate", sa1.getRate());
						map.put("month", 0);
						break;
					case 30:
						map.put("name", "[定期1个月] 购买");
						SystemAssets sa30 = systemService.selectSystemAssetByDay(30);
						map.put("rate", sa30.getRate());
						map.put("month", 1);
						break;
					case 90:
						map.put("name", "[定期3个月] 购买");
						SystemAssets sa90 = systemService.selectSystemAssetByDay(90);
						map.put("rate", sa90.getRate());
						map.put("month", 3);
						break;
					case 180:
						map.put("name", "[定期6个月] 购买");
						SystemAssets sa180 = systemService.selectSystemAssetByDay(180);
						map.put("rate", sa180.getRate());
						map.put("month", 6);
						break;

					default:
						map.put("name", "未知");
						break;
					}
					if(ib.getReinvest()==1){
						switch (ib.getDays().intValue()) {
						case 30:
							map.put("name","[定期1个月] 复投");
							SystemAssets rsa30 = systemService.selectSystemAssetByDay(30);
							map.put("rate",rsa30.getRate());
							map.put("month", 1);
							break;
						case 90:
							map.put("name","[定期3个月] 复投");
							SystemAssets rsa90 = systemService.selectSystemAssetByDay(90);
							map.put("rate",rsa90.getRate());
							map.put("month", 3);
							break;
						case 180:
							map.put("name","[定期6个月] 复投");
							SystemAssets rsa180 = systemService.selectSystemAssetByDay(180);
							map.put("rate",rsa180.getRate());
							map.put("month", 6);
							break;
						default:
							map.put("name", "未知");
							break;
						}
					}
					
					record.add(map);
				}
				break;
				
			case :
				
				break;
			default:
				break;
				
			}

		} catch (Exception e) {
			logger.error("获取交易记录:" + e.getMessage());
		}

		return null;
	}

}
*/