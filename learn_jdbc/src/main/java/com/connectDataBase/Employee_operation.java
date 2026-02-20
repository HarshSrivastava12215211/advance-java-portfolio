package com.connectDataBase;

import java.sql.*;
import java.util.Scanner;

public class Employee_operation {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/college";
        String user = "postgres";
        String pass = "9305";

        Scanner sc = new Scanner(System.in);

        try {

            // Load Driver
            Class.forName("org.postgresql.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(url, user, pass);

            System.out.println("Connected to Database ✅");

            // ================= INSERT =================

            String insertQuery =
                    "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";

            PreparedStatement insertStmt =
                    con.prepareStatement(insertQuery);

            System.out.println("\n--- Insert Employee ---");

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Salary: ");
            int salary = sc.nextInt();

            insertStmt.setInt(1, id);
            insertStmt.setString(2, name);
            insertStmt.setInt(3, salary);

            insertStmt.executeUpdate();

            System.out.println("Employee Inserted ✅");

            // ================= DELETE =================

            String deleteQuery =
                    "DELETE FROM employee WHERE id = ?";

            PreparedStatement deleteStmt =
                    con.prepareStatement(deleteQuery);

            System.out.println("\n--- Delete Employee ---");

            System.out.print("Enter ID to Delete: ");
            int deleteId = sc.nextInt();

            deleteStmt.setInt(1, deleteId);

            int del = deleteStmt.executeUpdate();

            if (del > 0)
                System.out.println("Deleted Successfully ✅");
            else
                System.out.println("ID Not Found ❌");

            // ================= UPDATE =================

            String updateQuery =
                    "UPDATE employee SET salary = ? WHERE id = ?";

            PreparedStatement updateStmt =
                    con.prepareStatement(updateQuery);

            System.out.println("\n--- Update Salary ---");

            System.out.print("Enter ID to Update: ");
            int updateId = sc.nextInt();

            System.out.print("Enter New Salary: ");
            int newSalary = sc.nextInt();

            updateStmt.setInt(1, newSalary);
            updateStmt.setInt(2, updateId);

            int up = updateStmt.executeUpdate();

            if (up > 0)
                System.out.println("Updated Successfully ✅");
            else
                System.out.println("ID Not Found ❌");

            // ================= FIND =================

            String selectQuery =
                    "SELECT * FROM employee WHERE id = ?";

            PreparedStatement selectStmt =
                    con.prepareStatement(selectQuery);

            System.out.println("\n--- Find Employee ---");

            System.out.print("Enter ID to Find: ");
            int findId = sc.nextInt();

            selectStmt.setInt(1, findId);

            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {

                System.out.println("\nEmployee Found ✅");

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Salary: " + rs.getInt("salary"));

            } else {
                System.out.println("Employee Not Found ❌");
            }

            // ================= CLOSE =================

            rs.close();
            insertStmt.close();
            deleteStmt.close();
            updateStmt.close();
            selectStmt.close();
            con.close();
            sc.close();

            System.out.println("\nAll Resources Closed ✅");

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
