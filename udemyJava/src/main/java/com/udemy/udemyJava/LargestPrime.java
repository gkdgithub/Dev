package com.udemy.udemyJava;

public class LargestPrime {

	public static void main(String[] args) {
		System.out.println(getLargestPrime(45));

	}
	
	public static int getLargestPrime(int number){
		int largestPrime=1;
		if(number<=1){
			return -1;
		}
		else{
			for(int i=1;i<number;i++){
				if(number%i==0){
					int j=0;
					for(j=2;j<=i;j++){
						if(i%j==0){
							break;
						}						
					}
					if(i==j){
						largestPrime=i;
					}
				}
			}
			if(largestPrime==1){
				return number;
			}
			return largestPrime;
		}
	}

}
