package com.tiancaibao.service.interfaces.shop;

import java.util.List;

import com.tiancaibao.pojo.shop.ShopIndents;
import com.tiancaibao.pojo.shop.ShopRegions;
import com.tiancaibao.pojo.shop.ShopTypes;
import com.tiancaibao.pojo.shop.Shops;
import com.tiancaibao.utils.page.Pagination;

public interface IShopService {

	/**
	 * 获取商城商品分类
	 * @return
	 */
	List<ShopTypes> selectShopTypeOrderBySorder();
	
	/**
	 * 获取商城商品信息
	 * @param shopTypeId
	 * @param sisshop
	 * @param limitnum
	 * @return
	 */
	List<Shops> selectShopByShopClassIdAndSisShopLimitNum(Integer shopTypeId, byte sisshop, int limitnum);

	/**
	 * 获取某一分类下的商品信息
	 * @param type_id
	 * @param sisshop
	 * @return
	 */
	List<Shops> selectShopByShopClassIdAndSisShop(Integer type_id, byte sisshop);
	
	Pagination selectShopByShopClassIdAndSisShopWithPage(Integer currPage, Integer pageSize, Integer type_id, byte sisshop);

	List<ShopIndents> selectShopIndentListLimit(int limitnum);

	Shops selectShopByShopClassIdAndSisShopAndId(Integer type_id, byte b, Integer id);

	List<ShopTypes> selectShopTypeList();

	Pagination selectShopIndentByUserIdAndShopClassIdWithPage(Integer currPage, Integer pageSize, Long userid, byte shopclassid);

	Pagination selectShopIndentByUserIdAndShopClassIdNotInWithPage(Integer currPage, Integer pageSize, Long userid, byte ... shopclassid);

	Shops selectShopById(Integer id);

	List<ShopRegions> selectShopReionsByRegionTypeAndParentIdOrderByRegionId(int region_type, int parent_id, String orderby);

	Shops selectShopByShopClassIdAndId(Integer type_id, Integer id);
	
	List<Shops> selectShopByIsRecommendAndSisShopLimitNum(byte is_recommend, byte b, int limitnum);
	
	Pagination selectShopByShopClassIdAndChildClassIdAndSisShopWithPage(Integer currPage, Integer pageSize, Integer type_id, Integer child_class_id, byte sisshop);
	
	List<Shops> selectShopByShopClassIdAndSisShopAndIsRecommendLimitNum(Integer type_id, byte sisshop, byte is_recommend, int limitnum);
	
	List<Shops> selectShopBySisShopAndName(byte sisshop, String name);

	String goToShopIndex(String token);

	String getShopMore(String token);
}
