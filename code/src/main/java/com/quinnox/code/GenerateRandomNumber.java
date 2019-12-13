package com.quinnox.code;

import java.util.Random;

public class GenerateRandomNumber {
	
	public static void main(String[] args) {
		
		// chose a Character random from this String 
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
        int sizeOfRandomNum=15;
        
        System.out.println("Random AlphaNumeric : "+generateAlphaNumericNum(alphaNumericString,sizeOfRandomNum));
	}

	private static String generateAlphaNumericNum(String alphaNumericString, int sizeOfRandomNum) {
		// Using java Random class
		
		StringBuilder stringBuilder=new StringBuilder();
		Random random=new Random();
		for(int i=0;i<sizeOfRandomNum;i++){
			stringBuilder.append(alphaNumericString.charAt(random.nextInt(alphaNumericString.length())));
		}
		return stringBuilder.toString();
	}
	
	
	
}
