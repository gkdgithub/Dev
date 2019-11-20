package com.quinnox.codecalender;

import java.util.Calendar;

public class Calendar2 {

	public static void main(String[] args) {
		
		// Program to demonstrate add() method of calendar class
		
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.DATE, -12);
		System.out.println("12 days ago : "+calendar.getTime());
		
		calendar.add(Calendar.MONTH, 6);
		System.out.println("6 month later : "+calendar.getTime());
		
		calendar.add(Calendar.YEAR, 4);
		System.out.println("4 Year later : "+calendar.getTime());
	}

}
