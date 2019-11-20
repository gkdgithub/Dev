package com.quinnox.coreconcept;

class Employee{
	
	private int id;
	private String firstName;
	private String lastName;
	
	public Employee() {
		
	}

	public Employee(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		// checking if both the object references are referring to the same object.
		if(obj==this) return true;
		
		
		// It checks if the argument obj is type of Employee or not, to avoid ClassCastException .
		// Also checking obj should not be null
		if(obj==null || obj.getClass() != this.getClass()) return false;
		
		// We can check by this also
		//if(!(obj instanceof Employee)) return false;
		
		// Type casting of the argument
		Employee employee=(Employee)obj;
		
		// comparing the state of argument obj with the state of 'this' Object. 
		return (employee.id==this.id && (employee.firstName==this.firstName || (employee.firstName!=null && employee.equals(this.firstName)))
				&& (employee.lastName==this.lastName || (employee.lastName!=null && employee.equals(this.lastName))));
		
	}
	
	@Override
	public int hashCode() {
		
		// We are returning the Employee_id as a hashCode value. 
		// we can also return some other calculated value or may be memory address of the Object on which it is invoked. 
		// it depends on how you implement hashCode() method. 
		return this.id;
	}
}
public class EqualsMethod {
	public static void main(String[] args) {
		Employee employee1=new Employee(101, "Gaurav", "Dwivedi");
		Employee employee2=new Employee(101, "Gaurav", "Dwivedi");
		
		if(employee1.hashCode()==employee2.hashCode()){
			if(employee1.equals(employee2)) System.out.println("Both Objects are equals");
			else System.out.println("Both Objects are not equals");
		}
		else System.out.println("Both Objects are not equals");

	}
}

/*when we override equals(), it is recommended to also override the hashCode() method. 
If we don’t do so, equal objects may get different hash-values, and hash based collections 
including HashMap, HashSet, and Hashtable do not work properly*/