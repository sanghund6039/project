package com.spring.project.front.notice.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.project.front.notice.service.FrontNoticeService;

@Controller
@RequestMapping("/front")
public class FrontNoticeController {
	
	private String CONTENT_PATH = "/WEB-INF/views/jsp/front/";
	
	@Resource(name="frontNoticeService")
	private FrontNoticeService frontNoticeService;
	
	@RequestMapping(value="/notice.do", method=RequestMethod.GET)
	public String noticeList(@RequestParam Map<String, Object> paramMap,
			ModelMap model, HttpServletRequest request) throws Exception{
		
		if(paramMap.get("pageIndex") == null){
			paramMap.put("pageIndex",1);
		}
		
		if(paramMap.get("pageUnit") == null){
			paramMap.put("pageUnit",10);
		}
		
		if(paramMap.get("pageSize") == null){
			paramMap.put("pageSize",10);
		}
		System.out.println("paramMap == > " + paramMap.toString());
		Map<String, Object> map = frontNoticeService.selectNoticeList(paramMap);
		
		model.addAttribute("resultList", map.get("resultList"));
		model.addAttribute("resultCnt", map.get("resultCnt"));
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("title", "공지사항");
		model.addAttribute("contentFile", CONTENT_PATH + "notice/notice_list.jsp");
		return "/front/include/main_layout";
	}
	
	@RequestMapping(value="/noticeView.do", method=RequestMethod.GET)
	public String noticeView(@RequestParam Map<String, Object> paramMap,
			ModelMap model, HttpServletRequest request) throws Exception{
		
		frontNoticeService.updateNoticeCnt(paramMap);
		Map<String, Object> map = frontNoticeService.selectNoticeOne(paramMap);
		System.out.println("paramMap == > " + paramMap.toString());
		
		Map<String, Object> filemap = frontNoticeService.selectFileList(paramMap);
		model.addAttribute("filemap", filemap);
		
		model.addAttribute("result", map);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("title", "공지사항");
		model.addAttribute("contentFile", CONTENT_PATH + "notice/notice_view.jsp");
		return "/front/include/main_layout";
	}
	
	
	
}
