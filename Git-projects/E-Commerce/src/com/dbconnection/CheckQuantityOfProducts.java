package com.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckQuantityOfProducts {
	
	public static void checkQuantityOfProducts() {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		String query = "select * from products where Product_ID = ?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product id: ");
		int id = sc.nextInt();
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("+------------+--------------+-----------+--------+");
			System.out.println("| Product_ID | Product_name | Quantity  | Price  |");
			System.out.println("+------------+--------------+-----------+--------+");
			while(rs.next()) {
					
				System.out.println("| "+rs.getInt(1) +"\t     | " + rs.getString(2) +"\t    | "+ rs.getInt(3)+"\t| "+rs.getDouble(4)+"\t | ");
			}
				System.out.println("+------------+--------------+-----------+--------+");
		} catch (SQLException e) {
			System.out.println("Sorry.....There is no product in shop.....");
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}
