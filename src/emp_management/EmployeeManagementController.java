package emp_management;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class EmployeeManagementController {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField email;
    @FXML
    private TableView<Employee> employeesTable;
    @FXML
    private TableColumn<Employee, String> usernameColumn;
    @FXML
    private TableColumn<Employee, String> passwordColumn;
    @FXML
    private TableColumn<Employee, String> emailColumn;


    private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

   

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public void write_on_label() throws IOException {
        
       
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("control_panel.fxml"));
        Parent root = loader.load();

        // Configurer la scène et la fenêtre principale
        Scene scene = new Scene(root, 800, 600);
		primaryStage.setTitle("Employee Management");
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void handleCreateEmployee(ActionEvent event) {
        String user_name = username.getText();
        String pass_word = password.getText();
        String mail = email.getText();
        employeeDAO.createEmployee(user_name, pass_word, mail);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Employee Created");
        alert.setContentText("The employee has been successfully created!");

        alert.showAndWait();
      
    }

    @FXML
    private void handleUpdateEmployee(ActionEvent event) {
        // Example, update based on hardcoded ID
        int id = 1; // Replace with actual ID
        String user = username.getText();
        String pass = password.getText();
        String mail = email.getText();
        employeeDAO.updateEmployee(id, user, pass, mail);
      
    }

    @FXML
    private void handleDeleteEmployee(ActionEvent event) {
        // Example, delete based on hardcoded ID
        int id = 1; // Replace with actual ID
        employeeDAO.deleteEmployee(id);
        
    }

    @FXML
    private void handleViewEmployees(ActionEvent event) {
        ResultSet rs = employeeDAO.getEmployees();
        // Code to handle and display ResultSet, for example, update a TableView
    }
    
    @FXML
    public void initialize() {
        // Initialize the columns
        usernameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsername()));
        passwordColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPassword()));
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));

        // Load the employees
        loadEmployees();
    }

    private void loadEmployees() {
        ResultSet rs = getEmployees();
        try {
            while (rs.next()) {
                Employee emp = new Employee(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email")
                );
                employeeList.add(emp);
            }
            employeesTable.setItems(employeeList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get employees from database (Assuming it is in a class like DatabaseManager)
    private ResultSet getEmployees() {
        String sql = "SELECT * FROM employees";
        try {
            Connection conn = DatabaseManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
