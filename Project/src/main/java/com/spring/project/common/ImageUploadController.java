package com.spring.project.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageUploadController {
	
	@RequestMapping("imageUpload.do")
	public void imageUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload) throws Exception{
		// �ѱ۱����� �����ϱ����� ���ڼ� ����
        response.setCharacterEncoding("utf-8");
 
        // ���������� �Ķ���ͷ� ���޵Ǵ� response ��ü�� �ѱ� ����
        response.setContentType("text/html; charset=utf-8");
 
        // ���ε��� ���� �̸�
        String fileName = upload.getOriginalFilename();
 
        // ������ ����Ʈ �迭�� ��ȯ
        byte[] bytes = upload.getBytes();
        
        //String uploadPath = "C:/Users/LeeSangHun/Documents/workspace-spring-tool-suite-4-4.9.0.RELEASE/Project/src/main/webapp/resources/images/";

        String uploadPath = request.getSession().getServletContext().getRealPath("/"); // + "resources/upload/editor/";
        System.out.println("uploadPath == > "  + uploadPath);
        System.out.println("request.getContextPath() == ?> " + request.getContextPath());
        
        String changePath = uploadPath.substring(0,uploadPath.indexOf(".metadata")) + "project/Project/src/main/webapp/resources/upload/editor/";
        System.out.println("changePath == > " + changePath);
        try {
        	File saveFolder = new File(changePath);
        	
    		if (!saveFolder.exists() || saveFolder.isFile()) {
    			System.out.println("���ϻ���");
    		    saveFolder.mkdirs();
    		}
    		
    		OutputStream out = new FileOutputStream(new File(changePath + fileName));
            out.write(bytes);
        }catch(Exception e) {
        	System.out.println("err");
        }
        
        // Ŭ���̾�Ʈ�� ��� ǥ��
        String callback = request.getParameter("CKEditorFuncNum");
 
        // ����=>Ŭ���̾�Ʈ�� �ؽ�Ʈ ����(�ڹٽ�ũ��Ʈ ����)
        PrintWriter printWriter = response.getWriter();
        String fileUrl = request.getContextPath() + "/resource/upload/editor/" + fileName;
        printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + fileUrl
                + "','�̹����� ���ε�Ǿ����ϴ�.')" + "</script>");
        printWriter.flush();
	}
}
