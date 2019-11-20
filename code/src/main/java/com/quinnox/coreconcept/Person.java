package com.quinnox.coreconcept;

public class Person {
	
		private Integer shirtNumber;
		private String shirtColor;
		
		public Person() {
			// TODO Auto-generated constructor stub
		}
		
		public Person(Integer shirtNumber, String shirtColor) {
			this.shirtNumber = shirtNumber;
			this.shirtColor = shirtColor;
		}


		@Override
		public String toString() {
			return "Person [shirtNumber=" + shirtNumber + ", shirtColor=" + shirtColor + "]";
		}

		public Integer getShirtNumber() {
			return shirtNumber;
		}

		public void setShirtNumber(Integer shirtNumber) {
			this.shirtNumber = shirtNumber;
		}

		public String getShirtColor() {
			return shirtColor;
		}

		public void setShirtColor(String shirtColor) {
			this.shirtColor = shirtColor;
		}
		
		
}
