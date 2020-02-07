package com.udemy.udemyJava;

public class CountPrimeNumber {

	public static void main(String[] args) {
		int count=0;
		for(int i=10;i<=50;i++){
			if(isPrime(i)){
				System.out.println(i + " : is a prime Number");
				count++;
				if(count==11){
					break;
				}
			}
			
		}
	}
	
	public static boolean isPrime(int number){
		if(number==1){
			return false;
		}
		for(int i=2;i<=number/2;i++){
			if(number%i==0){
				return false;
			}
		}
		return true;	
	}

}
