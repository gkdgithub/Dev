package com.quinnox.springandhibernateintegration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quinnox.springandhibernateintegration.dao.EmployeeDao;
import com.quinnox.springandhibernateintegration.model.Employee;
import com.quinnox.springandhibernateintegration.service.EmployeeService;

@Service("employeeService1")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	@Qualifier(value="employeeDao1")
	private EmployeeDao employeeDao;

	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

/*	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);	
	}*/

	@Override
	public void deleteEmployeeById(int id) {
		employeeDao.deleteEmployeeById(id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeDao.findAllEmployees();
	}

	@Override
	public void deleteAllEmployee() {
		employeeDao.deleteAllEmployee();
	}

}
