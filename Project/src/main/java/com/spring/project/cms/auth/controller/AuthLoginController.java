package com.spring.project.cms.auth.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.project.cms.auth.service.UserService;
import com.spring.project.cms.auth.vo.LoginVO;

@Controller
@RequestMapping("/auth")
public class AuthLoginController {
	
	@Resource(name="userService")
    UserService userService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login(@ModelAttribute("loginVO") LoginVO loginVO, HttpServletRequest request) throws Exception{
		
		return "/cms/auth/login";
	}
	
	@RequestMapping(value="/loginAction.do", method=RequestMethod.POST)
	public String loginAction(@ModelAttribute("loginVO") LoginVO loginVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) throws Exception{
		boolean flag = false;
		LoginVO resultVO = userService.actionLogin(loginVO, request);
		String goUrl = "";
		if(resultVO != null){
			flag = true;
			goUrl = "/cms/notice/noticeList.do";
		}
		String message = flag ? "auth.success" : "auth.fail";
		
		model.addAttribute("goUrl", goUrl);
		model.addAttribute("message", message);
		return "/cms/auth/login_result";
	}
}
