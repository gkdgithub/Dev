package com.codewithgaurav.derivedqueries.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "roll_number")
	private String rollNumber;

	@Column(name = "university")
	private String university;

	@Column(name = "age")
	private Integer age;

	@Column(name = "birth_date")
	//@DateTimeFormat(iso = ISO.DATE)
	//@JsonFormat(pattern = "yyyy-MM-dd")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	//@JsonDeserialize(using=JsonDeserializer.class)
	private LocalDate birthDate;

	@Column(name = "active")
	private Boolean active;

}
