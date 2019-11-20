package com.udemy.udemyJava;

public class SecondAndMinutesChallenge {
	
	private static final String INVALID_VALUE_MESSAGE="Invalid Value";
	
	public static void main(String[] args) {
		System.out.println(getDurationString(3945));
		System.out.println(getDurationString(65, 45));
		System.out.println(getDurationString(-41));
		System.out.println(getDurationString(65, 9));
	}
	
	public static String getDurationString(int minutes, int seconds){
		if((minutes>=0) && (seconds>=0 && seconds<=59)){
			int hours=minutes/60;
			int remainingMinutes=minutes%60;
			
			String hoursString=hours+"h ";
			if(hours<10){
				hoursString="0"+hoursString;
			}
			
			String minutesString=remainingMinutes+"m ";
			if(remainingMinutes<10){
				minutesString="0"+minutesString;
			}
			
			String secondString=seconds+"s ";
			if(seconds<10){
				secondString="0"+secondString;
			}
			
			return hoursString+minutesString+secondString;
		}
		else{
			return INVALID_VALUE_MESSAGE;
		}
	}
	
	public static String getDurationString(int seconds){
		if(seconds>=0){
			int minutes=seconds/60;
			int remainingSecond=seconds%60;
			return getDurationString(minutes, remainingSecond);
		}
		else{
			return INVALID_VALUE_MESSAGE;
		}
	}

}
