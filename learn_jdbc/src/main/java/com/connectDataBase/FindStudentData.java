package com.connectDataBase;
import java.sql.*;
public class FindStudentData {
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/college";
		String un = "postgres";
		String pass = "9305";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection(url,un,pass);
			
			Statement st  = con.createStatement();
			String query = "Select * from student";
			
			ResultSet res = st.executeQuery(query);
			while(res.next())
			{
				int id = res.getInt("id");
				String branch = res.getString("branch");
				String name = res.getString("name");
				
				System.out.println("ID-: "+id+ " | "+"Name-: "+name+ " | "+ "Branch-: "+ branch);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
