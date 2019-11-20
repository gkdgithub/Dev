package com.quinnox.coreconcept;

// The class must be declared as final (So that child classes can’t be created)
final class Student{
		
	// Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
		private final int rollNum;
		private final String stuName;
		
		// A parameterized constructor
		public Student(int rollNum, String stuName) {
			this.rollNum = rollNum;
			this.stuName = stuName;
		}
		
		// Getter method for all the variables in it
		// No setters (So that we do not have the option to change the value of the instance variable)
		public int getRollNum() {
			return rollNum;
		}

		public String getStuName() {
			return stuName;
		}
		
		
		public Student modify(int rollNum){
			if(rollNum!=this.rollNum) 
				return new Student(105,this.stuName);
			else
				return this;
		}
		
		public Student modify(String stuName){
			if(stuName!=this.stuName) return new Student(this.rollNum, stuName);
			else return this;
		}
		
		public Student modify(int rollNum, String stuName){
			if(rollNum!=this.rollNum || stuName!=this.stuName) return new Student(rollNum, stuName);
			else return this;
		}

		@Override
		public String toString() {
			return "Student [rollNum=" + rollNum + ", stuName=" + stuName + "]";
		}
		
		
}

public class ImmutableClass {

	public static void main(String[] args) {
		
		Student student1=new Student(101, "Gaurav");
		System.out.println(student1);
		
		//Student student2=student.modify(105);
		//System.out.println(student2);
		
		//Student student3=student1.modify("Tarun");
		//System.out.println(student3);
		
		Student student4=student1.modify(101, "Tarun");
		System.out.println(student4);
		
		
		
		// TO verify whether object is same or different
		System.out.println(student1==student4);
	}

}
