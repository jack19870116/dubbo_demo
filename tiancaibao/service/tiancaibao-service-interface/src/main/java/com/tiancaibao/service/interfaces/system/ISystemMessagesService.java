package com.tiancaibao.service.interfaces.system;

import java.util.Date;
import java.util.List;

import com.tiancaibao.pojo.system.SystemMessages;

public interface ISystemMessagesService {
	
	/**
	 * 获取指定ID区间的消息
	 * @param start_id
	 * @param end_id
	 * @return
	 */
	List<SystemMessages> selectMessagesListByIdBetween(Long start_id, Long end_id);
	
	/**
	 * 分页排序（ID排序）返回大于指定结束日期的所有公告
	 * @param end_at
	 * @param order
	 * @param currpage
	 * @param pageSize
	 * @return
	 */
	List<SystemMessages> selectMessagesListByGreaterThanOrEqualToEndAtAndOrderByIdWithPage(Date end_at, String order, Integer currpage, Integer pageSize);

	/**
	 * 分页排序（创建时间排序）返回大于指定结束日期的所有公告
	 * @param end_at
	 * @param order
	 * @param currpage
	 * @param pageSize
	 * @return
	 */
	List<SystemMessages> selectMessagesListByGreaterThanOrEqualToEndAtAndOrderByCreateAtWithPage(Date end_at, String order, Integer currpage, Integer pageSize);
	
	/**
	 * 分页排序（创建时间排序）返回所有公告
	 * @param order
	 * @param currpage
	 * @param pageSize
	 * @return
	 */
	List<SystemMessages> selectMessagesListOrderByCreateAtWithPage(String order, Integer currpage, Integer pageSize);
	
	/**
	 * 根据ID返回一条公告
	 * @param messageId
	 * @return
	 */
	SystemMessages selectMessagesById(Long messages_id);

	/**
	 * 返回该ID的上一条公告
	 * @param messageId
	 * @return
	 */
	SystemMessages selectMessagesByGreaterThanId(Long messages_id);

	/**
	 * 返回该ID的下一条公告
	 * @param messageId
	 * @param order
	 * @return
	 */
	SystemMessages selectMessagesByLessThanIdAndOrderById(Long messages_id, String order);
	
	
}
