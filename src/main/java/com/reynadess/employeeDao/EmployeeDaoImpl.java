package com.reynadess.employeeDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.reynadess.pojo.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	JdbcTemplate jdbcTemplate;
	private static final String getAllEmployeesQuery = "SELECT * FROM employees.employees;";
	private static final String getEmployeeByIdQuery = "SELECT * FROM employees.employees WHERE employee_id = ?;";
	private static final String setEmployeeQuery = "INSERT INTO employees.employees(employee_name, employee_password, email) VALUES (?, ?, ?);";
	
	public EmployeeDaoImpl() {
		super();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		final String query = "SELECT * FROM employees.employees;";
		List<Employee> employees = this.jdbcTemplate.query(EmployeeDaoImpl.getAllEmployeesQuery, new EmployeeMapper());
		return employees;
	}
	
	@Override
	public Employee getEmployeeById(int employeeId) {
		String query = "SELECT * FROM employees.employees WHERE employee_id = ?;";
		
		Employee employee = this.jdbcTemplate.query(EmployeeDaoImpl.getEmployeeByIdQuery, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, employeeId);
			}
			
		},new EmployeeResultSetExtractor());
		System.out.println(employee);
		return employee;
	}

	@Override
	public boolean setEmployee(Employee employee) {
		String query = "INSERT INTO employees.employees(employee_name, employee_password, email) VALUES (?, ?, ?);";
		int updated = this.jdbcTemplate.update(EmployeeDaoImpl.setEmployeeQuery, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, employee.getEmployeeName());
				ps.setString(2, employee.getEmployeePassword());
				ps.setString(3, employee.getEmployeePassword());
			}
			
		});
		if(updated == 1) {
			return true;
		}
		return false;
	}

}
