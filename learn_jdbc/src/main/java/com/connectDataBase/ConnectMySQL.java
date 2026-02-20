package com.connectDataBase;
import java.sql.*;
public class ConnectMySQL {
	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/Practice";
		String username = "root";
		String pass = "9305";
		int id = 45;
		String sName = "Harsh";
		String query = "Insert into students values(?,?)";
		String data ="";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		    Connection con;
			con = DriverManager.getConnection(url, username, pass);
		
		
		PreparedStatement st = con.prepareStatement(query); 
		st.setInt(1, id);
		st.setString(2, sName);
		
		
		int count  = st.executeUpdate();
		
		System.out.println(count + " rows affteced");
	String output_query = "Select * from Students";
		
		ResultSet res = st.executeQuery(output_query);
		while(res.next())
		{
			int new_id = res.getInt("id");
			String name = res.getString("name");
			
			System.out.println(new_id + " | " +name);
		}
		st.close();
		con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(data);
		

	}
}
