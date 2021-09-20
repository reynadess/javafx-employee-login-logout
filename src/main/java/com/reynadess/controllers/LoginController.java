package com.reynadess.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reynadess.App;
import com.reynadess.services.EmployeeServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class LoginController implements Initializable{

    @FXML
    private Pane pane;

    @FXML
    private Label loginText;

    @FXML
    private Label employeeIDLabel;

    @FXML
    private TextField employeeIdTextField;
    
    @FXML
    private Label onlyDigitsLabel;    

    @FXML
    private Label passwordLabel;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private Button signInButton;
    
    EmployeeServiceImpl employeeServices;
    
    @FXML
    void signInMethod(ActionEvent event) throws IOException {
    	if(employeeServices.loginValidation(employeeIdTextField.getText(), passwordPasswordField.getText()) == false) {
    		onlyDigitsLabel.setText("Digits only please!");
    		return;
    	}
    	onlyDigitsLabel.setText("");
    	if(employeeServices.authorisation(Integer.parseInt(employeeIdTextField.getText()), passwordPasswordField.getText())) {
    		System.out.println("Login successful!");
    		App.setScene("ViewAllEmployees");
    	}
    	else {
    		System.out.println("Login Failed!");
    	}
    }
    
    @FXML
    void RegisterNewEmployeeMethod(ActionEvent event) throws IOException {
    	App.setScene("RegisterEmployee");
    }

    @FXML
    void employeeIdTextFieldValidation(KeyEvent event) {
    	
    	if(employeeServices.loginValidation(employeeIdTextField.getText(), passwordPasswordField.getText())) {
    		onlyDigitsLabel.setText("");
    		System.out.println(employeeIdTextField.getText());
    	}
    	else {
    		onlyDigitsLabel.setText("Digits only please!");
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
    	employeeServices = context.getBean(EmployeeServiceImpl.class);		
	}
}
