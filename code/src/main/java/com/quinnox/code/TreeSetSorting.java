package com.quinnox.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetSorting {

	public static void main(String[] args) {
		
		String[] strArray={"hfaha","jhbdjasbfa","sndd","asbdahbdahdbabhda"};
		
		TreeSet<String> ts1 = new TreeSet<String>(new SortComparator()); 
		
		// adding array element to the set
		/*for (String string : strArray) {
				ts1.add(string);
		}*/
		
		// adding array element to the set in one go
		ts1.addAll(Arrays.asList(strArray));
        System.out.println(ts1);

	}
	

static class SortComparator implements Comparator{
	

		@Override
		public int compare(Object o1, Object o2) {
			String s1=(String) o1;
			String s2=o2.toString();
			
			int length1=s1.length();
			int length2=s2.length();
			
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

}
