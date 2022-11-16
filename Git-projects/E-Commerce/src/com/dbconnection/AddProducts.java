package com.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddProducts {
	
	
		
		public static void addProducts() {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = null;
			String query = "insert into products(Product_ID, Product_name, Quantity, Price, Description) values(?,?,?,?,?)";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter product id: ");
			int product_ID = sc.nextInt();
			System.out.println("Enter product name: ");
			String product_name = sc.next();
			System.out.println("Enter quantity: ");
			int quantity = sc.nextInt();
			System.out.println("Enter price: ");
			Double price = sc.nextDouble();
			System.out.println("Enter description: ");
			String description = sc.next();
			try {
				ps = con.prepareStatement(query );
				ps.setInt(1,product_ID);
				ps.setString(2, product_name);
				ps.setInt(3, quantity);
				ps.setDouble(4, price);
				ps.setString(5, description);
				
				int record = ps.executeUpdate();
				System.out.println(record + " record inserted successfully....");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


	}



