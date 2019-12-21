package com.sgs.atrandom;

import java.util.Random;

public class GeneratePassword {
	
    public static void main(String[] args)
    {
        // Length of your password as I have choose here to be 15
        int length = 15;
        System.out.println(randomPassword(length));
    }
 
    // This our Password generating method
    // We have use static here, so that we not to make any object for it
    
    static char[] randomPassword(int len)
    {
        System.out.println("Generating password using random() : ");
        System.out.print("Your new password is : ");
 
        // A strong password has Cap_chars, Lower_chars,
        // numeric value and symbols. So we are using all of
        // them to generate our password
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";
 
 
        String values = Capital_chars + Small_chars + numbers + symbols;
 
        // Using random method
        Random rndm_method = new Random();
 
        char[] password = new char[len];
 
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int 
        	// Generate random integer using nextInt() in the range of 0 to values.length();
        	
            password[i] = values.charAt(rndm_method.nextInt(values.length()));    
        }
        return password;
    }
}
