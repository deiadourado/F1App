package org.example.f1app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseController {
    // Database connection details
    private static final String URL = "jdbc:sqlserver://deiadourado.database.windows.net:1433;database=FormulaOne;"; // Database URL
    private static final String USERNAME = "deia@deiadourado"; // Database username
    private static final String PASSWORD = "Formulaone1"; // Database password

    // Method to establish a database connection
    public static Connection getConnection() throws SQLException {
        // Establish a connection using DriverManager
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
