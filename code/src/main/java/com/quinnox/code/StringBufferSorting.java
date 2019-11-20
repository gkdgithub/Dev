package com.quinnox.code;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class StringBufferSorting {
	
	// StringBUffer does not implements Comparable
	public static void main(String[] args) {
		
		Set<StringBuffer> set=new TreeSet<>(new StringBuffSort());
		set.add(new StringBuffer("Sohan")); 
        set.add(new StringBuffer("Raja")); 
        set.add(new StringBuffer("Harish")); 
        set.add(new StringBuffer("Ram")); 
        System.out.println(set);
	}

	static class StringBuffSort implements Comparator<StringBuffer>{

		@Override
		public int compare(StringBuffer o1, StringBuffer o2) {
			return (o1.toString().compareTo(o2.toString()));
		}
		
	}

}
