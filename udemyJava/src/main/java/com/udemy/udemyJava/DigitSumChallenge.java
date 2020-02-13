package com.udemy.udemyJava;

public class DigitSumChallenge {

	public static void main(String[] args) {
		System.out.println(sumDigits(11113));
	}
	
	public static int sumDigits(int number){
		int sum=0;
		if(number<10){
			return -1;
		}
		else{
			while(number>0){
				sum=sum+(number%10);
				number=number/10;
			}
			return sum;
		}
	}
	
}
