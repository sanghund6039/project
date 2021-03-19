package com.spring.project.cms.auth.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.spring.project.cms.auth.service.UserService;
import com.spring.project.cms.auth.vo.LoginVO;
import com.spring.project.common.CommonAct;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userMapper")
    private UserMapper userMapper;
	
	@Override
	public LoginVO actionLogin(LoginVO vo, HttpServletRequest request) throws Exception {

    	// 1. 입력한 비밀번호를 암호화한다.
		String enpassword = CommonAct.encryptPassword(vo.getAuthPw(), vo.getAuthId());
		vo.setAuthPw(enpassword);

    	// 2. 아이디와 암호화된 비밀번호가 DB와 일치하는지 확인한다.
    	LoginVO loginVO = userMapper.actionLogin(vo);

    	return loginVO;
    }
	
	
}
