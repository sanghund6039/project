package com.spring.project.front.notice.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.project.front.notice.service.FrontNoticeService;

@Service("frontNoticeService")
public class FrontNoticeServiceImpl implements FrontNoticeService{

	@Resource(name="frontNoticeMapper")
	private FrontNoticeMapper frontNoticeMapper;


	@Override
	public Map<String, Object> selectNoticeList(Map<String, Object> vo) throws Exception {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		int cnt = frontNoticeMapper.selectNoticeListCnt(vo);
		if (cnt > 0) {
			result = frontNoticeMapper.selectNoticeList(vo);
		}

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("resultList", result);
		map.put("resultCnt", Integer.toString(cnt));

		return map;
	}
	
	@Override
	public Map<String, Object> selectNoticeOne(Map<String, Object> vo)
			throws Exception {
		return frontNoticeMapper.selectNoticeOne(vo);
	}
	
	@Override
	public Map<String, Object> selectFileList(Map<String, Object> vo)
			throws Exception {
		return frontNoticeMapper.selectFileList(vo);
	}
	
	@Override
	public void updateNoticeCnt(Map<String, Object> vo) throws Exception {
		frontNoticeMapper.updateNoticeCnt(vo);		
	}
	
}
