package com.quinnox.wildcard;

import java.util.Arrays;
import java.util.List;

// When writing a method which can be employed using functionality provided in Object class.
// then unbounded Wildcard comes into picture

public class UnBoundedWildCard {

	public static void main(String[] args) {
		
		List<Integer> list1= Arrays.asList(1,2,3); 
		  
        //Double list 
        List<Double> list2=Arrays.asList(1.1,2.2,3.3); 
  
        printlist(list1); 
  
        printlist(list2); 
		
	}
	
	// This method arguments will accept any Type
	private static void printlist(List<?> list) {
		System.out.println(list);
	}

}
