package com.tiancaibao.service.coupons;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.coupons.CouponsCurrentInterestratesCouponsMapper;
import com.tiancaibao.pojo.coupons.CouponsCurrentInterestratesCoupons;
import com.tiancaibao.pojo.coupons.CouponsCurrentInterestratesCouponsExample;
import com.tiancaibao.service.interfaces.coupons.ICouponsCurrentInterestCouponsService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.page.Pagination;

@Service("couponsCurrentInterestservice")
public class CouponsCurrentInterestCouponsServiceImpl implements ICouponsCurrentInterestCouponsService {

	@Resource
	CouponsCurrentInterestratesCouponsMapper couponsCurrentInterestCouponsMapper; // 活期加息券


	@Override
	public void reviseExpireCoupon(Long userid) {
		// 查询出用户 status=AVAILABLE CouponsCurrentInterestCoupons
		CouponsCurrentInterestratesCouponsExample aice = new CouponsCurrentInterestratesCouponsExample();
		aice.createCriteria().andUserIdEqualTo(userid).andStatusEqualTo("AVAILABLE");
		List<CouponsCurrentInterestratesCoupons> aicList = couponsCurrentInterestCouponsMapper.selectByExample(aice);
		if (aicList != null) {
			// 遍历aicList 判断加息劵是否过期 修改状态
			for (CouponsCurrentInterestratesCoupons aic : aicList) {
				if (aic != null && new Date().compareTo(aic.getDeadline()) > 0 && "AVAILABLE".equals(aic.getStatus())) {
					CouponsCurrentInterestratesCoupons aics = new CouponsCurrentInterestratesCoupons();
					aics.setId(aic.getId());
					aics.setStatus("EXPIRED");
					aics.setUpdatedAt(new Date());
					couponsCurrentInterestCouponsMapper.updateByPrimaryKeySelective(aics);
				}
			}
		}

	}

	@Override
	public Pagination selectCouponWithPage(Integer currPage, Integer pageSize, Long userid) {
		if (currPage == null) {
			currPage = 0;
		}
		if (pageSize == null) {
			pageSize = 9;
		}
		CouponsCurrentInterestratesCouponsExample ace = new CouponsCurrentInterestratesCouponsExample();
		ace.createCriteria().andUserIdEqualTo(userid);
		ace.setPageNo(currPage);
		ace.setPageSize(pageSize);
		ace.setOrderByClause("status asc,deadline asc");
		List<CouponsCurrentInterestratesCoupons> list = couponsCurrentInterestCouponsMapper.selectByExample(ace);
		long totalCount = couponsCurrentInterestCouponsMapper.countByExample(ace);
		Pagination pagination = new Pagination(currPage, pageSize, Integer.parseInt(totalCount + ""), list);
		return pagination;
	}

	@Override
	public int selectUsedCouponCountByUsedAtAndUserId(Long userid) {
		CouponsCurrentInterestratesCouponsExample ace = new CouponsCurrentInterestratesCouponsExample();
		ace.createCriteria().andUserIdEqualTo(userid).andUsedAtEqualTo(DateUtil.getDayStartDate());
		return Integer.parseInt(couponsCurrentInterestCouponsMapper.countByExample(ace) + "");
	}

