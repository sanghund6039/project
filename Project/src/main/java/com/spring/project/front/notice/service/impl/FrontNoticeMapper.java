package com.spring.project.front.notice.service.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

@MapperScan("frontNoticeMapper")
public interface FrontNoticeMapper {
	
	Integer selectNoticeListCnt(Map<String, Object> vo) throws Exception;

	List<Map<String, Object>> selectNoticeList(Map<String, Object> vo) throws Exception;
	
	Map<String, Object> selectNoticeOne(Map<String, Object> vo) throws Exception;
	
	Map<String, Object> selectFileList(Map<String, Object> vo) throws Exception;
	
	void updateNoticeCnt(Map<String, Object> vo) throws Exception;

}
