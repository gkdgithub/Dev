package com.udemy.udemyJava.masterchallenge;

public class DeluxeBurger extends Hamburger {

	public DeluxeBurger() {
		super("Deluxe", "Sausage & Bacon", 15.5, "White");
		super.addHamburgerAddition1("chips", 19.10);
		super.addHamburgerAddition2("drink", 19.10);
	}

	@Override
	public void addHamburgerAddition1(String name, double price) {
		System.out.println("Cannot not add additional items to a deluxe burger");
	}

	@Override
	public void addHamburgerAddition2(String name, double price) {
		System.out.println("Cannot not add additional items to a deluxe burger");
	}

	@Override
	public void addHamburgerAddition3(String name, double price) {
		System.out.println("Cannot not add additional items to a deluxe burger");
	}

	@Override
	public void addHamburgerAddition4(String name, double price) {
		System.out.println("Cannot not add additional items to a deluxe burger");
	}

}
