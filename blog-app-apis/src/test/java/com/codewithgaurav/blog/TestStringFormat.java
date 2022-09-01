package com.codewithgaurav.blog;

public class TestStringFormat {

	public static void main(String[] args) {

		String message = "user not fond with ";
		Integer fieldValue = 10;
		System.out.println(String.format("%s : %s", message, fieldValue));
	}

}
