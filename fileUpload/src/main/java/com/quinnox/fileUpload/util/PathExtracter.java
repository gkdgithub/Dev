package com.quinnox.fileUpload.util;

import java.util.Collection;

import javax.servlet.http.Part;

public class PathExtracter {
	
	public static String extractFileName(Part filePart){
		Collection<String>headerList=filePart.getHeaderNames();
		System.out.println(headerList);
		String contentDiso=filePart.getHeader("content-disposition");
		System.out.println(contentDiso);
		String contentType=filePart.getHeader("content-type");
		System.out.println(contentType);
		String[] items=contentDiso.split(";");
		for (String str : items) {
			if(str.trim().startsWith("filename")){
				return str.substring((str.indexOf("=")+2),(str.length()-1));
			}
		}
		return "";		
	}
}
