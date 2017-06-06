package com.tiancaibao.service.shop;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.mapper.shop.ShopIndentsMapper;
import com.tiancaibao.mapper.shop.ShopRegionsMapper;
import com.tiancaibao.mapper.shop.ShopTypesMapper;
import com.tiancaibao.mapper.shop.ShopsMapper;
import com.tiancaibao.pojo.shop.ShopIndents;
import com.tiancaibao.pojo.shop.ShopIndentsExample;
import com.tiancaibao.pojo.shop.ShopRegions;
import com.tiancaibao.pojo.shop.ShopRegionsExample;
import com.tiancaibao.pojo.shop.ShopTypes;
import com.tiancaibao.pojo.shop.ShopTypesExample;
import com.tiancaibao.pojo.shop.Shops;
import com.tiancaibao.pojo.shop.ShopsExample;
import com.tiancaibao.pojo.shop.ShopsExample.Criteria;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.integral.IIntegralService;
import com.tiancaibao.service.interfaces.shop.IShopService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.utils.ArrayUtil;
import com.tiancaibao.utils.page.Pagination;

@Service("shopService")
public class ShopServiceImpl implements IShopService {
	@Resource
	private ShopTypesMapper shopTypesMapper;
	@Resource
	private ShopsMapper shopsMapper;
	@Resource
	private ShopIndentsMapper shopIndentsMapper;
	@Resource
	private ShopRegionsMapper shopRegionsMapper;
	@Resource
	private ShopRegionsMapper ShopActivitysMapper;
	@Resource
	private IUserService userService;
	@Resource
	private IIntegralService integralService;

	@Transactional
	@Override
	public List<ShopTypes> selectShopTypeOrderBySorder() {
		ShopTypesExample ste = new ShopTypesExample();
		ste.setOrderByClause("sorder asc");
		return shopTypesMapper.selectByExample(ste);
	}
	
	@Transactional
	@Override
	public List<Shops> selectShopByShopClassIdAndSisShopLimitNum(Integer shopTypeId, byte sisshop, int limitnum) {
		ShopsExample se = new ShopsExample();
		Criteria criteria = se.createCriteria();
		criteria.andShopClassIdEqualTo(shopTypeId.longValue());
		criteria.andSisshopEqualTo(1);
		se.setOrderByClause("created_at desc,sorder asc");
		se.setPageNo(1);
		se.setPageSize(limitnum);
		return shopsMapper.selectByExample(se);
	}
	
	@Transactional
	@Override
	public List<Shops> selectShopByShopClassIdAndSisShop(Integer type_id, byte sisshop) {
		ShopsExample se = new ShopsExample();
		Criteria criteria = se.createCriteria();
		criteria.andShopClassIdEqualTo(type_id.longValue());
		criteria.andSisshopEqualTo(1);
		se.setOrderByClause("created_at desc,sorder asc");
		return shopsMapper.selectByExample(se);
	}
	
	@Transactional
	@Override
	public Pagination selectShopByShopClassIdAndSisShopWithPage(Integer currPage, Integer pageSize, Integer type_id, byte sisshop) {
		if(currPage==null){
			currPage=1;
		}
		if(pageSize==null){
			pageSize=20;
		}
		ShopsExample se = new ShopsExample();
		Criteria criteria = se.createCriteria();
		criteria.andShopClassIdEqualTo(type_id.longValue());
		criteria.andSisshopEqualTo(1);
		se.setOrderByClause("created_at desc,sorder asc");
		se.setPageNo(currPage);
		se.setPageSize(pageSize);
		int totalCount = shopsMapper.countByExample(se);
		List<Shops> list =  shopsMapper.selectByExample(se);
		Pagination pagination = new Pagination(currPage, pageSize, totalCount, list);
		return pagination;
	}
	
	@Transactional
	@Override
	public List<ShopIndents> selectShopIndentListLimit(int limitnum) {
		ShopIndentsExample sie = new ShopIndentsExample();
		sie.setOrderByClause("updated_at desc");
		sie.setPageNo(1);
		sie.setPageSize(limitnum);
		return shopIndentsMapper.selectByExample(sie);
	}
	
