package com.udemy.udemyJava;

public class EqualsSumChecker {

	public static void main(String[] args) {
		System.out.println(hasEqualSum(1,-1,0));
	}

	public static boolean hasEqualSum(int i, int j, int k) {
		
		if((i+j)==k){
			return true;
		}
		else{
			return false;
		}
	}	
	
}
