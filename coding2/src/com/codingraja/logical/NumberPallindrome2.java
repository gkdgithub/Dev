package com.codingraja.logical;

import java.util.Scanner;

public class NumberPallindrome2 {

	public static void main(String[] args) {
		
		int originalNumber = 0;
		int reverseNumber = 0;
		
		System.out.println("Enter the Number You Want to check : ");
		Scanner sc = new Scanner(System.in);
		originalNumber  = sc.nextInt();
		
		// Logic
		reverseNumber = Integer.parseInt(new StringBuffer(String.valueOf(originalNumber)).reverse().toString());
		
		if(originalNumber==reverseNumber)
			System.out.println("The given Number is Pallindrome");
		else
			System.out.println("The given Number is Not Pallindrome");
		sc.close();

	}

}
