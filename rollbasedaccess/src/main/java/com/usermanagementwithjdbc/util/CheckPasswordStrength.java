package com.usermanagementwithjdbc.util;

public class CheckPasswordStrength {
		
	public static boolean calculatePasswordStrenth(String password){
		
		boolean status=false;
		
		if(password.length()<8){
			return status;
		}
		else{
			int passwordScore=0;
			
			//if it contains one digit, add 2 to total score
			if(password.matches("(?=.*[0-9]).*")){
				passwordScore+=2;
			}
			
			//if it contains one lower case letter, add 2 to total score
			if(password.matches("(?=.*[a-z]).*")){
				passwordScore+=2;
			}
			
			//if it contains one upper case letter, add 2 to total score
			if(password.matches("(?=.*[A-Z]).*")){
				passwordScore+=2;
			}
			
			//if it contains one special character, add 2 to total score
			if(password.matches("(?=.*[~!@#$%^&*()_-]).*")){
				passwordScore=passwordScore+2;
			}
			
			if(passwordScore==8){
				status=true;
				return status;
			}
			return status;
		}				
	}		
}
