package com.quinnox.coreconcept;

import java.util.List;

public class Room {
		
	private Integer roomId;
	private String roomName;
	private List<Person> persons;
	
	public Room() {
		// TODO Auto-generated constructor stub
	}
	
	public Room(Integer roomId, String roomName, List<Person> persons) {
		this.roomId = roomId;
		this.roomName = roomName;
		this.persons = persons;
	}
	
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + ", persons=" + persons + "]";
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	
}
