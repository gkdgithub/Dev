package com.quinnox.generic;

public class GenericMethod {
	
	
	public static void main(String[] args) {
		GenericMethod genericMethod=new GenericMethod();
		System.out.println(genericMethod.genricDisplay(11));
		System.out.println(genericMethod.genricDisplay("Geeks"));
		System.out.println(genericMethod.genricDisplay("20.00"));

	}

	// A Generic method example 
	private  <T> T genricDisplay(T element) {
		return element;
	}

}
