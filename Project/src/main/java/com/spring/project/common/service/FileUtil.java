package com.spring.project.common.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

    public static final int BUFF_SIZE = 2048;

    /**
     * 첨부파일에 대한 목록 정보를 취득한다.
     */
    public static List<FileVO> parseFileInf(List<MultipartFile> files,
    		String KeyStr, 
    		int fileKeyParam, 
    		String atchFileId, 
    		String storePath,
    		String limitFileExt,
    		int uploadSize) throws Exception {
    	
		int fileKey = fileKeyParam;
		
		String storePathString = storePath;
		String atchFileIdString = "";
		
		System.out.println("storePathString == > " + storePathString);
		File saveFolder = new File(storePathString);
	
		if (!saveFolder.exists() || saveFolder.isFile()) {
			System.out.println("파일생성");
		    saveFolder.mkdirs();
		}
	
		ArrayList<String> tmpList = new ArrayList<String>();
		
		MultipartFile file;
		String filePath = "";
		List<FileVO> result  = new ArrayList<FileVO>();
		FileVO fvo;
	
		int fileSn = -1;
		for (int i = 0; i < files.size(); i++)
		{
		    file = (MultipartFile)files.get(i);
		    String orginFileName = file.getOriginalFilename();
			orginFileName = orginFileName.replace("..", "");
			orginFileName = orginFileName.replace(";", "");
			orginFileName = orginFileName.replace("%", "");
			orginFileName = orginFileName.replace(" ", "");
					    		    		    
		    fileSn++;
		    
		    //--------------------------------------
		    // 원 파일명이 없는 경우 처리
		    // (첨부가 되지 않은 input file type)
		    //--------------------------------------
		    if ("".equals(orginFileName)) {
			continue;
		    }
		    ////------------------------------------
	
		    
		    System.out.println("확장자 체크 : " + orginFileName + " // " + limitFileExt);
		    // 업로드 사이즈 및 제한된 확장자 체크
			if ((!Upload_Filter(orginFileName).booleanValue()) || (!isPermitExt(orginFileName, limitFileExt))) 
			{
				for (int j = 0; j < tmpList.size(); j++)
				{
					String tmpFile = (String)tmpList.get(j);
					System.out.println(tmpFile);
					deleteFile(tmpFile);
				}
				throw new Exception("fail.upload.limitedFileExt");
			}
			
			// 메가바이트 
			System.out.println("메가바이트");
			long size = file.getSize();
			size /= 1000000L;
			if (uploadSize > 0 && size > uploadSize)
			{
				for (int j = 0; j < tmpList.size(); j++)
				{
					String tmpFile = (String)tmpList.get(j);
					deleteFile(tmpFile);
				}				
				throw new Exception("fail.upload.limitedFileSize");
			}		    
		    
		    int index = orginFileName.lastIndexOf(".");
		    //String fileName = orginFileName.substring(0, index);
		    String fileExt = orginFileName.substring(index + 1);
		    String newName = KeyStr + getTimeStamp() + fileKey + "." + fileExt;
		    long _size = file.getSize();
		    
		    if (!"".equals(orginFileName)) {
		    	filePath = storePathString + newName;
		    	System.out.println("filePath == > " + filePath);
				if("gif,jpg,jpeg,png".indexOf(fileExt.toLowerCase()) > -1){
					String orifilePath = storePathString + file.getOriginalFilename();
					System.out.println("orifilePath == " + orifilePath);
					file.transferTo(new File(orifilePath));
					
					/*
					 * BufferedImage originalImage = ImageIO.read(new File(orifilePath)); int type =
					 * originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB :
					 * originalImage.getType(); int width = originalImage.getWidth(); int height =
					 * originalImage.getHeight(); BufferedImage resizedImage = new
					 * BufferedImage(width, height, type); Graphics2D g =
					 * resizedImage.createGraphics(); g.drawImage(originalImage, 0, 0, width,
					 * height, null); g.dispose(); g.setComposite(AlphaComposite.Src);
					 * g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.
					 * VALUE_INTERPOLATION_BILINEAR);
					 * g.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.
					 * VALUE_RENDER_QUALITY);
					 * g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.
					 * VALUE_ANTIALIAS_ON); ImageIO.write(resizedImage, fileExt, new
					 * File(filePath));
					 */
					System.out.println("filesuccess");

				}else if("zip,hwp,docx,pdf,xls,xlsx,txt".indexOf(fileExt.toLowerCase()) > -1){
					System.out.println("file img other");
					String orifilePath = storePathString + file.getOriginalFilename();
					file.transferTo(new File(orifilePath));
				}
		    }
		    fvo = new FileVO();
		    fvo.setFileExtsn(fileExt);
		    fvo.setFileStreCours(storePath);
		    fvo.setFileMg(Long.toString(_size));
		    fvo.setOrignlFileNm(orginFileName);
		    fvo.setStreFileNm(newName);
		    fvo.setAtchFileId(atchFileIdString);
		    fvo.setFileSn(String.valueOf(fileSn));
		    
		    result.add(fvo);
		    tmpList.add(fvo.getFileStreCours() + fvo.getStreFileNm());
		    fileKey++;
		}
		
	
		return result;
    }

    
    public static String deleteFile(String fileDeletePath) {

		// 인자값 유효하지 않은 경우 블랭크 리턴
		if (fileDeletePath == null || fileDeletePath.equals("")) {
			return "";
		}
		String result = "";
		File file = new File(filePathBlackList(fileDeletePath));
		if (file.isFile()) {
			result = deletePath(fileDeletePath);
		} else {
			result = "";
		}

		return result;
	}
    
    public static String deletePath(String filePath) {
		File file = new File(filePathBlackList(filePath));
		String result = "";

		if (file.exists()) {
			result = file.getAbsolutePath();
			if (!file.delete()) {
				result = "";
			}
		}

		return result;
	}
    
    public static String filePathBlackList(String value) {
		String returnValue = value;
		if (returnValue == null || returnValue.trim().equals("")) {
			return "";
		}

		returnValue = returnValue.replaceAll("\\.\\./", ""); // ../
		returnValue = returnValue.replaceAll("\\.\\.\\\\", ""); // ..\

		return returnValue;
	}
    
    public static String getTimeStamp() {
		// 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
		String pattern = "yyyyMMddhhmmss";

		SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
		Date currentTime = new Date ();
		
		String mTime = sdfCurrent.format ( currentTime );

		return mTime;
	}

    public static Boolean Upload_Filter(String fileName){
	    String file_ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

	    Boolean result = Boolean.valueOf(true);

	    String[] bad_ext = { "php3", "php4", "asp", "jsp", "php", "html", "htm", "inc", "js", "pl", "cgi", "java", "exe" };

	    for (int i = 0; i < bad_ext.length; i++)
	    {
	      if (bad_ext[i].equals(file_ext)) {
	        return Boolean.valueOf(false);
	      }
	    }
	    if (fileName.contains(";"))
	    {
	      return Boolean.valueOf(false);
	    }

	    if (file_ext.length() == 0)
	    {
	      return Boolean.valueOf(false);
	    }

	    if (fileName.contains(".."))
	    {
	      return Boolean.valueOf(false);
	    }
	    
	    return result;
    }
	

    public static boolean isPermitExt(String originalFileName, String limitFileExt) {
		String file_ext = originalFileName.substring(originalFileName.lastIndexOf('.') + 1).toLowerCase();

		if ((limitFileExt == null) || (limitFileExt.equals("")))
		{
			return true;
		}

		String[] fileExtArray = limitFileExt.split(",");
		//int i = 0;
		for (String permExt : fileExtArray) 
		{
			if (permExt.toLowerCase().equals(file_ext)) 
			{
				return true;
			}

		}
		
		return false;
	}  
	
	
	
}
