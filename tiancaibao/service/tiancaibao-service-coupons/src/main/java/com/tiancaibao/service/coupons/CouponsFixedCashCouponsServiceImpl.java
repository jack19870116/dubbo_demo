package com.tiancaibao.service.coupons;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.coupons.CouponsFixedCashCouponsMapper;
import com.tiancaibao.pojo.coupons.CouponsFixedCashCoupons;
import com.tiancaibao.pojo.coupons.CouponsFixedCashCouponsExample;
import com.tiancaibao.service.interfaces.coupons.ICouponsFixedCashCouponsService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.page.Pagination;

@Service("couponsFixedCashCouponService")
public class CouponsFixedCashCouponsServiceImpl implements ICouponsFixedCashCouponsService {

	@Resource
	CouponsFixedCashCouponsMapper couponsFixedCashCouponsMapper;
	
	private static Logger log = LoggerFactory.getLogger(CouponsFixedCashCouponsServiceImpl.class);
	
	@Override
	public CouponsFixedCashCoupons selectFixedCashCouponById(Integer id) {
		return couponsFixedCashCouponsMapper.selectByPrimaryKey(Long.parseLong(id.toString()));
	}

	@Override
	public List<CouponsFixedCashCoupons> selectCouponsFromFixedCashCouponsByUserIdForPc(Long userid) {

		return null;

	}

	@Override
	public int insertIntoCouponsFixedCashCoupons(Long userId, Long value, Integer condition, String status,
			String source, Integer day, Date startline, Date deadline, String remark) {
		CouponsFixedCashCoupons couponsCashCoupons = new CouponsFixedCashCoupons();
		couponsCashCoupons.setUserId(userId);
		couponsCashCoupons.setValue(value);
		couponsCashCoupons.setConditions(condition);
		couponsCashCoupons.setStatus(status);
		couponsCashCoupons.setSource(source);
		couponsCashCoupons.setDays(day);
		couponsCashCoupons.setStartline(startline);
		couponsCashCoupons.setDeadline(deadline);
		couponsCashCoupons.setRemark(remark);
		couponsCashCoupons.setCreatedAt(new Date());
		couponsCashCoupons.setUpdatedAt(new Date());
		return couponsFixedCashCouponsMapper.insertSelective(couponsCashCoupons);
	}

	@Override
	public void reviseExpireCashCoupon(Long userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pagination selectCashCouponWithPage(Integer currPage, Integer pageSize, Long userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CouponsFixedCashCoupons> selectAvailableCashCouponByUserIdAndStatus(Long userid, String status) {
		CouponsFixedCashCouponsExample cce = new CouponsFixedCashCouponsExample();
		cce.createCriteria().andUserIdEqualTo(userid).andStatusEqualTo(status);
		List<CouponsFixedCashCoupons> coupons = couponsFixedCashCouponsMapper.selectByExample(cce);
		for (CouponsFixedCashCoupons cc : coupons) {
			if (cc.getDeadline().compareTo(new Date()) < 0 && "AVAILABLE".equals(cc.getStatus())) {
				cc.setStatus("EXPIRED");
				couponsFixedCashCouponsMapper.updateByPrimaryKeySelective(cc);
			}
		}

		CouponsFixedCashCouponsExample coupone = new CouponsFixedCashCouponsExample();
		coupone.setOrderByClause("deadline asc");
		cce.createCriteria().andUserIdEqualTo(userid).andStatusEqualTo(status);
		List<CouponsFixedCashCoupons> cclist = couponsFixedCashCouponsMapper.selectByExample(coupone);
		for (CouponsFixedCashCoupons cashCoupons : cclist) {
			if ("0000-00-00".equals(DateUtil.formatDate(cashCoupons.getStartline()))) {
				String deadline = DateUtil.formatDate(cashCoupons.getDeadline());
				cashCoupons.setExpired("2016/01/01-" + deadline.replaceAll("-", "/"));
			} else {
				String startline = DateUtil.formatDate(cashCoupons.getStartline());
				String deadline = DateUtil.formatDate(cashCoupons.getDeadline());
				cashCoupons.setExpired(startline.replaceAll("-", "/") + "-" + deadline.replaceAll("-", "/"));
			}
		}
		return cclist;

	}

	@Override
	public CouponsFixedCashCoupons selectCashCouponByIdAndUserId(Integer couponId, Long userid) {
		CouponsFixedCashCouponsExample cce = new CouponsFixedCashCouponsExample();
		cce.createCriteria().andIdEqualTo(couponId.longValue()).andUserIdEqualTo(userid);
		List<CouponsFixedCashCoupons> cclist = couponsFixedCashCouponsMapper.selectByExample(cce);
		if (cclist != null) {
			return cclist.get(0);
		}
		return null;
	}

	@Override
	public CouponsFixedCashCoupons selectCashCouponsByIdUserIdAndLessThanConditionOrderByDeadline(Integer couponId,
			Long userid, Long condition, String orderDeadline) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Long selectSumUsedCashCouponAmountByUserId(Long userId) {
		CouponsFixedCashCouponsExample cce = new CouponsFixedCashCouponsExample();
		cce.createCriteria().andUserIdEqualTo(userId).andUsedAtGreaterThanOrEqualTo(DateUtil.parseDate("2016-01-01")).andStatusEqualTo("USED");
		Long amount =couponsFixedCashCouponsMapper.selectSumAmountByUserIdAndCreatedAtGreaterThanAndStatus(cce);
		log.info("使用userId= " + userId + " 查询couponsFixedCashCoupons红包总金额返回值是: " + amount +"; \n");
		return amount;
	}

	/**
	 * 更新红包
	 */
	@Override
	public int updateCouponsFixedCashCouponsStates(long id, String status) {
		CouponsFixedCashCoupons record = new CouponsFixedCashCoupons();
		record.setId(id);
		record.setStatus(status);
		return couponsFixedCashCouponsMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateCouponsFixedCashCouponsByidAndUserId(Long id, Long user_id, String status) {
		CouponsFixedCashCouponsExample example = new CouponsFixedCashCouponsExample();
		CouponsFixedCashCoupons record = new CouponsFixedCashCoupons();

		example.createCriteria().andIdEqualTo(id).andUserIdEqualTo(user_id);
		record.setStatus(status);
		record.setUsedAt(new Date());

		int updateByExampleSelective = couponsFixedCashCouponsMapper.updateByExampleSelective(record, example);

		return updateByExampleSelective;
	}

}
