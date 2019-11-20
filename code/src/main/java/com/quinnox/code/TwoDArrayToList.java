package com.quinnox.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDArrayToList {

	public static void main(String[] args) {
		
		Integer[][] number=new Integer[2][3];
		number[0][0]=2;
		number[0][1]=3;
		number[0][2]=4;
		
		number[1][0]=5;
		number[1][1]=6;
		number[1][2]=7;
		
		// Converting 2D array to string and printing
		System.out.println("Array based output : "+Arrays.deepToString(number));
		
		twoDArrayToList(number);

	}

	private static <T> void twoDArrayToList(T[][] number) {
		
		List<T> list=new ArrayList<>();
		for(T[] array : number){
			list.addAll(Arrays.asList(array));
			System.out.println(Arrays.asList(array));
		}
		
		System.out.println(list);
	}

}
