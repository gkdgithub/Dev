package com.udemy.udemyJava;

public class SpeedConvertor {

	public static void main(String[] args) {
		
		long mphInRound=toMilesPerHour(10.25);
		System.out.println(mphInRound);
		
		printConversion(95.75);
				
		
	}
	
	public static long toMilesPerHour(double kilometersPerHour){
		if(kilometersPerHour<0){
			return -1;
		}
		else{
			return Math.round(kilometersPerHour/1.609);
		}
	}
	
	public static void printConversion(double kilometersPerHour){
		if(kilometersPerHour<0){
			System.out.println("Invalid Value");
		}
		else{
			long printConversion=toMilesPerHour(kilometersPerHour);
			System.out.println(""+kilometersPerHour +" Km/h = "+printConversion+" mi/h");
		}	
	}
	
}
