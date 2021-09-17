package com.reynadess.services;

import com.reynadess.pojo.Employee;

public interface EmployeeService {
	public boolean authorisation(int employeeId, String password);
	public boolean setEmployee(Employee employee);
}
