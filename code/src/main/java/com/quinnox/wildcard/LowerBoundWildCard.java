package com.quinnox.wildcard;

import java.util.Arrays;
import java.util.List;

// A wildCard example with lowerBound
public class LowerBoundWildCard {

	public static void main(String[] args) {
		
		//Lower Bounded Integer List 
		List<Integer> list1= Arrays.asList(4,5,6,7); 
				
		//Integer list object is being passed 
		printOnlyIntegerClassorSuperClass(list1); 

		//Number list
		Number[] number={new Float(10.5f),new Double(9.5),new Long(103)};
		List<Number> list2= Arrays.asList(number); 
				
		//Number list object is being passed 
		printOnlyIntegerClassorSuperClass(list2); 

	}
	
	// This method arguments will accept either Integer or it's Super Type
	public static void printOnlyIntegerClassorSuperClass(List<? super Integer> list) 
	{ 
		System.out.println(list); 
	} 

}
