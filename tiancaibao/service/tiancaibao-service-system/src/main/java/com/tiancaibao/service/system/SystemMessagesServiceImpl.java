package com.tiancaibao.service.system;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.system.SystemMessagesMapper;
import com.tiancaibao.pojo.system.SystemMessages;
import com.tiancaibao.pojo.system.SystemMessagesExample;
import com.tiancaibao.service.interfaces.system.ISystemMessagesService;


@Service("systemMessagesService")
public class SystemMessagesServiceImpl implements ISystemMessagesService{
	
	@Resource
	private SystemMessagesMapper MessagesMapper;
	
	@Override
	public List<SystemMessages> selectMessagesListByIdBetween(Long start_id, Long end_id){
		SystemMessagesExample me = new SystemMessagesExample();
		if ((start_id != null && !start_id.equals("")) && (end_id != null && !start_id.equals(""))) {
			me.createCriteria().andIdBetween(start_id, end_id);
		}
		return MessagesMapper.selectByExample(me);
	}
	
	@Override
	public List<SystemMessages> selectMessagesListByGreaterThanOrEqualToEndAtAndOrderByIdWithPage(Date end_at, String order, Integer currpage, Integer pageSize){
		if (pageSize != null) {
			pageSize = 10;
		}
		SystemMessagesExample me = new SystemMessagesExample();
		me.createCriteria().andEndAtGreaterThanOrEqualTo(end_at);
		me.setPageNo(currpage);
		me.setPageSize(pageSize);
		me.setOrderByClause("id " + order);
		return MessagesMapper.selectByExample(me);
	}
	
	@Override
	public List<SystemMessages> selectMessagesListByGreaterThanOrEqualToEndAtAndOrderByCreateAtWithPage(Date end_at, String order, Integer currpage, Integer pageSize){
		if (pageSize != null) {
			pageSize = 10;
		}
		SystemMessagesExample me = new SystemMessagesExample();
		me.createCriteria().andEndAtGreaterThanOrEqualTo(end_at);
		me.setPageNo(currpage);
		me.setPageSize(pageSize);
		me.setOrderByClause("created_at " + order);
		return MessagesMapper.selectByExample(me);
	}
	
	@Override
	public List<SystemMessages> selectMessagesListOrderByCreateAtWithPage(String order, Integer currpage, Integer pageSize){
		if (pageSize != null) {
			pageSize = 10;
		}
		SystemMessagesExample me = new SystemMessagesExample();
		me.setPageNo(currpage);
		me.setPageSize(pageSize);
		me.setOrderByClause("created_at " + order);
		return MessagesMapper.selectByExample(me);
	}
	
	@Override
	public SystemMessages selectMessagesById(Long messages_id) {
		SystemMessagesExample me = new SystemMessagesExample();
		me.createCriteria().andIdEqualTo(messages_id);
		List<SystemMessages> messageslist = MessagesMapper.selectByExample(me);
		if (messageslist != null && messageslist.size() == 1) {
			return messageslist.get(0);
		}
		return null;
	}
	
	@Override
	public SystemMessages selectMessagesByGreaterThanId(Long messages_id) {
		SystemMessagesExample me = new SystemMessagesExample();
		me.createCriteria().andIdGreaterThan(messages_id);
		List<SystemMessages> messageslist = MessagesMapper.selectByExample(me);
		if (messageslist != null  && messageslist.size() > 0) {
			return messageslist.get(0);
		}
		return null;
	}
	
	@Override
	public SystemMessages selectMessagesByLessThanIdAndOrderById(Long messages_id, String order){
		SystemMessagesExample ne = new SystemMessagesExample();
		ne.setOrderByClause("id " + order);
		ne.createCriteria().andIdLessThan(messages_id);
		List<SystemMessages> messageslist = MessagesMapper.selectByExample(ne);
		if (messageslist != null  && messageslist.size() > 0) {
			return messageslist.get(0);
		}
		return null;
	}
}