	@Transactional
	@Override
	public Shops selectShopByShopClassIdAndSisShopAndId(Integer type_id, byte b, Integer id) {
		ShopsExample se = new ShopsExample();
		Criteria criteria = se.createCriteria();
		criteria.andShopClassIdEqualTo(type_id.longValue());
		criteria.andSisshopEqualTo(1);
		criteria.andIdEqualTo(id.longValue());
		se.setOrderByClause("sorder asc");
		List<Shops> shopList = shopsMapper.selectByExample(se);
		if (shopList != null) {
			return shopList.get(0);
		}
		return null;
	}
	
	@Transactional
	@Override
	public List<ShopTypes> selectShopTypeList() {
		ShopTypesExample ste = new ShopTypesExample();
		ste.setOrderByClause("sorder asc");
		return shopTypesMapper.selectByExample(ste);
	}
	
	@Transactional
	@Override
	public Pagination selectShopIndentByUserIdAndShopClassIdWithPage(Integer currPage, Integer pageSize, Long userid,
			byte shopclassid) {
		if(currPage==null){
			currPage=1;
		}
		if(pageSize==null){
			pageSize=20;
		}
		ShopIndentsExample ste = new ShopIndentsExample();
		ste.createCriteria().andUserIdEqualTo(userid).andShopClassIdEqualTo(shopclassid);
		ste.setOrderByClause("created_at desc");
		ste.setPageNo(currPage);
		ste.setPageSize(pageSize);
		int totalCount = shopIndentsMapper.countByExample(ste);
		List<ShopIndents> list = shopIndentsMapper.selectByExample(ste);
		Pagination pagination = new Pagination(currPage, pageSize, totalCount, list);
		return pagination;
	}
	
	@Transactional
	@Override
	public Pagination selectShopIndentByUserIdAndShopClassIdNotInWithPage(Integer currPage, Integer pageSize,
			Long userid, byte... shopclassid) {
		if(currPage==null){
			currPage=1;
		}
		if(pageSize==null){
			pageSize=20;
		}
		ShopIndentsExample ste = new ShopIndentsExample();
		ste.createCriteria().andUserIdEqualTo(userid).andShopClassIdNotIn(ArrayUtil.arrayToList(shopclassid));
		ste.setOrderByClause("created_at desc");
		ste.setPageNo(currPage);
		ste.setPageSize(pageSize);
		int totalCount = shopIndentsMapper.countByExample(ste);
		List<ShopIndents> list = shopIndentsMapper.selectByExample(ste);
		Pagination pagination = new Pagination(currPage, pageSize, totalCount, list);
		return pagination;
	}
	
	@Transactional(readOnly=true)
	@Override
	public Shops selectShopById(Integer id) {
		return shopsMapper.selectByPrimaryKey(id.longValue());
	}
	
	@Transactional
	@Override
	public List<ShopRegions> selectShopReionsByRegionTypeAndParentIdOrderByRegionId(int region_type, int parent_id,
			String orderby) {
		ShopRegionsExample sre = new ShopRegionsExample();
		if(orderby!=null){
			sre.setOrderByClause(orderby+"asc");
		}
		//sre.createCriteria().andRegionTypeEqualTo(region_type).andParentIdEqualTo(parent_id);
		return shopRegionsMapper.selectByExample(sre);
	}
	
	@Transactional
	@Override
	public Shops selectShopByShopClassIdAndId(Integer type_id, Integer id) {
		ShopsExample se = new ShopsExample();
		Criteria criteria = se.createCriteria();
		criteria.andShopClassIdEqualTo(type_id.longValue());
		criteria.andIdEqualTo(id.longValue());
		List<Shops> shopList = shopsMapper.selectByExample(se);
		if (shopList != null) {
			return shopList.get(0);
		}
		return null;
	}
	
