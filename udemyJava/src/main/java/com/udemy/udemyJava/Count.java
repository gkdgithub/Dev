package com.udemy.udemyJava;

public class Count {

	public static void main(String[] args) {
		System.out.println(reverse(100));
		//System.out.println(getDigitCount(0));

	}
	
	public static int reverse(int number){
		int count=0;
		if(number<0){
			count=getDigitCount(Math.abs(number));
		}
		else{
			count=getDigitCount(number);
		}		
		int reverse=0;
		int i=number;
		while(count>0){
			reverse=(reverse*10)+(i%10);
			i/=10;
			count--;
		}
		return reverse;
	}
	
	public static int getDigitCount(int number){
		if(number==0){
			return 1;
		}
		else if(number>0){
			int count=0;
			while(number>0){
				number/=10;
				count++;
			}
			return count;
		}
		else{
			return -1;
		}
	}
	
}
