package com.udemy.udemyJava;

public class MethodOverLoad {

	public static void main(String[] args) {
		
		System.out.println(calcFeetAndInchesToCentimeters(50));
	}
	
	public static double calcFeetAndInchesToCentimeters(double feet, double inch){
		if((feet>=0) && (inch>=0 && inch<=12)){
			double finalInches=(feet*12)+inch;
			double finalCentimeters=(finalInches*2.54);
			return finalCentimeters;
		}
		else{
			return -1;
		}
	}
	
	public static double calcFeetAndInchesToCentimeters(double inch){
		if(inch>=0){
			double footAndInch=inch/12;
			String footAndInchInString=String.valueOf(footAndInch);
			
			String onlyFoot=footAndInchInString.substring(0,footAndInchInString.indexOf("."));
			String onlyInches=(footAndInchInString.substring(footAndInchInString.indexOf(".")+1)).substring(0, 3);
			
			
			int onlyFoot1=Integer.parseInt(onlyFoot);	
			int onlyInches1=Integer.parseInt(onlyInches);
			
			int onlyInches2LastValue=((onlyInches1))%10;
			int onlyInches2FirstValue=0;
			if(onlyInches2LastValue>5){
				onlyInches2FirstValue=Integer.parseInt(onlyInches.substring(0, 1))+1;
			}
			//System.out.println(onlyFoot1);
			//System.out.println(onlyInches2FirstValue);
			
			// Calling overloaded method
			return calcFeetAndInchesToCentimeters(onlyFoot1, onlyInches2FirstValue);
			
			//return footAndInch;
		}
		else{
			return -1;
		}
	}

}
