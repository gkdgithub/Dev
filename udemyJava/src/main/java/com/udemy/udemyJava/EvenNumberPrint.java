package com.udemy.udemyJava;

public class EvenNumberPrint {

	public static void main(String[] args) {
		int number=4;
		int finishNumber=20;
		int enenNumberFound=0;
		while(number<=finishNumber){
			if(isEvenNumber(number)){
				System.out.println("Even Number is : "+number);
				enenNumberFound++;
				if(enenNumberFound==5){
					break;
				}
			}	
			number++;
		}
		System.out.println("Total found : "+enenNumberFound);
	}
	
	public static boolean isEvenNumber(int Number){
		if(Number%2==0){
			return true;
		}
		else{
			return false;
		}
	}

}
