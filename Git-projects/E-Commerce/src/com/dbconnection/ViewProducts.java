package com.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewProducts {
	
	public static void viewProducts() {
		System.out.println("Products View");
		System.out.println("--------------------");
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		String query = "select * from products order by Product_name";

		try {
			ps = con.prepareStatement(query);
			//ps.setDouble(1, price);
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println("+------------+--------------+-----------+--------+----------------+");
			System.out.println("| Product_ID | Product_name | Quantity  | Price  | Description    |");
			System.out.println("+------------+--------------+-----------+--------+----------------+");
			while(rs.next()) {
					
				System.out.println("| "+rs.getInt(1) +"\t     | " + rs.getString(2) +"\t    | "+ rs.getInt(3)+"\t| "+rs.getDouble(4)+"\t | "+rs.getString(5)+"\t  |");
			}
				System.out.println("+------------+--------------+-----------+--------+----------------+");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
