package com.quinnox.code;

public class FirstWordCaps {
	
	public static void main(String[] args) {
		System.out.println(firstWorldCaps("gaurav kumar dwivedi"));
	}

	private static String firstWorldCaps(String name) {
		StringBuffer nameInCaps = new StringBuffer();
		String[] nameArr=name.split(" ");
		for(String str:nameArr){
			nameInCaps.append((str.substring(0, 1).toUpperCase()+str.substring(1).toLowerCase())+" ");
		}
		return nameInCaps.toString();
	}
	
}
