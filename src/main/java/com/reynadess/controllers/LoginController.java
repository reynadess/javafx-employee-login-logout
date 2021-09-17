package com.reynadess.controllers;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reynadess.App;
import com.reynadess.employeeDao.EmployeeDaoImpl;
import com.reynadess.services.EmployeeServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Pane pane;

    @FXML
    private Label loginText;

    @FXML
    private Label employeeIDLabel;

    @FXML
    private TextField employeeIdTextField;

    @FXML
    private Label passwordLabel;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private Button signInButton;
    
    @FXML
    void signInMethod(ActionEvent event) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
    	EmployeeServiceImpl employeeServices = context.getBean(EmployeeServiceImpl.class);
    	if(employeeServices.authorisation(Integer.parseInt(employeeIdTextField.getText()), passwordPasswordField.getText())) {
    		System.out.println("Login successful!");
    	}
    	else {
    		System.out.println("Login Failed!");
    	}
    }
    
    @FXML
    void RegisterNewEmployeeMethod(ActionEvent event) throws IOException {
    	App.setScene("RegisterEmployee");
    }    


}
