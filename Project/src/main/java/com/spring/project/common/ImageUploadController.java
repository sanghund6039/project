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
		// 한글깨짐을 방지하기위해 문자셋 설정
        response.setCharacterEncoding("utf-8");
 
        // 마찬가지로 파라미터로 전달되는 response 객체의 한글 설정
        response.setContentType("text/html; charset=utf-8");
 
        // 업로드한 파일 이름
        String fileName = upload.getOriginalFilename();
 
        // 파일을 바이트 배열로 변환
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
    			System.out.println("파일생성");
    		    saveFolder.mkdirs();
    		}
    		
    		OutputStream out = new FileOutputStream(new File(changePath + fileName));
            out.write(bytes);
        }catch(Exception e) {
        	System.out.println("err");
        }
        
        // 클라이언트에 결과 표시
        String callback = request.getParameter("CKEditorFuncNum");
 
        // 서버=>클라이언트로 텍스트 전송(자바스크립트 실행)
        PrintWriter printWriter = response.getWriter();
        String fileUrl = request.getContextPath() + "/resource/upload/editor/" + fileName;
        printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + fileUrl
                + "','이미지가 업로드되었습니다.')" + "</script>");
        printWriter.flush();
	}
}
