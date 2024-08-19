/**
 * 
 */
/**
 * 
 */

module emp_management {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.base;

    opens emp_management to javafx.fxml;
    exports emp_management;
}

