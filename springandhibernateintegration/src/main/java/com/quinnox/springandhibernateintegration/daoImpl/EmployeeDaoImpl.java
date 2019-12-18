package com.quinnox.springandhibernateintegration.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.quinnox.springandhibernateintegration.AbstractDao.AbstractDao;
import com.quinnox.springandhibernateintegration.dao.EmployeeDao;
import com.quinnox.springandhibernateintegration.model.Employee;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao{
	
	public EmployeeDaoImpl() {
		super(Employee.class);
	}
	
	@Override
	public Employee findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		update(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		delete(id);
	}

	
	@Override
	public List<Employee> findAllEmployees() {
		
		/*String queryString="Select * from emp_table";
		Query nativeQuery= getSession().createNativeQuery(queryString);
		List<Employee> employees=nativeQuery.list();*/
		
		Criteria criteria=createEntityCriteria();
		List<Employee> employees=criteria.list();
		return employees;
	}

	
	@Override
	public void deleteAllEmployee() {
		Query nativeQuery=getSession().createNativeQuery("delete from emp_table");
		nativeQuery.executeUpdate();
	}

}
