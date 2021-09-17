package com.reynadess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.reynadess.employeeDao.EmployeeDaoImpl;
import com.reynadess.pojo.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	public static EmployeeDaoImpl staticEmployeeDao;
	@Autowired
	EmployeeDaoImpl employeeDao;
	
	public EmployeeServiceImpl() {
	}
	
	
	public EmployeeServiceImpl(EmployeeDaoImpl employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}


	public EmployeeDaoImpl getEmployeeDao() {
		return employeeDao;
	}



	public void setEmployeeDao(EmployeeDaoImpl employeeDao) {
		this.employeeDao = employeeDao;
		staticEmployeeDao = employeeDao;
	}



	public boolean authorisation(int employeeId, String password) {
		Employee employee = employeeDao.getEmployeeById(employeeId);
		if(employee.getEmployeePassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean setEmployee(Employee employee) {
		return this.employeeDao.setEmployee(employee);
	}
	
}
