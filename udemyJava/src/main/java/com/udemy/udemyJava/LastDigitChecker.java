package com.udemy.udemyJava;

public class LastDigitChecker {

	public static void main(String[] args) {
		System.out.println(hasSameLastDigit(41, 22, 72));
	}
	
	public static boolean hasSameLastDigit(int number1,int number2, int number3){
		if(isValid(number1) && isValid(number2) && isValid(number3)){
			int lastDigit1=number1%10;
			int lastDigit2=number2%10;
			int lastDigit3=number3%10;
			if(lastDigit1==lastDigit2 || lastDigit2==lastDigit3 || lastDigit3==lastDigit1){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public static boolean isValid(int num){
		if((num>=10 && num<=1000)){
			return true;
		}
		else{
			return false;
		}
	}

}
