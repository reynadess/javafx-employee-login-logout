package com.reynadess;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
	
	private static Scene scene;
	private static Stage stage;
	
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		primaryStage.setTitle("Employee Management");
		primaryStage.setScene(new Scene(loadFXML("Homepage")));
		primaryStage.show();
	}	
    public static void setScene(String fxml) throws IOException {
        stage.setScene(new Scene(loadFXML(fxml)));
    }

    private static Parent loadFXML(String fxml) throws IOException {
		String url = "/FXMLFiles/" + fxml + ".fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(url));
        Parent root = fxmlLoader.load();
        System.out.println(root);
        return root;
    }
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
