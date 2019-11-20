package com.quinnox.generic;

// A generic class example 
class Test2<T,U>{
	
	T obj1;
	U obj2;
	
	public Test2(T obj1,U obj2) {
		this.obj1=obj1;
		this.obj2=obj2;
	}

	public void getValue() {
		System.out.println(obj1);
		System.out.println(obj2);
	}
	
	
}

public class Main2 {

	public static void main(String[] args) {
		
		Test2<String,Integer> test2=new Test2<String, Integer>("GFG", 20);
		test2.getValue();
	}

}
