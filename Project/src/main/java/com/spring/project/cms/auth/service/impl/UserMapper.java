package com.spring.project.cms.auth.service.impl;

import org.mybatis.spring.annotation.MapperScan;

import com.spring.project.cms.auth.vo.LoginVO;

@MapperScan("userMapper")
public interface UserMapper {
	
	LoginVO actionLogin(LoginVO vo) throws Exception;
}
