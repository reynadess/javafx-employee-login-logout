package com.reynadess.pojo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {
	IntegerProperty employeeId;
	StringProperty employeeName;
	StringProperty employeePassword;
	StringProperty email;
	
	public Employee() {
		employeeId = new SimpleIntegerProperty();
		employeeName = new SimpleStringProperty();
		employeePassword = new SimpleStringProperty();
		email = new SimpleStringProperty();
	}
	
	public int getEmployeeId() {
		return employeeId.get();
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId.set(employeeId);
	}
	
	public IntegerProperty employeeIdProperty() {
		return this.employeeId;
	}
	
	public String getEmployeeName() {
		return employeeName.get();
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName.set(employeeName);
	}
	public StringProperty employeeNameProperty() {
		return this.employeeName;
	}
	
	public String getEmployeePassword() {
		return employeePassword.get();
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword.set(employeePassword);;
	}
	public StringProperty employeePasswordProperty() {
		return employeePassword;
	}
	
	public String getEmail() {
		return email.get();
	}
	public void setEmail(String email) {
		this.email.set(email);
	}
	public StringProperty emailProperty() {
		return email;
	}

}
