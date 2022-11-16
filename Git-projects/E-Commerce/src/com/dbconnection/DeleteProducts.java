package com.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteProducts {
	
	public static void deleteProducts() {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		String query = "delete from products where Product_ID = ?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			System.out.println(i + " record is deleted...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
