package emp_management;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	

	@Override
	public void start(Stage primaryStage) throws Exception {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("employee_management.fxml"));
	        Parent root = loader.load();

	        // Configurer la scène et la fenêtre principale
	        Scene scene = new Scene(root, 800, 600);
			primaryStage.setTitle("Employee Management");
	        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

	        primaryStage.setScene(scene);
	        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		 launch(args);

	}

}
