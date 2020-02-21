package com.udemy.udemyJava;

public class DiagonalStar {

	public static void main(String[] args) {
		printSquareStar(5);
	}
	
	public static void printSquareStar(int number){
		if(number>=5){
			int count=0;
			for(int i=number;i>0;i--){
				int leave=number-i;
				for(int j=i;j>0;j--){
					if(i==number || i==1 || j==i || j==number){
						System.out.print("*");
					}
					else{
						System.out.println(" ");
					}
				}
				System.out.println();
				count++;
			}
		}
		else{
			System.out.println("Invalid Value");
		}
	}

}
