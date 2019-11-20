package com.udemy.udemyJava;

public class OperatorChallenge {

	public static void main(String[] args) {
		
		double firstVar=20.00d;
		double secondVar=80.00d;
		
		double reminder=((firstVar+secondVar)*100.00d)%40.00d;
		System.out.println(reminder);
		boolean isZero;
		
		/*if(reminder==0.0)
			System.out.println(isZero=true);
		else
			System.out.println(isZero=false);*/
		
		isZero=(reminder==0) ? true:false;
		System.out.println(isZero);
		
		if(!isZero)
			System.out.println("Got Some Reminder");
			
	}

}
