package com.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateProducts {
	
	public static void updateProducts() {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		String query = "update products set Product_name=?, Quantity=?, Price=?, Description=? where Product_ID = ?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product id: ");
		int product_id = sc.nextInt();
		System.out.println("Enter Product name: ");
		String product_name = sc.next();
		System.out.println("Enter quantity: ");
		int quantity = sc.nextInt();
		System.out.println("Enter price: ");
		Double price = sc.nextDouble();
		System.out.println("Enter description: ");
		String description = sc.next();
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1,  product_name);
			ps.setInt(2, quantity);
			ps.setDouble(3, price);
			ps.setString(4, description);
			ps.setInt(5, product_id);
			
			int i = ps.executeUpdate();
			System.out.println(i + " record updated successfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
