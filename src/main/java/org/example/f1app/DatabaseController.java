package org.example.f1app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseController {
    // Database connection details
    private static final String URL = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql5686959"; // Database URL
    private static final String USERNAME = "sql5686959"; // Database username
    private static final String PASSWORD = "9Ktb5x1RiC"; // Database password

    static {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Print error message if the driver cannot be loaded
            System.err.println("Error loading MySQL JDBC driver: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }

    // Method to establish a database connection
    public static Connection getConnection() throws SQLException {
        // Establish a connection using DriverManager
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
