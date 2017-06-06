package com.tiancaibao.controller.notice;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.notice.biz.INoteiceInternalMessageBizMqSmsService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Resource
	private INoteiceInternalMessageBizMqSmsService internalMessageBizService;

	@RequestMapping(value = "/noticeList.do", method = { RequestMethod.POST })
	@ResponseBody
	public String noticeList(Long userId, Integer currpage, Integer pageSize) {
		return internalMessageBizService.noticeList(userId, currpage, pageSize);
	}
	

	@RequestMapping(value = "/noticeDetails.do", method = { RequestMethod.POST })
	@ResponseBody
	public String noticeDetails(Long id, Long userId) {
		return internalMessageBizService.noticeDetails(id, userId);
	}
	
	@RequestMapping(value = "/updateNotice.do", method = { RequestMethod.POST })
	@ResponseBody
	public String updateNotice(Long userId) {
		return internalMessageBizService.updateNotice(userId);
	}
}
