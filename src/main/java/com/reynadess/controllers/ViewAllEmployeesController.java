package com.reynadess.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reynadess.App;
import com.reynadess.pojo.Employee;
import com.reynadess.services.EmployeeServiceImpl;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ViewAllEmployeesController implements Initializable {

	@FXML
	private Pane pane;

	@FXML
	private TableView<Employee> allEmployeesTableView;

	@FXML
	private TableColumn<Employee, String> employeeIdTableColumn;

	@FXML
	private TableColumn<Employee, String> employeeNameTableColumn;

	@FXML
	private TableColumn<Employee, String> emailTableColumn;

	@FXML
	private TableColumn<Employee, Button> updateTableColumn;

	@FXML
	private TableColumn<Employee, Button> deleteTableColumn;

	@FXML
	private TableColumn<Employee, Button> viewTableColumn;

	ObservableList<Employee> employees;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		employeeIdTableColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeId"));
		employeeNameTableColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
		emailTableColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
		updateTableColumn.setCellFactory(buttonPopulate("Update"));
		deleteTableColumn.setCellFactory(buttonPopulate("Delete"));
		viewTableColumn.setCellFactory(buttonPopulate("View"));

		buttonPopulate("Delete");
		buttonPopulate("View");
		allEmployeesTableView.getColumns().addAll(updateTableColumn, deleteTableColumn, viewTableColumn);

		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		EmployeeServiceImpl employeeServices = context.getBean(EmployeeServiceImpl.class);

		employees = FXCollections.observableArrayList();
		List<Employee> employeesList = employeeServices.getEmployeeDao().getAllEmployees();
		employees.addAll(employeesList);
		System.out.println(employees);
		allEmployeesTableView.setItems(employees);
	}

	private Callback<TableColumn<Employee, Button>, TableCell<Employee, Button>> buttonPopulate(String buttonName) {
		Callback<TableColumn<Employee, Button>, TableCell<Employee, Button>> cellFactory = new Callback<TableColumn<Employee, Button>, TableCell<Employee, Button>>() {

			public TableCell<Employee, Button> call(TableColumn<Employee, Button> param) {
				final TableCell<Employee, Button> cell = new TableCell<Employee, Button>() {
					private final Button btn = new Button(buttonName);

//						btn.setOnAction((ActionEvent event) -> {
//							Employee employee = getTableView().getItems().get(getIndex());
//							System.out.println(employee.getEmployeeName());
//							
//						});

					public void updateItem(Button item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
						} else {
							setGraphic(btn);
						}
						if (buttonName.equals("Update")) {
							btn.setOnAction((ActionEvent event) -> {
								Employee employee = getTableView().getItems().get(getIndex());
								System.out.println(employee.getEmployeeName());
								Stage primaryStage = new Stage();
								Parent root;
								try {
									root = FXMLLoader.load(getClass().getResource("/FXMLFiles/UpdateStage.fxml"));
									Scene scene = new Scene(root, 700, 500);
									primaryStage.setScene(scene);
									primaryStage.show();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							});
						} else if (buttonName.equals("Delete")) {
							System.out.println();
						} else {
							System.out.println();
						}
					}
				};
				return cell;
			}
		};
		return cellFactory;
	}

}
