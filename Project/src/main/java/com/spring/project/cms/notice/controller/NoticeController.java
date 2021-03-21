package com.spring.project.cms.notice.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.project.cms.notice.service.NoticeService;
import com.spring.project.common.service.FileUtil;
import com.spring.project.common.service.FileVO;

@Controller
@RequestMapping("/cms/notice")
public class NoticeController {
	
	private String CONTENT_PATH = "/WEB-INF/views/jsp/cms/";
	
	@Resource(name="noticeService")
	private NoticeService noticeService;
	
	@RequestMapping(value="/noticeList.do", method=RequestMethod.GET)
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
		Map<String, Object> map = noticeService.selectNoticeList(paramMap);
		
		model.addAttribute("resultList", map.get("resultList"));
		model.addAttribute("resultCnt", map.get("resultCnt"));
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("title", "공지사항");
		model.addAttribute("contentFile", CONTENT_PATH + "notice/notice_list.jsp");
		return "/cms/include/main_layout";
	}
	
	@RequestMapping(value="/noticeWrite.do", method=RequestMethod.GET)
	public String noticeWrite(@RequestParam Map<String, Object> paramMap,
			ModelMap model, HttpServletRequest request) throws Exception{

		if(paramMap.get("command").equals("insert")) {
			model.addAttribute("title", "공지사항 작성");
		}else {
			Map<String, Object> map = noticeService.selectNoticeOne(paramMap);
			model.addAttribute("map", map);
			model.addAttribute("title", "공지사항 수정");
			
			Map<String, Object> filemap = noticeService.selectFileList(paramMap);
			model.addAttribute("filemap", filemap);
		}
		
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("contentFile", CONTENT_PATH + "notice/notice_write.jsp");
		return "/cms/include/main_layout";
	}
	
	@RequestMapping(value="/noticeWriteAct.do", method=RequestMethod.POST)
	public String noticeWriteAct(@RequestParam Map<String, Object> paramMap,
			MultipartHttpServletRequest multiRequest,
			@RequestParam(value="command", required=true, defaultValue="insert") String command,
			ModelMap model, HttpServletRequest request) throws Exception{
		
		if(paramMap.get("topYn") != null) {
			paramMap.put("topYn", "Y");
		}else {
			paramMap.put("topYn", "N");
		}
		
		String message = "";
		if ("insert".equals(command)) {
			message = "success.common.insert";
			noticeService.insertNotice(paramMap);
		}else {
			message = "success.common.update";
    		//paramMap.put("uptId", user.getId());
			noticeService.updateNotice(paramMap);
		}
		model.addAttribute("message", message);
		model.addAttribute("returnUrl", "/cms/notice/noticeList.do");
		
		if ("insert".equals(command)) {
			Map<String, Object> map = noticeService.selectNoticeLastOne(paramMap);
			paramMap.put("boardId", map.get("BOARD_ID"));
		}
		
		FileVO uploadFileVO = uploadPhotoFile(multiRequest, "imageFile", request);
		if (uploadFileVO != null) {
			paramMap.put("fileNm", uploadFileVO.getOrignlFileNm());
			paramMap.put("fileUrl", "/uploads/notice/");
    		paramMap.put("fileFullUrl", "/uploads/notice/" + uploadFileVO.getOrignlFileNm());
    		
    		Map<String, Object> map = noticeService.selectFileCnt(paramMap);
    		int cnt = Integer.parseInt(map.get("resultCnt").toString());
    		System.out.println("cnt = > " + cnt);
    		
    		if(cnt > 0) {
    			int deleteFile = noticeService.deleteFile(paramMap);
    			if(deleteFile > 0) {
    				noticeService.insertFile(paramMap);
    			}
    		}else {
    			noticeService.insertFile(paramMap);
    		}
    	}
		
		return "/cms/notice/notice_result";
	}
	
	@RequestMapping(value="/noticeDelete.do", method=RequestMethod.POST)
	public String noticeDelete(@RequestParam Map<String, Object> paramMap,
			ModelMap model) throws Exception {

		Map<String, Object> map = noticeService.selectNoticeOne(paramMap);
		String message = "";
		if(map != null) {
			message = "success.common.delete";
			noticeService.deleteNotice(paramMap);
		}else {
			message = "success.common.nodata";
		}
		model.addAttribute("message", message);
		model.addAttribute("returnUrl", "/cms/notice/noticeList.do");

		return "/cms/notice/notice_result";
	}
	
	private FileVO uploadPhotoFile(MultipartHttpServletRequest multiRequest, String name, HttpServletRequest request) throws Exception {
	    String uploadPath = request.getSession().getServletContext().getRealPath("/") + "resources/upload/notice/";
	    System.out.println("uploadPath == > " + uploadPath);
	    
	    String changePath = uploadPath.substring(0,uploadPath.indexOf(".metadata")) + "project/Project/src/main/webapp/resources/upload/notice/";
	    
	    String atchFileId = "-1";
	    List<MultipartFile> atchFile = multiRequest.getFiles(name);
	    
	    List<FileVO> atchFileList = null;
	    try
	    {
	    	atchFileList = FileUtil.parseFileInf(atchFile, "", 0, atchFileId, changePath, "gif,jpg,jpeg,png,zip,hwp,docx,pdf,xls,xlsx,txt", 20);
	    }
	    catch (Exception e)
	    {
	    	System.out.println(e);
	    }
	    return (atchFileList != null) && (atchFileList.size() > 0) ? (FileVO)atchFileList.get(0) : null;
	}
}
