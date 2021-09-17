package com.reynadess.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reynadess.pojo.Employee;
import com.reynadess.services.EmployeeServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private Label RegisterNewEmployeeLabel;

    @FXML
    private Label EmployeeNameLabel;

    @FXML
    private Label PasswordLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField employeeNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    void registerMethod(ActionEvent event) {
    	Employee employee = new Employee();
    	employee.setEmployeeName(employeeNameTextField.getText());
    	employee.setEmail(emailTextField.getText());
    	employee.setEmployeePassword(passwordField.getText());
    	ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
    	EmployeeServiceImpl employeeServices = context.getBean(EmployeeServiceImpl.class);
    	employeeServices.setEmployee(employee);
    }

}