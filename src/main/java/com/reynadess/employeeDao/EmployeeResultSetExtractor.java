package com.reynadess.employeeDao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.reynadess.pojo.Employee;

public class EmployeeResultSetExtractor implements ResultSetExtractor<Employee>{

	@Override
	public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
		if(rs.next()) {
			Employee employee = new Employee();
			System.out.println(employee);
			employee.setEmployeeId(rs.getInt(1));
			employee.setEmployeeName(rs.getString(2));
			employee.setEmployeePassword(rs.getString(3));
			employee.setEmail(rs.getString(4));
			return employee;
		}
		return null;
	}

}
