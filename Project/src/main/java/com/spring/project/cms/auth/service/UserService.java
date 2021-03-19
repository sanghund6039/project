package com.spring.project.cms.auth.service;

import javax.servlet.http.HttpServletRequest;

import com.spring.project.cms.auth.vo.LoginVO;

public interface UserService {
	LoginVO actionLogin(LoginVO vo, HttpServletRequest request) throws Exception;
}
