package com.codewithgaurav.derivedqueries.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithgaurav.derivedqueries.entity.Student;
import com.codewithgaurav.derivedqueries.repo.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	private StudentRepo repo;

	@PostMapping(value = "/save")
	@Transactional
	public String saveStudent(@RequestBody List<Student> students) {
		repo.saveAll(students);
		// int a = 10 / 0; // because of transactional record will not save into
		// database.
		// System.out.println(a);
		return "record saved";
	}

	@GetMapping(value = "/findFirst3ByName/{name}")
	public List<Student> findFirst3ByName(@PathVariable("name") String name) {
		return repo.findFirst3ByName(name);
	}

	@GetMapping(value = "/findByNameIs/{name}")
	public List<Student> findByNameIs(@PathVariable("name") String name) {
		return repo.findByNameIs(name);
	}

	@GetMapping(value = "/findByNameEquals/{name}")
	public List<Student> findByNameEquals(@PathVariable("name") String name) {
		return repo.findByNameEquals(name);
	}

	@GetMapping(value = "/findByRollNumber/{rollNumber}")
	public List<Student> findByRollNumber(@PathVariable("rollNumber") String rollNumber) {
		return repo.findByRollNumber(rollNumber);
	}

	@GetMapping(value = "/findByUniversity/{university}")
	public List<Student> findByUniversity(@PathVariable("university") String university) {
		return repo.findByUniversity(university);
	}

	@GetMapping(value = "/findTop2ByUniversity/{university}")
	public List<Student> findTop2ByUniversity(@PathVariable("university") String university) {
		return repo.findTop2ByUniversity(university);
	}

	@GetMapping(value = "/findByNameAndRollNumber")
	public List<Student> findByNameAndRollNumber(@RequestParam String name, @RequestParam String rollNumber) {
		return repo.findByNameAndRollNumber(name, rollNumber);
	}

	// http://localhost:8080/spring-mvc-basics/api/foos?id=1,2,3
	// http://localhost:8080/spring-mvc-basics/api/foos?id=1&id=2

	@GetMapping("/findByRollNumberIn")
	public List<Student> findByRollNumberIn(@RequestParam List<String> rollNumbers) {
		return repo.findByRollNumberIn(rollNumbers);
	}

	@GetMapping("/findByRollNumberNotIn")
	public List<Student> findByRollNumberNotIn(@RequestParam List<String> rollNumbers) {
		return repo.findByRollNumberNotIn(rollNumbers);
	}

	@GetMapping("/findByRollNumberBetween")
	public List<Student> findByRollNumberBetween(@RequestParam String start, @RequestParam String end) {
		return repo.findByRollNumberBetween(start, end);
	}

	@GetMapping(value = "/findByNameNot/{name}")
	public List<Student> findByNameNot(@PathVariable("name") String name) {
		return repo.findByNameNot(name);
	}

	@GetMapping(value = "/findByNameContainingIgnoreCase/{name}")
	public List<Student> findByNameContainingIgnoreCase(@PathVariable("name") String name) {
		return repo.findByNameContainingIgnoreCase(name);
	}

	@GetMapping(value = "/findByRollNumberGreaterThan/{rollnumber}")
	public List<Student> findByRollNumberGreaterThan(@PathVariable("rollnumber") String rollnumber) {
		return repo.findByRollNumberGreaterThan(rollnumber);
	}

	@GetMapping(value = "/findByRollNumberLessThan/{rollnumber}")
	public List<Student> findByRollNumberLessThan(@PathVariable("rollnumber") String rollnumber) {
		return repo.findByRollNumberLessThan(rollnumber);
	}

	// equality condition keyword
	@GetMapping("/findByActiveTrue")
	List<Student> findByActiveTrue() {
		return repo.findByActiveTrue();
	}

	@GetMapping("/findByActiveFalse")
	List<Student> findByActiveFalse() {
		return repo.findByActiveFalse();
	}

	// similarity condition keywords

	@GetMapping(value = "/findByNameLike/{name}")
	public List<Student> findByNameLike(@PathVariable("name") String name) {
		return repo.findByNameLike(name);
	}

	@GetMapping(value = "/findByNameNotLike/{name}")
	public List<Student> findByNameNotLike(@PathVariable("name") String name) {
		return repo.findByNameNotLike(name);
	}

	@GetMapping("/findByNameStartingWith/{prefix}")
	List<Student> findByNameStartingWith(@PathVariable("prefix") String prefix) {
		return repo.findByNameStartingWith(prefix);
	}

	@GetMapping("/findByNameEndingWith/{suffix}")
	List<Student> findByNameEndingWith(@PathVariable("suffix") String suffix) {
		return repo.findByNameEndingWith(suffix);
	}

	// comparison condition keywords
	@GetMapping("/findByAgeLessThan/{age}")
	List<Student> findByAgeLessThan(@PathVariable("age") Integer age) {
		return repo.findByAgeLessThan(age);
	}

	@GetMapping("/findByAgeLessThanEqual/{age}")
	List<Student> findByAgeLessThanEqual(@PathVariable("age") Integer age) {
		return repo.findByAgeLessThanEqual(age);
	}

	@GetMapping("/findByAgeGreaterThan/{age}")
	List<Student> findByAgeGreaterThan(@PathVariable("age") Integer age) {
		return repo.findByAgeGreaterThan(age);
	}

	@GetMapping("/findByAgeGreaterThanEqual/{age}")
	List<Student> findByAgeGreaterThanEqual(@PathVariable("age") Integer age) {
		return repo.findByAgeGreaterThanEqual(age);
	}

	@GetMapping("/findByBirthDateAfter/{birthDate}")
	List<Student> findByBirthDateAfter(
			@PathVariable(value = "birthDate") @DateTimeFormat(iso = ISO.DATE) LocalDate birthDate) {
		return repo.findByBirthDateAfter(birthDate);
	}

	@GetMapping("/findByBirthDateBefore")
	List<Student> findByBirthDateBefore(
			@RequestParam(value = "birthDate") @DateTimeFormat(iso = ISO.DATE) LocalDate birthDate) {
		return repo.findByBirthDateBefore(birthDate);
	}

	// multiple condition expressions
	@GetMapping("/findByNameOrBirthDate")
	List<Student> findByNameOrBirthDate(@RequestParam String name,
			@RequestParam(value = "birthDate") @DateTimeFormat(iso = ISO.DATE) LocalDate birthDate) {
		return repo.findByNameOrBirthDate(name, birthDate);
	}

	@GetMapping("/findByNameAndBirthDate")
	List<Student> findByNameAndBirthDate(@RequestParam String name,
			@RequestParam(value = "birthDate") @DateTimeFormat(iso = ISO.DATE) LocalDate birthDate) {
		return repo.findByNameAndBirthDate(name, birthDate);
	}

	@GetMapping("/findByNameOrBirthDateAndActive")
	List<Student> findByNameOrBirthDateAndActive(@RequestParam String name,
			@RequestParam(value = "birthDate") @DateTimeFormat(iso = ISO.DATE) LocalDate birthDate,
			@RequestParam Boolean active) {
		return repo.findByNameOrBirthDateAndActive(name, birthDate, active);
	}

	// sorting the results
	@GetMapping("/findByRollNumberOrderByRollNumber/{rollNumber}")
	List<Student> findByRollNumberOrderByRollNumber(@PathVariable("rollNumber") String rollNumber) {
		return repo.findByRollNumberOrderByRollNumber(rollNumber);
	}

	@GetMapping("/findByRollNumberOrderByRollNumberDesc/{rollNumber}")
	List<Student> findByRollNumberOrderByRollNumberDesc(@PathVariable("rollNumber") String rollNumber) {
		return repo.findByRollNumberOrderByRollNumberDesc(rollNumber);
	}

}
