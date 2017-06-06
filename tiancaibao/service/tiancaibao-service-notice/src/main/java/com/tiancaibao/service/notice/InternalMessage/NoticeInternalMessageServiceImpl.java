package com.tiancaibao.service.notice.InternalMessage;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.tiancaibao.mapper.notice.NoticeInternalMessageMapper;
import com.tiancaibao.pojo.notice.NoticeInternalMessage;
import com.tiancaibao.pojo.notice.NoticeInternalMessageExample;
import com.tiancaibao.service.interfaces.notice.INoticeInternalMessageService;
import com.tiancaibao.utils.page.Pagination;

@Service("internalMessageService")
public class NoticeInternalMessageServiceImpl implements INoticeInternalMessageService {
	@Resource
	NoticeInternalMessageMapper noticeInternalMessageMapper;
	
	/**
	 * 发送站内信
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public void insertNotice(Long userId, String title, String info, Byte status, String remark) {

		NoticeInternalMessage notice = new NoticeInternalMessage();
		notice.setUserId(userId);
		notice.setTitle(title);
		notice.setInfo(info);
		notice.setStatus(status);
		notice.setRemark(remark);
		notice.setCreatedAt(new Date());
		notice.setUpdatedAt(new Date());
		noticeInternalMessageMapper.insertSelective(notice);
	}

	/**
	 * 更新站内信状态
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public int updateNoticeByUserId(Long userId) {

		// 更新站内信状态
		NoticeInternalMessageExample example = new NoticeInternalMessageExample();
		example.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo((byte) 0);
		NoticeInternalMessage record = new NoticeInternalMessage();
		record.setStatus((byte) 1);
		int updateResult = noticeInternalMessageMapper.updateByExampleSelective(record, example);
		return updateResult;
	}

	@Override
	public Pagination selectNoticesByUserIdWithPage(Integer currPage, Integer pageSize, Long userId) {
		if (currPage == null) {
			currPage = 1;
		}
		if (pageSize == null) {
			pageSize = 20;
		}
		NoticeInternalMessageExample noe = new NoticeInternalMessageExample();
		noe.createCriteria().andUserIdEqualTo(userId);
		noe.setOrderByClause("created_at desc");
		noe.setPageNo(currPage);
		noe.setPageSize(pageSize);
		long totalCount = noticeInternalMessageMapper.countByExample(noe);
		List<NoticeInternalMessage> list = noticeInternalMessageMapper.selectByExample(noe);
		Pagination pagination = new Pagination(currPage, pageSize, (int) totalCount, list);
		return pagination;
	}

	@Override
	public NoticeInternalMessage selectNoticesByUserIdAndTitle(Long userId, String title) {
		NoticeInternalMessageExample noe = new NoticeInternalMessageExample();
		noe.createCriteria().andUserIdEqualTo(userId).andTitleEqualTo(title);
		List<NoticeInternalMessage> list = noticeInternalMessageMapper.selectByExample(noe);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public NoticeInternalMessage selectNoticesByUserIdAndInfo(Long userId, String info) {
		NoticeInternalMessageExample noe = new NoticeInternalMessageExample();
		noe.createCriteria().andUserIdEqualTo(userId);
		NoticeInternalMessage record = new NoticeInternalMessage();
		record.setInfo(info);
		List<NoticeInternalMessage> list = noticeInternalMessageMapper.selectByall(record, noe);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public NoticeInternalMessage selectNoticesByIdAndUserId(Long id, Long userId) {
		NoticeInternalMessageExample noe = new NoticeInternalMessageExample();
		noe.createCriteria().andIdEqualTo(id).andUserIdEqualTo(userId);
		List<NoticeInternalMessage> list = noticeInternalMessageMapper.selectByExample(noe);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public NoticeInternalMessage selectNoticesByGreaterThanIdAndUserId(Long id, Long userId) {
		NoticeInternalMessageExample noe = new NoticeInternalMessageExample();
		noe.createCriteria().andIdGreaterThan(id).andUserIdEqualTo(userId);
		List<NoticeInternalMessage> list = noticeInternalMessageMapper.selectByExample(noe);
		System.out.println(list);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public NoticeInternalMessage selectNoticesByLessThanIdAndUserIdAndOrderById(Long id, Long userId) {
		NoticeInternalMessageExample noe = new NoticeInternalMessageExample();
		noe.createCriteria().andIdLessThan(id).andUserIdEqualTo(userId);
		noe.setOrderByClause("id desc");
		List<NoticeInternalMessage> list = noticeInternalMessageMapper.selectByExample(noe);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public NoticeInternalMessage selectNoticesByUserIdAndStatus(Long userId, Byte status) {
		NoticeInternalMessageExample noe = new NoticeInternalMessageExample();
		noe.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo(status);
		List<NoticeInternalMessage> list = noticeInternalMessageMapper.selectByExample(noe);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public NoticeInternalMessage selectNoticesByUserIdAndTitleAndRemark(Long userId, String title, String remark) {
		NoticeInternalMessageExample noe = new NoticeInternalMessageExample();
		noe.createCriteria().andUserIdEqualTo(userId).andTitleEqualTo(title).andRemarkEqualTo(remark);
		List<NoticeInternalMessage> list = noticeInternalMessageMapper.selectByExample(noe);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public NoticeInternalMessage selectNoticesByall(NoticeInternalMessageExample noe) {
		List<NoticeInternalMessage> selectByExampleWithBLOBs = noticeInternalMessageMapper
				.selectByExample(noe);
		return selectByExampleWithBLOBs.size() == 0 ? null : selectByExampleWithBLOBs.get(0);
	}
}
