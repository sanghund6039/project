package com.spring.project.cms.notice.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.project.cms.notice.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Resource(name="noticeMapper")
	private NoticeMapper noticeMapper;


	@Override
	public Map<String, Object> selectNoticeList(Map<String, Object> vo) throws Exception {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		int cnt = noticeMapper.selectNoticeListCnt(vo);
		if (cnt > 0) {
			result = noticeMapper.selectNoticeList(vo);
		}

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("resultList", result);
		map.put("resultCnt", Integer.toString(cnt));

		return map;
	}
	
	@Override
	public Map<String, Object> selectNoticeOne(Map<String, Object> vo)
			throws Exception {
		return noticeMapper.selectNoticeOne(vo);
	}
	
	@Override
	public Map<String, Object> selectNoticeLastOne(Map<String, Object> vo)
			throws Exception {
		return noticeMapper.selectNoticeLastOne(vo);
	}
	
	@Override
	public Map<String, Object> selectFileCnt(Map<String, Object> vo) throws Exception {
		int cnt = noticeMapper.selectFileCnt(vo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("resultCnt", Integer.toString(cnt));
		
		return map;
	}
	
	@Override
	public Map<String, Object> selectFileList(Map<String, Object> vo) throws Exception {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = noticeMapper.selectFileList(vo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("resultList", result);
		
		return map;
	}
	
	@Override
	public void insertNotice(Map<String, Object> vo) throws Exception {
		noticeMapper.insertNotice(vo);		
	}
	
	@Override
	public void updateNotice(Map<String, Object> vo) throws Exception {
		noticeMapper.updateNotice(vo);		
	}
	
	@Override
	public void deleteNotice(Map<String, Object> vo) throws Exception {
		noticeMapper.deleteNotice(vo);		
	}
	
	@Override
	public void insertFile(Map<String, Object> vo) throws Exception {
		noticeMapper.insertFile(vo);		
	}
	
	@Override
	public Integer deleteFile(Map<String, Object> vo) throws Exception {
		return noticeMapper.deleteFile(vo);		
	}
}
