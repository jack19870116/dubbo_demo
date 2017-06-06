package com.tiancaibao.service.trade.redeem.biz;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.trade.TradeRedeemBillsMapper;
import com.tiancaibao.mapper.trade.TradeRedeemHostingCollectMapper;
import com.tiancaibao.pojo.trade.TradeRedeemBills;
import com.tiancaibao.pojo.trade.TradeRedeemHostingCollect;
import com.tiancaibao.utils.OrderUtil;
/**
 * dubbo服务接口实现类--代收
 * @author Mack
 * 2017年2月13日 上午10:48:41
 */
@Service("collectionService")
public class TradeRedeemBizHostingCollectionServiceImpl implements com.tiancaibao.service.interfaces.trade.redeem.biz.ITradeRedeemBizHostingCollectionService {
	
	@Resource 
	private TradeRedeemBillsMapper redeemBillsMapper;
	@Resource
	private TradeRedeemHostingCollectMapper redeemHostingCollectMapper;
 
	@Transactional(rollbackFor=Exception.class)
	@Override
	public Long redeemHostingCollection(Long userId, Long amount, Integer days, String ip, String client) {
		//生成bill记录
		TradeRedeemBills rb = new TradeRedeemBills();
		rb.setUserId(userId);
		rb.setAmount(amount);
		rb.setDays(days.longValue());
		rb.setIp(ip);
		rb.setClient(client);
		rb.setCreatedAt(new Date());
		redeemBillsMapper.insertSelectiveReturnId(rb);
		Long redeemBillId = rb.getId();
		
		//生成订单id
		String orderCode = OrderUtil.createOrderId("RED", "COL", userId);
		
		//生成代收表
		TradeRedeemHostingCollect rhc = new TradeRedeemHostingCollect();
		rhc.setUserId(userId);
		rhc.setAmount(amount);
		rhc.setOrderCode(orderCode);
		rhc.setRedeemOrderId(redeemBillId+"");
		rhc.setStatus("WAIT_PAY");//等待代付付款状态
		rhc.setIp(ip);
		rhc.setCreatedAt(new Date());
		redeemHostingCollectMapper.insertSelective(rhc);
		
		return redeemBillId;
	}

}
