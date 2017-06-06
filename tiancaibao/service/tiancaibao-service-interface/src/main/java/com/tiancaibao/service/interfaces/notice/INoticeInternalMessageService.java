package com.tiancaibao.service.interfaces.notice;

import com.tiancaibao.pojo.notice.NoticeInternalMessage;
import com.tiancaibao.pojo.notice.NoticeInternalMessageExample;
import com.tiancaibao.utils.page.Pagination;

public interface INoticeInternalMessageService {
	
	/**
	 * 向站内信记录表插入一条记录
	 * @param userId
	 * @param title
	 * @param info
	 * @param status
	 * @param remark
	 * @return
	 */
	public void insertNotice(Long userId, String title, String info, Byte status, String remark);
	
	/**
	 * 更改站内信状态
	 * @param userId
	 */
	public int updateNoticeByUserId(Long userId);
	
	/**
	 * 查询,站内信消息列表
	 * @param currPage
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	Pagination selectNoticesByUserIdWithPage(Integer currPage, Integer pageSize, Long userId);
	
	/**
	 * 根据标题和用户id查找数据
	 * @param userId
	 * @param title
	 * @return
	 */
	NoticeInternalMessage selectNoticesByUserIdAndTitle(Long userId, String title);
	
	/**
	 * 根据内容和用户id查找数据
	 * @param userId
	 * @param info
	 * @return
	 */
	NoticeInternalMessage selectNoticesByUserIdAndInfo(Long userId, String info);
	
	/**
	 * 根据id和用户id查找数据
	 * @param userId
	 * @param id
	 * @return
	 */
	NoticeInternalMessage selectNoticesByIdAndUserId(Long id, Long userId);

	/**
	 * 返回该ID的上一条公告
	 * @param userId
	 * @param id
	 * @return
	 */
	NoticeInternalMessage selectNoticesByGreaterThanIdAndUserId(Long id, Long userId);
	
	/**
	 * 返回该ID的下一条公告
	 * @param userId
	 * @param id
	 * @return
	 */
	NoticeInternalMessage selectNoticesByLessThanIdAndUserIdAndOrderById(Long id, Long userId);
	
	/**
	 * 查找用户某个状态的数据
	 * @param userId
	 * @param status
	 * @return
	 */
	NoticeInternalMessage selectNoticesByUserIdAndStatus(Long userId, Byte status);
	
	/**
	 * 查找title、用户ID、remark查询数据
	 * @param userId
	 * @param title
	 * @param remark
	 * @return
	 */
	NoticeInternalMessage selectNoticesByUserIdAndTitleAndRemark(Long userId, String title, String remark);
	
	
	/**
	 * 
	 */
	NoticeInternalMessage selectNoticesByall(NoticeInternalMessageExample noe);
	
	
}
