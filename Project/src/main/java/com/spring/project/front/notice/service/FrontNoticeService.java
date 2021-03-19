package com.spring.project.front.notice.service;

import java.util.Map;

public interface FrontNoticeService {
	
	Map<String, Object> selectNoticeList(Map<String, Object> vo) throws Exception;
	
	Map<String, Object> selectNoticeOne(Map<String, Object> vo) throws Exception;
	
	Map<String, Object> selectFileList(Map<String, Object> vo) throws Exception;
	
	void updateNoticeCnt(Map<String, Object> vo) throws Exception;
}
