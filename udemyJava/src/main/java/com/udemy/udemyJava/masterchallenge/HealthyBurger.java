package com.udemy.udemyJava.masterchallenge;

public class HealthyBurger extends Hamburger {

	private String healthyExtra1Name;
	private double healthyExtra1Price;

	private String healthyExtra2Name;
	private double healthyExtra2Price;

	public HealthyBurger(String meat, double price) {
		super("Healthy", meat, price, "Brown rye");
	}

	public void addHealthyAddition1(String name, double price) {
		this.healthyExtra1Name = name;
		this.healthyExtra1Price = price;
	}

	public void addHealthyAddition2(String name, double price) {
		this.healthyExtra2Name = name;
		this.healthyExtra2Price = price;
	}

	@Override
	public double itemizeHamburger() {
		double healthyBurgerPrice = super.itemizeHamburger();

		if (this.healthyExtra1Name != null) {
			System.out.println("Added " + this.healthyExtra1Name + " for an extra " + this.healthyExtra1Price);
			healthyBurgerPrice += healthyExtra1Price;
		}
		if (this.healthyExtra2Name != null) {
			System.out.println("Added " + this.healthyExtra1Name + " for an extra " + this.healthyExtra1Price);
			healthyBurgerPrice += healthyExtra2Price;
		}
		return healthyBurgerPrice;
	}

}
