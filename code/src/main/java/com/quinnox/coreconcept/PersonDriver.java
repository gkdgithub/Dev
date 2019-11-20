package com.quinnox.coreconcept;

import java.util.ArrayList;
import java.util.List;

public class PersonDriver {

	public static void main(String[] args) {
		
		Person person1=new Person(10, "Green");
		Person person2=new Person(15, "Red");
		Person person3=new Person(12, "Yellow");
		Person person4=new Person(13, "Red");
		Person person5=new Person(14, "Red");
		Person person6=new Person(11, "Yellow");
		Person person7=new Person(17, "Red");
		Person person8=new Person(18, "Red");
		Person person9=new Person(16, "White");
		Person person10=new Person(19, "Red");
		
		List<Person> persons1=new ArrayList<>();
		persons1.add(person1);persons1.add(person2);persons1.add(person3);persons1.add(person4);persons1.add(person5);
		persons1.add(person6);persons1.add(person7);persons1.add(person8);persons1.add(person9);persons1.add(person10);
		
		
		// Setting all persons inside the room 
		Room room1=new Room();
		room1.setRoomId(101);
		room1.setPersons(persons1);
		
		
		// Now our aim is to fetch the person who all are wearing red shirt
		List<Person> personsFromRoom = room1.getPersons();
		
		List<Person> redShirtPerson=new ArrayList<>();
		
		for(int i=0;i<personsFromRoom.size();i++){
			Person singlePerson=personsFromRoom.get(i);
			String shirtColor=singlePerson.getShirtColor();
			if(shirtColor.equalsIgnoreCase("rEd")){
				redShirtPerson.add(singlePerson);
			}
		}
		
		for(Person person:redShirtPerson){System.out.println(person);}
		System.out.println(redShirtPerson.size());
	}

}
