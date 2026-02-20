package com.connectDataBase;
import java.sql.*;
public class StepsToConnectDataBase {
	
	public static void main(String[] args) {
		//Load the driver
		try {
			String query = "Select * from student";
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/college","postgres","9305");
			System.out.println("Conncetion Created!!");
			String insert_query = "insert into student values(5, 'Aroh','MEC')";
			String update_query = "UPDATE student SET branch = 'CSE' WHERE id = 2";
			Statement st = con.createStatement();
			st.execute(insert_query);
			st.executeUpdate(update_query);
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
                int id = res.getInt("id");         
                String name = res.getString("name"); 
                String branch = res.getString("branch"); 
                System.out.println(id + " | " + name + " | "+branch);
            }

			res.close();
            st.close();
            con.close();

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
