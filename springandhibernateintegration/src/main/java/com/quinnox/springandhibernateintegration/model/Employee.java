package com.quinnox.springandhibernateintegration.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
@Table(name="emp_table")
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	 @Size(min=3, max=50)
	 @Column(name = "name", nullable = false)
	 private String name;
	 
	 @NotEmpty
	 @Column(name = "gender", nullable = false)
	 private String gender;
	 
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	 @Past
	 @NotNull
	 @Column(name = "dob", nullable = false)
	 private Date dob;
	 
	 @NotNull 
	 @FutureOrPresent 
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	 @Column(name = "doj", nullable = false)
	 private Date doj;
	 
	 @Email 
	 @NotEmpty
	 @Column(name = "email", nullable = false)
	 private String email;
	 
	 @NotNull
	 @Digits(integer=6, fraction=2)
	 @Range(min=15000,max=100000)
	 @Column(name = "salary", nullable = false)
	 private float salary;
	 
	 public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String gender, Date dob,
			 Date doj, String email, float salary) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.doj = doj;
		this.email = email;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", doj=" + doj
				+ ", email=" + email + ", salary=" + salary + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	 
	 
}
