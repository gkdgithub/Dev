package com.udemy.udemyJava;

public class MinutesToYearsAndDaysCalculator {

	public static void main(String[] args) {
		
		printYearsAndDays(561600);
	}
	
	public static void printYearsAndDays(long minutes){
		if(minutes<0){
			System.out.println("Invalid Value");
		}
		else{
			int years=(int)(minutes/((60*24)*365));
			int days=(int)((minutes/(60*24))%365);
			System.out.println(minutes+" min = "+years +" y and "+days+" d");
		}
	}
	
}
