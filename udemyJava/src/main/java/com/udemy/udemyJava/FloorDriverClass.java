package com.udemy.udemyJava;

public class FloorDriverClass {

	public static void main(String[] args) {
		Carpet carpet = new Carpet(3.5);
		Floor floor = new Floor(2.75, 4.0);
		Calculator calculator = new Calculator(floor, carpet);
		System.out.println("total :: "+ calculator.getTotalCost());
		
	}
}
