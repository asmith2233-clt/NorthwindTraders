package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Connection details for the Northwind MySQL database
        String url = "jdbc:mysql://localhost:3306/northwind";
        String user = "root";
        String password = "yearup";

        // Try connecting to the database using JDBC
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to Northwind!");


            String sql = "SELECT ProductName FROM products";  // SQL query to get all product names
            try (Statement stmt = conn.createStatement(); // Execute the query and loop through the results
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {   // Display each product name
                    System.out.println(rs.getString("ProductName"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // If something goes wrong, show the error
        }


    }
}
