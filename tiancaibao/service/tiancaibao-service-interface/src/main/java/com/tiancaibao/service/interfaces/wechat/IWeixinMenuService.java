package com.tiancaibao.service.interfaces.wechat;

import java.util.List;

import com.tiancaibao.pojo.wechat.WeixinMenu;

public interface IWeixinMenuService {

	List<WeixinMenu> selectWeixinmenuByIssonMenuAndOrderByMenuWeigh(String isson_menu, String menu_weigh);

	List<WeixinMenu> selectWeixinmenuByNotIssonMenuAndParentIdAndOrderByMenuWeigh(String not_isson_menu, Integer parent_id,
			String menu_weigh);

}
