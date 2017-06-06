package com.tiancaibao.service.user;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.tiancaibao.mapper.user.UserBlackListsMapper;
import com.tiancaibao.pojo.user.UserBlackLists;
import com.tiancaibao.pojo.user.UserBlackListsExample;
import com.tiancaibao.service.interfaces.user.IUserBlackListService;


/**
 * dubbo服务实现类---黑名单---数据访问层
 * 
 * @author Mack 2017年2月4日 下午2:12:27
 */

@Service("userBlackListService")
public class UserBlackListServiceImpl implements IUserBlackListService {

	@Resource
	private UserBlackListsMapper blackListsMapper;
	
	private static final Logger log = LoggerFactory.getLogger(UserBlackListServiceImpl.class);
	/**
	 * 根据用户ID获取用户黑名单金额
	 * @param userId
	 * @param blacklistType
	 * @return
	 */
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	@Override
	public Long selectUserLockAmount(Long userId, Byte blacklistType) {
		try {
			UserBlackListsExample ble = new UserBlackListsExample();
			ble.createCriteria().andUserIdEqualTo(userId).andBlacklistTypeEqualTo(blacklistType).andDeletedAtIsNull();
			List<UserBlackLists> blacklistslist = blackListsMapper.selectByExample(ble);
			if (blacklistslist != null && blacklistslist.size()>0 && blacklistslist.get(0) != null) {
				log.info("使用参数userId= " + userId + " blacklistType= " + blacklistType + " 查询blacklist 黑名单金额结果是： " + (blacklistslist.get(0).getLockAmount() /10000 + "." +  blacklistslist.get(0).getLockAmount() % 10000)  +"\n");
				return blacklistslist.get(0).getLockAmount();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0L;
	}
	
	/**
	 * 根据用户ID和锁定类型查询用户黑名单表，返回一条记录
	 * @param userid
	 * @param blacklist_type
	 * @return
	 */
	
	@Transactional
	@Override
	public UserBlackLists selectBlackListsByUserIdAndBlacklistType(Long userid, Integer blacklist_type) {
		UserBlackListsExample ble = new UserBlackListsExample();
		ble.createCriteria().andUserIdEqualTo((long) userid.intValue()).andBlacklistTypeEqualTo(blacklist_type.byteValue());
		List<UserBlackLists> blacklistslist = blackListsMapper.selectByExample(ble);
		if (blacklistslist != null) {
			return blacklistslist.get(0);
		}
		return null;
	}
	
	@Transactional
	@Override
	public Integer insertUserBlackLists(UserBlackLists userBlackLists){
		int insert = blackListsMapper.insert(userBlackLists);
		if(insert>0){
			log.info("向userBlackLists表成功插入一条记录"+userBlackLists.toString());
			return insert;
		}else{
			log.info("向userBlackLists表插入一条记录失败 "+userBlackLists.toString() );
			return null;
		}
	}
	@Transactional
	@Override
	public Integer delectUserBlackLists(Integer userBlackLists_id) {
		
		UserBlackLists userBlackLists=new UserBlackLists();
		userBlackLists.setId(userBlackLists_id);
		userBlackLists.setDeletedAt(new Date());
		int updateByPrimaryKey = blackListsMapper.updateByPrimaryKeySelective(userBlackLists);
		
		if(updateByPrimaryKey>0){
			log.info("在userBlackLists表成功逻辑删除一条记录"+userBlackLists.toString());
			return updateByPrimaryKey;
			
		}else{
			log.info("在userBlackLists表逻辑删除一条记录失败"+userBlackLists.toString());
			return null;
		}
		
	}
}
