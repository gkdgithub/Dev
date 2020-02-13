package com.udemy.udemyJava;

public class SharedDigit {

	public static void main(String[] args) {
		System.out.println(hasSharedDigit(25, 22));
	}
	
	public static boolean hasSharedDigit(int number1,int number2){
		if((number1>=10 && number1<=99) && (number2>=10 && number2<=99)){
			int i=number1;
			int j=number2;
			while(i>0){
				int digit1=i%10;
				while(j>0){
					int digit2=j%10;
					j=j/10;
					if(digit1==digit2){
						return true;
					}
				}
				i/=10;
				j=number2;
			}
			return false;
		}
		else{
			return false;
		}
	}

}
