package emp_management;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewManager {
	
	public void create_employee() throws IOException {
		Stage primaryStage = new Stage();
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("create_employee.fxml"));
	        Parent root = loader.load();

	        // Configurer la scène et la fenêtre principale
	        Scene scene = new Scene(root, 800, 600);
			primaryStage.setTitle("Employee Management");
	        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

	        primaryStage.setScene(scene);
	        primaryStage.show();
		
	}
	
	public void get_employees() throws IOException {
		Stage primaryStage = new Stage();
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("get_employees.fxml"));
	        Parent root = loader.load();

	        // Configurer la scène et la fenêtre principale
	        Scene scene = new Scene(root, 800, 600);
			primaryStage.setTitle("Employee Management");
	        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

	        primaryStage.setScene(scene);
	        primaryStage.show();
		
	}

}
