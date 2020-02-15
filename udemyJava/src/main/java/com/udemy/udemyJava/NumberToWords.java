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
			int rev=reverse(number);
			String revString="";
			if(getDigitCount(rev)<getDigitCount(number)){
			int diff=getDigitCount(number)-getDigitCount(rev);
			revString=String.valueOf(rev);
				while(diff>0){
					revString=0+revString;
					diff--;
				}
			}
			else{
				revString=String.valueOf(rev);
			}
			for(int i=revString.length()-1;i>=0;i--){
				switch(revString.charAt(i)){
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
