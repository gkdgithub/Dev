package com.quinnox.codestring;

public class SplitSubString {

	public static void main(String[] args) {
		String fileName="form-data; name=\"dataFile\"; filename=\"PHOTO.JPG\"";
		System.out.println(extractName(fileName));
	}
	public static String extractName(String fileName){
		String[] arrItems=fileName.split(";");
		for (String item : arrItems) {
			//System.out.println(item.trim());
			if(item.trim().startsWith("filename")){
				System.out.println(item.substring(item.indexOf("=")+2));
				return item.substring((item.indexOf("=")+2),(item.length()-1));
			}
		}
		return "";
	}

}
