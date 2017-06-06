package com.tiancaibao.service.interfaces.shop;

import com.tiancaibao.pojo.user.Users;

public interface ICommodityExchangeService {
	void commodityexchange(Users user, Integer shop_num, Integer gquantity, Integer sprice, Object object,Integer type_id);

}