	@Override
	public CouponsCurrentInterestratesCoupons selectAddInterestCouponById(Long id) {
		return couponsCurrentInterestCouponsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateStatusAndUsedAtById(String status, Long id) {
		CouponsCurrentInterestratesCoupons ac = new CouponsCurrentInterestratesCoupons();
		ac.setId(id);
		ac.setStatus(status);
		ac.setUsedAt(new Date());
		ac.setUpdatedAt(new Date());
		couponsCurrentInterestCouponsMapper.updateByPrimaryKeySelective(ac);

	}

	@Override
	public void addAddInterestCouponPercent(Long inviterid) {
		CouponsCurrentInterestratesCoupons aic = new CouponsCurrentInterestratesCoupons();
		aic.setUserId(inviterid);
		aic.setValue(1L);
		aic.setSource("0");
		aic.setStatus("AVAILABLE");
		aic.setStartline(new Date());
		aic.setDeadline(DateUtil.afterNDay(new Date(), 60));
		aic.setCreatedAt(new Date());
		couponsCurrentInterestCouponsMapper.insertSelective(aic);

	}

	@Override
	public CouponsCurrentInterestratesCoupons selectAddInterestCouponByShopClassIdAndSisShopLimitNum(Integer shopTypeId,
			byte sisshop, int limitnum) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<CouponsCurrentInterestratesCoupons> selectAddInterestCouponByUserIdAndSource(Long userid,
			Integer source) {
		CouponsCurrentInterestratesCouponsExample ace = new CouponsCurrentInterestratesCouponsExample();
		ace.createCriteria().andUserIdEqualTo(userid).andSourceEqualTo(source.toString());
		return couponsCurrentInterestCouponsMapper.selectByExample(ace);
	}

	@Override
	public int selectAddInterestCouponCountBySource(Integer source) {
		CouponsCurrentInterestratesCouponsExample ace = new CouponsCurrentInterestratesCouponsExample();
		ace.createCriteria().andSourceEqualTo(source.toString());
		return Integer.parseInt(couponsCurrentInterestCouponsMapper.countByExample(ace) + "");
	}

	@Override
	public List<CouponsCurrentInterestratesCoupons> selectAddInterestCouponByUserIdAndSourceAndCreateAtBetween(
			Long userid, Integer source, String startdate, String enddate) {
		CouponsCurrentInterestratesCouponsExample ace = new CouponsCurrentInterestratesCouponsExample();
		ace.createCriteria().andUserIdEqualTo(userid).andSourceEqualTo(source.toString())
				.andCreatedAtBetween(DateUtil.parseDateTime(startdate), DateUtil.parseDateTime(enddate));
		return couponsCurrentInterestCouponsMapper.selectByExample(ace);
	}

	@Override
	public int selectAddInterestCouponCountBySourceAndCreateAtBetween(Integer source, String startdate,
			String enddate) {
		CouponsCurrentInterestratesCouponsExample ace = new CouponsCurrentInterestratesCouponsExample();
		ace.createCriteria().andSourceEqualTo(source.toString()).andCreatedAtBetween(DateUtil.parseDateTime(startdate),
				DateUtil.parseDateTime(enddate));
		return Integer.parseInt(couponsCurrentInterestCouponsMapper.countByExample(ace) + "");
	}

	@Override
	public void insertAddInterestCouponForAnswer(Long userid, Long value, String status, Integer source, Date startline,
			Date endline, String remark) {
		CouponsCurrentInterestratesCoupons aic = new CouponsCurrentInterestratesCoupons();
		aic.setUserId(userid);
		aic.setValue(value);
		aic.setStatus(status);
		aic.setSource(source.toString());
		aic.setStartline(startline);
		aic.setDeadline(endline);
		aic.setRemark(remark);
		aic.setCreatedAt(new Date());
		couponsCurrentInterestCouponsMapper.insertSelective(aic);

	}

	@Override
	public List<CouponsCurrentInterestratesCoupons> selectAddInterestFromAddInterestCouponsByUserIdForPc(Long userid) {

		CouponsCurrentInterestratesCouponsExample ace = new CouponsCurrentInterestratesCouponsExample();
		ace.createCriteria().andIdEqualTo(userid);

		return couponsCurrentInterestCouponsMapper.selectByExample(ace);

	}

	@Override
	public CouponsCurrentInterestratesCoupons selectAddInterestCouponByUserIdAndUsedAtToday(Long userid,
			Date dayStartDate) {
		CouponsCurrentInterestratesCouponsExample aice = new CouponsCurrentInterestratesCouponsExample();
		aice.createCriteria().andUserIdEqualTo(userid).andUsedAtEqualTo(dayStartDate); //
		List<CouponsCurrentInterestratesCoupons> aiclist = couponsCurrentInterestCouponsMapper.selectByExample(aice);
		if (aiclist != null) {
			return aiclist.get(0);
		}
		return null;
	}

}
