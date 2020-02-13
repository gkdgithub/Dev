package com.udemy.udemyJava;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome(1221));
	}
	
	public static boolean isPalindrome(int number){
		int reverseNumber=0;
		int i=Math.abs(number);
		while(i>0){
			reverseNumber=(reverseNumber*10)+(i%10);
			i=i/10;
		}
		if(Math.abs(number)==reverseNumber){
			return true;
		}
		else{
			return false;
		}
		
		/*if((String.valueOf(number)).equals(new StringBuffer(String.valueOf(number)).reverse().toString())){
			return true;
		}
		else{
			return false;
		}*/
	}

}
