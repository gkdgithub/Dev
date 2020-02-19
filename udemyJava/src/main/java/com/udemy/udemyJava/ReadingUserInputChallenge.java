package com.udemy.udemyJava;

import java.util.Scanner;

public class ReadingUserInputChallenge {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int count = 1;
		int sum = 0;

		while (true) {
			System.out.println("Enter number " + count + " : ");
			Boolean hasNextInt = scanner.hasNextInt();
			if (hasNextInt) {
				sum += scanner.nextInt();
				count++;
				if (count == 11) {
					break;
				}
			}
			else{
				System.out.println("Invalid Value");
			}
			scanner.nextLine();  // Handle end of line
		}
		System.out.println("Sum of all the number : " + sum);
		scanner.close();
	}

}
