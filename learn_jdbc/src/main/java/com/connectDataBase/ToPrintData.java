package com.connectDataBase;
import java.sql.*;
import java.util.*;
public class ToPrintData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:postgresql://localhost:5432/college";
		String un = "postgres";
		String pass = "9305";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection(url,un,pass);
			
			String sql = "insert into student values(?,?,?)";
			
			PreparedStatement pstm = con.prepareStatement(sql);
			
			System.out.println("Enter the id: ");
			int jd  = sc.nextInt();
			pstm.setInt(1, jd);
			System.out.println("Enter the Name: ");
			String name = sc.next();
			pstm.setString(2, name);
			System.out.println("Enter teh Branch");
			String branch = sc.next();
			pstm.setString(3, branch);
			pstm.execute();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
