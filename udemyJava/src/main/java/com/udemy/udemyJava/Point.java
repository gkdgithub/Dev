package com.udemy.udemyJava;

public class Point {

	// write your code here
	private int x;
	private int y;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double distance() {
		double num = Math.pow((x - 0), 2) + Math.pow((y - 0), 2);
		return Math.sqrt(num);
	}

	public double distance(int x, int y) {
		double num = Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2);
		return Math.sqrt(num);
	}

	public double distance(Point point) {
		double num = Math.pow((this.x - point.x), 2) + Math.pow((this.y - point.y), 2);
		return Math.sqrt(num);
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
