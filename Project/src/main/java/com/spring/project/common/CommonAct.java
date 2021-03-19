package com.spring.project.common;

import java.security.MessageDigest;
import org.apache.commons.codec.binary.Base64;

public class CommonAct {

	public static String encryptPassword(String password, String id) throws Exception {

		if (password == null) {
		    return "";
		}
	
		byte[] hashValue = null; // ÇØ½¬°ª
	
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		md.reset();
		md.update(id.getBytes());
		
		hashValue = md.digest(password.getBytes());
	
		return new String(Base64.encodeBase64(hashValue));
    }
}
