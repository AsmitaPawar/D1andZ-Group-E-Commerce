package com.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewPurchaseList {
	
public static void viewPurchaseList() {
		
		System.out.println("purchase List View");
		System.out.println("--------------------");
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product Id: ");
		int product_id = sc.nextInt();
		String query = "select * from carts where product_id = ?";

		try {
			ps = con.prepareStatement(query);
			ps.setDouble(1, product_id);
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println("+---------------------+--------------+-----------+");
			System.out.println("|      email          | product_id   | Quantity  |");
			System.out.println("+---------------------+--------------+-----------+");
			while(rs.next()) {
					
				System.out.println("| "+rs.getString(1) +" | " + rs.getInt(2) +"\t    | "+ rs.getInt(3)+"  |  ");
			}
			System.out.println("+---------------------+--------------+-----------+");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
