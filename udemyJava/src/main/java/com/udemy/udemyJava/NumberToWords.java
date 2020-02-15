package com.udemy.udemyJava;

public class NumberToWords {

	public static void main(String[] args) {
		numberToWords(100);
	}
	
	public static void numberToWords(int number){
		if(number<0){
			System.out.println("Invalid Value");
		}
		else{
			String rev=reverse(number);
			for(int i=rev.length()-1;i>=0;i--){
				switch(rev.charAt(i)){
				case '0':
					System.out.println("Zero");
					break;
				case '1':
					System.out.println("One");
					break;
				case '2':
					System.out.println("Two");
					break;
				case '3':
					System.out.println("Three");
					break;
				case '4':
					System.out.println("Four");
					break;
				case '5':
					System.out.println("Five");
					break;
				case '6':
					System.out.println("Six");
					break;
				case '7':
					System.out.println("Seven");
					break;
				case '8':
					System.out.println("Eight");
					break;
				case '9':
					System.out.println("Nine");
				}
			}
			
		}
	}
	
	public static String reverse(int number){
		int count=getDigitCount(number);
		int reverse=0;
		int i=number;
		while(count>0){
			reverse=(reverse*10)+(i%10);
			i/=10;
			count--;
		}
		if(getDigitCount(reverse)<getDigitCount(number)){
			int diff=getDigitCount(number)-getDigitCount(reverse);
			String rev=String.valueOf(reverse);
			while(diff>0){
				rev=0+rev;
				diff--;
			}
			return rev;
		}
		else{
			return String.valueOf(reverse);
		}
	}
	
	public static int getDigitCount(int number){
		if(number>0){
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
