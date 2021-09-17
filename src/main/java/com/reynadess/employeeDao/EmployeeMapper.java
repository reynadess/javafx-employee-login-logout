package com.reynadess.employeeDao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.reynadess.pojo.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeId(rs.getInt(1));
		employee.setEmployeeName(rs.getString(2));
		employee.setEmployeePassword(rs.getString(3));
		employee.setEmail(rs.getString(4));
		return employee;
	}

}
