package com.udemy.udemyJava;

public class PrimitiveTypeChallenge {

	public static void main(String[] args) {
		
		byte myByte=10;
		short myShort=20;
		int myInt=30;
		
		long myLong=50000L+10L*(myByte+myShort+myInt);
		
		System.out.println(myLong);
	}

}
