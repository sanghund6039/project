package com.spring.project.cms.notice.service.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

@MapperScan("noticeMapper")
public interface NoticeMapper {
	
	Integer selectNoticeListCnt(Map<String, Object> vo) throws Exception;

	List<Map<String, Object>> selectNoticeList(Map<String, Object> vo) throws Exception;
	
	Map<String, Object> selectNoticeOne(Map<String, Object> vo) throws Exception;
	
	Map<String, Object> selectNoticeLastOne(Map<String, Object> vo) throws Exception;
	
	Integer selectFileCnt(Map<String, Object> vo) throws Exception;
	
	List<Map<String, Object>> selectFileList(Map<String, Object> vo) throws Exception;
	
	void insertNotice(Map<String, Object> vo) throws Exception;
	
	void updateNotice(Map<String, Object> vo) throws Exception;
	
	void deleteNotice(Map<String, Object> vo) throws Exception;
	
	void insertFile(Map<String, Object> vo) throws Exception;
	
	Integer deleteFile(Map<String, Object> vo) throws Exception;
}
