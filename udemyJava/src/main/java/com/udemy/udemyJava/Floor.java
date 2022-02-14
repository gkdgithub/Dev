package com.udemy.udemyJava;

public class Floor {
	// write your code here
	private double width;
	private double length;

	public Floor(double width, double length) {
		if (width < 0 && length < 0) {
			this.width = 0;
			this.length = 0;
		} else if (width < 0) {
			this.width = 0;
			this.length = length;
		} else if (length < 0) {
			this.width = width;
			this.length = 0;
		} else {
			this.width = width;
			this.length = length;
		}
	}

	public double getArea() {
		return width * length;
	}

}

class Carpet {

	private double cost;

	public Carpet(double cost) {
		if (cost < 0) {
			this.cost = 0;
		} else {
			this.cost = cost;
		}
	}

	public double getCost() {
		return cost;
	}

}

class Calculator {
	private Floor floor;
	private Carpet carpet;

	public Calculator(Floor floor, Carpet carpet) {
		this.floor = floor;
		this.carpet = carpet;
	}

	public double getTotalCost() {
		double area = floor.getArea();
	    double cost = carpet.getCost();
	    return area*cost;
	}
}
