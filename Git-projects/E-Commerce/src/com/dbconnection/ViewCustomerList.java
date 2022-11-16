package com.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewCustomerList {
	
	public static void viewCustomerList() {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		String query = "select * from customers";
		
		try {
			ps = con.prepareStatement(query );

            ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
					
				System.out.println("Name: "+rs.getString(1) +"\tGender: " + rs.getString(2) +"\tEmail: "+ rs.getString(3)+"\tMobile no: "+rs.getLong(4));
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
