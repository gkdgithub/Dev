package com.quinnox.generic;

//Generic class example
// T is Type parameter 
class Test<T>{
	
	T obj;
	
	public Test(T obj) {
		this.obj=obj;
	}
	
	public T getObject(){
		return this.obj;
	}
}

public class Main {

	public static void main(String[] args) {
		
		Test<Integer> testInt=new Test<Integer>(15);
		System.out.println(testInt.getObject());
		
		Test<String> testString=new Test<>("Gaurav Kumar");
		System.out.println(testString.getObject());
	}

}
