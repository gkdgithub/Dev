package com.udemy.udemyJava;

import java.util.Scanner;

public class MinAndMaxInputChallenge {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int max=0, min=0; int number=0;
		boolean status=true;
		
		while(true){
			System.out.println("Enter Number : ");
			if(scanner.hasNextInt()){
				number=scanner.nextInt();
				
				if(status){
					status=false;
					max=number;
					min=number;
				}				
				
				if(max<number){
					max=number;
				}
				if(min>number){
					min=number;
				}
			}
			else{
				break;
			}
		}
		System.out.println("Max Num is : "+max + " Min Num is : "+min);
		
		scanner.close();
	}	

}
