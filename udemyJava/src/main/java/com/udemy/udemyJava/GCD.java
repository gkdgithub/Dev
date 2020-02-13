package com.udemy.udemyJava;

public class GCD {

	public static void main(String[] args) {
		System.out.println("GCD is : "+getGreatestCommonDivisor(25, 15));
	}
	
	public static int getGreatestCommonDivisor(int first, int second){
		if(first<10 || second<10){
			return -1;
		}
		else{
			int gcd=1;
			int largest = (first>second) ? first : second;
			for(int i=1;i<largest;i++){
				if(first%i==0 && second%i==0){
					if(i>gcd){
						gcd=i;
					}
				}
			}
			return gcd;
		}
	}

}
