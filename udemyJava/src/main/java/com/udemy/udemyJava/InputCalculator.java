package com.udemy.udemyJava;

import java.util.Scanner;

public class InputCalculator {

	public static void main(String[] args) {
		inputThenPrintSumAndAverage();
	}
	
	public static void inputThenPrintSumAndAverage(){
		Scanner scanner=new Scanner(System.in);
		int sum=0; double avg=0; int count=0;
		while(true){
			if(scanner.hasNextInt()){
				sum+=scanner.nextInt();
				count++;
			}
			else{
				break;
			}
		}
		if(count!=0)
		avg=(double)sum/(double)count;
		System.out.println("SUM = "+sum+" AVG = "+Math.round(avg));
		scanner.close();
	}

}
