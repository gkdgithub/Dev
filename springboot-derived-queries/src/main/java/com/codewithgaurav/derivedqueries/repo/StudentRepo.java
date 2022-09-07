package com.codewithgaurav.derivedqueries.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithgaurav.derivedqueries.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	public List<Student> findFirst3ByName(String rollNumber);

	public List<Student> findByNameIs(String name);

	public List<Student> findByNameEquals(String name);

	public List<Student> findByRollNumber(String rollNumber);

	public List<Student> findByUniversity(String university);

	public List<Student> findTop2ByUniversity(String university);

	public List<Student> findByNameAndRollNumber(String name, String rollNumber);

	public List<Student> findByRollNumberIn(List<String> rollNumbers);

	public List<Student> findByRollNumberNotIn(List<String> rollNumbers);

	public List<Student> findByRollNumberBetween(String start, String end);

	public List<Student> findByNameNot(String name);

	public List<Student> findByNameContainingIgnoreCase(String name);

	public List<Student> findByNameLike(String name);

	public List<Student> findByNameNotLike(String name);

	public List<Student> findByRollNumberGreaterThan(String rollnumber);

	public List<Student> findByRollNumberLessThan(String rollnumber);

	// equality condition keyword
	List<Student> findByActiveTrue();

	List<Student> findByActiveFalse();

	// similarity condition keywords
	List<Student> findByNameStartingWith(String prefix);

	List<Student> findByNameEndingWith(String suffix);

	// comparison condition keywords
	List<Student> findByAgeLessThan(Integer age);

	List<Student> findByAgeLessThanEqual(Integer age);

	List<Student> findByAgeGreaterThan(Integer age);

	List<Student> findByAgeGreaterThanEqual(Integer age);

	List<Student> findByBirthDateAfter(LocalDate birthDate);

	List<Student> findByBirthDateBefore(LocalDate birthDate);

	// multiple condition expressions
	List<Student> findByNameOrBirthDate(String name, LocalDate birthDate);

	List<Student> findByNameAndBirthDate(String name, LocalDate birthDate);

	List<Student> findByNameOrBirthDateAndActive(String name, LocalDate birthDate, Boolean active);

	// sorting the results
	List<Student> findByRollNumberOrderByRollNumber(String rollNumber);

	List<Student> findByRollNumberOrderByRollNumberDesc(String rollNumber);

}
