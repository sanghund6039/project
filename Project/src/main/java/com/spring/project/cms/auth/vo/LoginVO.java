package com.spring.project.cms.auth.vo;

import java.io.Serializable;

public class LoginVO implements Serializable{
	private static final long serialVersionUID = -8274004534207618049L;
	
	/** ���̵� */
	private String authId;
	/** ��й�ȣ */
	private String authPw;
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getAuthPw() {
		return authPw;
	}
	public void setAuthPw(String authPw) {
		this.authPw = authPw;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
