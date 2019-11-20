package com.quinnox.coreconcept;

import java.util.ArrayList;
import java.util.List;

public class PersonDriver2 {

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
		
		Person person11=new Person(21, "Red");
		Person person12=new Person(22, "Yellow");
		Person person13=new Person(23, "Red");
		Person person14=new Person(24, "Red");
		Person person15=new Person(25, "White");
		Person person16=new Person(26, "Red");
		
		
		
		List<Person> persons1=new ArrayList<>();
		persons1.add(person1);persons1.add(person2);persons1.add(person3);persons1.add(person4);persons1.add(person5);
		persons1.add(person6);persons1.add(person7);persons1.add(person8);persons1.add(person9);persons1.add(person10);
		
		
		List<Person> persons2=new ArrayList<>();
		persons2.add(person11);persons2.add(person12);persons2.add(person13);persons2.add(person14);persons2.add(person15);
		persons2.add(person16);

		
		// Setting all persons1 inside the room1 
		Room room1=new Room();
		room1.setRoomId(101);
		room1.setRoomName("Drawing Room");
		room1.setPersons(persons1);
		
		// Setting all persons1 inside the room2
		Room room2=new Room(102,"Hall",persons2);
		
		List<Room> rooms=new ArrayList<>();
		rooms.add(room1);rooms.add(room2);
		
		List<Person> redShirtPerson=new ArrayList<>();
		for(Room room:rooms){
			List<Person> personsFromRoom=room.getPersons();
			for(int i=0;i<personsFromRoom.size();i++){
				Person singlePerson=personsFromRoom.get(i);
				String shirtColor=singlePerson.getShirtColor();
				if(shirtColor.equalsIgnoreCase("rEd")){
					redShirtPerson.add(singlePerson);
				}
			}
			for(Person person:redShirtPerson){System.out.println(person);}
		}
		System.out.println(redShirtPerson.size());
		
	}

}
