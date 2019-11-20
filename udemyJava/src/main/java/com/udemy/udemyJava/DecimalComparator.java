package com.udemy.udemyJava;

public class DecimalComparator {

	public static void main(String[] args) {
		System.out.println(areEqualByThreeDecimalPlaces(3.17568,3.17579));
	}
	
	public static boolean areEqualByThreeDecimalPlaces(double num1,double num2) {
		int a=(int)(num1*1000);
		int b=(int)(num2*1000);
	
		System.out.println(a+" "+b);
		if(a==b){
			return true;
		}
		else{
			return false;
		}
	}

}
