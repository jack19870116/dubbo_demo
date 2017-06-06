package com.tiancaibao.service.wechat;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.wechat.WeixinMenuMapper;
import com.tiancaibao.pojo.wechat.WeixinMenu;
import com.tiancaibao.pojo.wechat.WeixinMenuExample;
import com.tiancaibao.service.interfaces.wechat.IWeixinMenuService;

@Service("weixinmenuService")
public class WeixinmenuServiceImpl implements IWeixinMenuService {
	@Resource
	private WeixinMenuMapper weixinmenuMapper;
	
	@Transactional(readOnly=true)
	@Override
	public List<WeixinMenu> selectWeixinmenuByIssonMenuAndOrderByMenuWeigh(String isson_menu, String menu_weigh) {
		WeixinMenuExample we = new WeixinMenuExample();
		we.setOrderByClause("menu_weigh "+menu_weigh);
		we.createCriteria().andIssonMenuEqualTo(isson_menu);
		List<WeixinMenu> welist = weixinmenuMapper.selectByExample(we);
		return welist;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<WeixinMenu> selectWeixinmenuByNotIssonMenuAndParentIdAndOrderByMenuWeigh(String not_isson_menu,
			Integer parent_id, String menu_weigh) {
		WeixinMenuExample we = new WeixinMenuExample();
		we.setOrderByClause("menu_weigh "+menu_weigh);
		we.createCriteria().andIssonMenuNotEqualTo("0").andParentIdEqualTo(parent_id.longValue());
		List<WeixinMenu> wmlist = weixinmenuMapper.selectByExample(we);
		return wmlist;
	}

}
