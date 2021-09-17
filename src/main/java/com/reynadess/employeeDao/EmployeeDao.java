package com.reynadess.employeeDao;

import java.util.List;

import com.reynadess.pojo.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int employeeId);
	
	public boolean setEmployee(Employee employee);
}
