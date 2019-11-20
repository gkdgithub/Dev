package com.quinnox.code;

public class SubStringProblem {

	public static void main(String[] args) {
		
		 String input = "Java is the best programming language";
		 Boolean isPresent = input.indexOf("Java") !=-1 ? true : false;
		 System.out.println(input.indexOf("Java"));
		 
		 if(isPresent){
			 System.out.println("input string: " + input);
		     System.out.println("search string: " + "Java");
		     System.out.println("does String contains substring? " + "YES");
		 }
		 
		 // indexOf is case-sensitive so if you pass wrong case, you will get wrong result
		 isPresent = input.indexOf("java") !=-1 ? true : false;
		 System.out.println(input.indexOf("java"));
		 System.out.println("isPresent : "+isPresent); // flase because indeOf() is case-sensitive
		 
		 System.out.println("===========================================");
		 
		 boolean isFound=input.contains("Java");
		 if(isFound){
			 System.out.println("input string: " + input);
		     System.out.println("search string: " + "Java");
		     System.out.println("does substring is found inside String? " + "YES");
		 }
		 
		 isFound=input.contains("java");
		 System.out.println("isFound : "+isFound); // false because contains method is also case sensitive
		 
		 System.out.println("===========================================");
		 
		 int present = input.lastIndexOf("Java");
		 if(present!=-1){
			 System.out.println("Present");
		 }
		 else{
			 System.out.println("Not Present");
		 }
		 
		 present = input.lastIndexOf("java"); // lastIndex is also case-sensitive
		 if(present!=-1){
			 System.out.println("Present");
		 }
		 else{
			 System.out.println("Not Present");
		 }
		 
	}

}
