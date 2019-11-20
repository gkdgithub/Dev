package com.quinnox.code;

import java.util.Arrays;

public class TwoDArrayToString {

	public static void main(String[] args) {
		
		int[][] number=new int[2][3];
		number[0][0]=2;
		number[0][1]=3;
		number[0][2]=4;
		
		number[1][0]=5;
		number[1][1]=6;
		number[1][2]=7;
		
		System.out.println(Arrays.deepToString(number));
	}

}
