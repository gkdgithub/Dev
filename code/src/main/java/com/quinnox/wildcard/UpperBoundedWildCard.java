package com.quinnox.wildcard;

import java.util.Arrays;
import java.util.List;

// A wildCard example with upperBound
public class UpperBoundedWildCard {

	public static void main(String[] args) {
		
		Integer[] intArray={new Integer(4),new Integer(5),new Integer(6),new Integer(7)};
		List<Integer> intList=Arrays.asList(intArray);
		System.out.println(sum(intList));
		
		Double[] doubleArray={new Double(4.5),new Double(5.3),new Double(6.4)};
		List<Double> doubleList=Arrays.asList(doubleArray);
		System.out.println(sum(doubleList));

	}
	
	// This method arguments will accept Number and all it's child classes
	private static double sum(List<? extends Number> list) {
		double sum=0;
		for(Number i:list){
			sum+=i.doubleValue();
		}
		return sum;	
	}

}
