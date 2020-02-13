package com.udemy.udemyJava;

public class FirstAndLastDigitSum {

	public static void main(String[] args) {
		System.out.println("Sum : "+sumFirstAndLastDigit(5));
	}
	
	public static int sumFirstAndLastDigit(int number){
		if(number<0){
			return -1;
		}
		else{
			int lastDigit=number%10;
			int firstDigit=0;
			while(number>0){
				if(number<10){
					firstDigit=number;
				}
				number/=10;
				if(number>0){
					firstDigit=number%10;
				}				
			}
			System.out.println(lastDigit +"==="+firstDigit);
			return firstDigit+lastDigit;
		}
	}

}
