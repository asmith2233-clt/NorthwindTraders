package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Connection details for the Northwind MySQL database
        String url = "jdbc:mysql://localhost:3306/northwind";
        String user = "root";
        String password = "yearup";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to Northwind!");

            String sql = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                // TABLE FORMAT
                System.out.println("\n=== PRODUCT LIST ===\n");
                System.out.printf("%-5s %-30s %-10s %-10s\n", "Id", "Name", "Price", "Stock");
                System.out.println("---------------------------------------------------------------");

                while (rs.next()) {
                    System.out.printf("%-5d %-30s %-10.2f %-10d\n",
                            rs.getInt("ProductID"),
                            rs.getString("ProductName"),
                            rs.getDouble("UnitPrice"),
                            rs.getInt("UnitsInStock"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