	@Transactional
	@Override
	public List<Shops> selectShopByIsRecommendAndSisShopLimitNum(byte is_recommend, byte b, int limitnum) {
		ShopsExample se = new ShopsExample();
		Criteria criteria = se.createCriteria();
		criteria.andIsRecommendEqualTo(1l);
		criteria.andSisshopEqualTo(1);
		se.setOrderByClause("created_at desc,sorder asc");
		se.setPageNo(1);
		se.setPageSize(limitnum);
		return shopsMapper.selectByExample(se);
	}
	
	@Transactional
	@Override
	public List<Shops> selectShopByShopClassIdAndSisShopAndIsRecommendLimitNum(Integer type_id, byte sisshop, byte is_recommend, int limitnum) {
		ShopsExample se = new ShopsExample();
		Criteria criteria = se.createCriteria();
		criteria.andShopClassIdEqualTo(type_id.longValue());
		criteria.andSisshopEqualTo(1);
		criteria.andIsRecommendEqualTo(0l);
		se.setOrderByClause("created_at desc,sorder asc");
		se.setPageNo(1);
		se.setPageSize(limitnum);
		return shopsMapper.selectByExample(se);
	}
	
	@Transactional
	@Override
	public Pagination selectShopByShopClassIdAndChildClassIdAndSisShopWithPage(Integer currPage, Integer pageSize, Integer type_id, Integer child_class_id, byte sisshop) {
		if(currPage==null){
			currPage=1;
		}
		if(pageSize==null){
			pageSize=20;
		}
		ShopsExample se = new ShopsExample();
		Criteria criteria = se.createCriteria();
		criteria.andShopClassIdEqualTo(type_id.longValue());
		criteria.andChildClassIdEqualTo(child_class_id.longValue());
		criteria.andSisshopEqualTo(1);
		se.setOrderByClause("created_at desc,sorder asc");
		se.setPageNo(currPage);
		se.setPageSize(pageSize);
		int totalCount = shopsMapper.countByExample(se);
		List<Shops> list =  shopsMapper.selectByExample(se);
		Pagination pagination = new Pagination(currPage, pageSize, totalCount, list);
		return pagination;
	}
	
	@Transactional
	@Override
	public List<Shops> selectShopBySisShopAndName(byte sisshop, String name) {
		ShopsExample se = new ShopsExample();
		Criteria criteria = se.createCriteria();
		criteria.andSisshopEqualTo(1);
		criteria.andNameLike(name);
		se.setOrderByClause("created_at desc,sorder asc");
		return shopsMapper.selectByExample(se);
	}

	@Override
	@Transactional
	public String goToShopIndex(String token) {
		JSONObject json = new JSONObject();
		//我的当前积分
		Integer integral = 0;
		//已兑换积分
		Integer use_integral = 0;
		
		Users users = null;
		if(token!=null){
			users = userService.selectUserByToken(token);
			if (users != null) {
				integral= users.getIntegral();
				// 从积分表中拿到已兑换积分
				use_integral =integralService.selectUseIntegralSum(users.getId());
			}
		}
		//查找商品类型
		List<ShopTypes> shopTypes = selectShopTypeOrderBySorder();
		if(shopTypes==null||shopTypes.size()==0){
			json.put("success", true);
			json.put("error", "暂无商品信息");
			json.put("data", "");
			json.put("integral",integral);
			json.put("use_integral", use_integral);
			json.put("recommend_shop", "");
			json.put("userinfo", users);
			return json.toString();
		}
		  //商城活动
		
//        $shop_activity = ShopActivity::select('id', 'name', 'url')
//            ->orderBy('order', 'asc')
//            ->orderBy('created_at', 'desc')
//            ->where('is_close', 1)
//            ->where('order', '<=', 4)
//            ->take(4)
//            ->get();
		
		return null;
	}

	@Override
	@Transactional()
	public String getShopMore(String token) {
		JSONObject json = new JSONObject();

		if (token == null || (token != null && "".equals(token))) {
			json.put("success", false);
			json.put("error", "logout");
			json.put("message", "请重新登录");
			return json.toString();
		}
		
		
		return null;
	}
}
