package com.quinnox.codecalender;

import java.util.Calendar;
import java.util.Date;

public class Calendar1 {

	public static void main(String[] args) {
		
		Calendar calendar=Calendar.getInstance();
		Date date=calendar.getTime();
		System.out.println("Current Date : "+date);
		
		System.out.println("Current Calendar's Year: " + calendar.get(Calendar.YEAR));
		System.out.println("Current Calendar's Month: " + calendar.get(Calendar.MONTH));
		System.out.println("Current Calendar's Date: " + calendar.get(Calendar.DATE));
		System.out.println("Current Calendar's Hours: " + calendar.get(Calendar.HOUR));
		System.out.println("Current MINUTE: " + calendar.get(Calendar.MINUTE)); 
        System.out.println("Current SECOND: " + calendar.get(Calendar.SECOND));
        System.out.println("AM or PM : " + calendar.get(Calendar.AM_PM));
        System.out.println("Current Calendar's Hour (24-hour clock) : " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Day of week : " +calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Day of month : "+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Day of year : " +calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Week in Month : " +calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Week in Year : " +  calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Day of Week in Month : " +  calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        
        System.out.println("=====================================================================");
        
        System.out.println("Maximum number of days in a week: " + calendar.getMaximum(Calendar.DAY_OF_WEEK));
        System.out.println("Maximum number of days in a month: " +calendar.getMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("Maximum number of days in a year: " + calendar.getMaximum(Calendar.DAY_OF_YEAR));
        
        System.out.println("Maximum number of weeks in a year: " + calendar.getMaximum(Calendar.WEEK_OF_YEAR));
        
        System.out.println("Minimum number of days in a week: " + calendar.getMinimum(Calendar.DAY_OF_WEEK));
        System.out.println("Minimum number of days in a month: " +calendar.getMinimum(Calendar.DAY_OF_MONTH));
        System.out.println("Minimum number of days in a year: " + calendar.getMinimum(Calendar.DAY_OF_YEAR));
        
        System.out.println("Minimum number of weeks in a year: " + calendar.getMinimum(Calendar.WEEK_OF_YEAR));
	}

}
