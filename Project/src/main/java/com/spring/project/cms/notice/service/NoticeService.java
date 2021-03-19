package com.spring.project.cms.notice.service;

import java.util.Map;

public interface NoticeService {
	Map<String, Object> selectNoticeList(Map<String, Object> vo) throws Exception;
	
	Map<String, Object> selectNoticeOne(Map<String, Object> vo) throws Exception;
	
	Map<String, Object> selectNoticeLastOne(Map<String, Object> vo) throws Exception;
	
	Map<String, Object> selectFileCnt(Map<String, Object> vo) throws Exception;
	
	Map<String, Object> selectFileList(Map<String, Object> vo) throws Exception;
	
	void insertNotice(Map<String, Object> vo) throws Exception;
	
	void updateNotice(Map<String, Object> vo) throws Exception;
	
	void deleteNotice(Map<String, Object> vo) throws Exception;
	
	void insertFile(Map<String, Object> vo) throws Exception;
	
	Integer deleteFile(Map<String, Object> vo) throws Exception;
}
