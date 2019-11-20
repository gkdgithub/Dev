package com.quinnox.code.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySortOnLength {

	public static void main(String[] args) {
		
		String[] input = {"cats", "starandgalexy", "act", "gidandrid", "artsandscience", "dogandcats", "rats"};
		Arrays.sort(input, new ArrayComp());
		System.out.println(Arrays.toString(input));
	}

}

class ArrayComp implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		//return new Integer(o1.length()).compareTo(o2.length());
		//return -new Integer(o1.length()).compareTo(o2.length());
		
		int length1=o1.length();
		int length2=o2.length();
		
		if(length1<length2){
			return -1;
		}
		else if(length1>length2){
			return +1;
		}
		else
			return 0;
	}	
}
