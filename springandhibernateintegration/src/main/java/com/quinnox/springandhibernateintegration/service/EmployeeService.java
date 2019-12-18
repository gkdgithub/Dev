package com.quinnox.springandhibernateintegration.service;

import java.util.List;

import com.quinnox.springandhibernateintegration.model.Employee;

public interface EmployeeService {
		
	public Employee findById(int id);
    
	public void saveEmployee(Employee employee);
     
	public void updateEmployee(Employee employee);
     
	public void deleteEmployeeById(int id);
 
	public List<Employee> findAllEmployees(); 
    
	public void deleteAllEmployee();
}
