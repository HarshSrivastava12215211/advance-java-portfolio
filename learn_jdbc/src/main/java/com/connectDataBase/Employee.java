package com.connectDataBase;

import java.sql.*;


public class Employee {
	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/college";
		String un = "postgres";
		String pass = "9305";
		String insert_Query = "insert into employee values(1, 15200, 'Harsh')";
		String insert_Query1 = "insert into employee values(2, 55200, 'Yusuf')";
		String insert_Query2 = "insert into employee values(3, 25200, 'Aroh')";
		String insert_Query3 = "insert into employee values(4, 55200, 'Shivansh')";
		String insert_Query4 = "insert into employee values(5, 95200, 'Roshan')";
		try {
			Class .forName("org.postgresql.Driver");
			
			System.out.println("Connection Established");
			Connection con = DriverManager.getConnection(url, un, pass);
			Statement st = con.createStatement();
//			st.execute(insert_Query);
//			st.execute(insert_Query1);
//			st.execute(insert_Query2);			
//			st.execute(insert_Query3);
//			st.execute(insert_Query4);
//			
//			System.out.println("Rows Insterted");
//			
			
			//String update_query = "Update employee SET name='Bitul' where id = '4'";
			//st.execute(update_query);
			String query = "Select * from employee";
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
                int id = res.getInt("id");         
                String name = res.getString("name"); 
                int sal = res.getInt("salary"); 
                System.out.println(id + " | " + name + " | "+sal);
            }

		} 
		catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
