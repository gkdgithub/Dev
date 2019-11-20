package com.quinnox.code;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySorting {

	public static void main(String[] args) {
		
		String[] strArray={"hfaha","jhbdjasbfa","sndd","asbdahbdahdbabhda"};
		
		// By Default sorting
		/*Arrays.sort(strArray);
		System.out.println(Arrays.toString(strArray));*/
		
		// Custom Sorting
		Arrays.sort(strArray, new ArraySort());
		System.out.println(Arrays.toString(strArray));

	}
	
static class ArraySort implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return -o1.compareTo(o2);
		}
	
	}

}
