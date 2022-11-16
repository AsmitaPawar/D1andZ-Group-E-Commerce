package com.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddToCart {
	
public static void addToCart(String email) {
		
		Double totalprice = 0.0;
		Double carttotal = 0.0;
		Scanner sc=new Scanner(System.in);
		Connection con=DBUtil.getConnection();
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		System.out.println("Enter the product id you want to buy");
		int product_id=sc.nextInt();
		System.out.println("Enter the qunatity of your selected products");
		int quantity=sc.nextInt();
		String query="insert into carts values(?,?,?,?,?)";
		try {
			
			ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setInt(2, product_id);
			ps.setInt(3, quantity);
			ps.setDouble(4, totalprice);
			ps.setDouble(5, carttotal);
			int result=ps.executeUpdate();
			System.out.println("You want to Buy again (y/n)");
			char select=sc.next().charAt(0);
			
			if(select=='y') {
				addToCart(email);
			}
			System.out.println("********* Your cart ***********");
			String q1 = "select carts.email, products.product_id, products.product_name, products.price, carts.quantity,(products.price*carts.quantity) as totalprice, sum(totalprice) as carttotal"
					+ "   from products"
					+ "   inner join carts"
					+ "   on products.product_id= carts.product_id"
					+ "   where products.product_id='"+product_id+"'";
			ps1 = con.prepareStatement(q1);
			ResultSet rs = ps1.executeQuery();
//			String q2 = "insert into sales values(?,?,?,?,?,?)";
//			ps2 = con.prepareStatement(q2);
//			ps2.setInt(1, rs.getInt(2));
//			ps2.setString(2, rs.getString(3));
//			ps2.setInt(3, rs.getInt(5));
//			ps2.setString(4, rs.getString(1));
//			ps2.setDouble(5, rs.getDouble(4));
//			ps2.setDouble(6, rs.getDouble(6));
//			int record = ps2.executeUpdate();
			while(rs.next()) {
				
				System.out.println("email: "+rs.getString(1) +"   Product_id: " + rs.getInt(2) +"  product_name:  "+ rs.getString(3)+"  price:  "+rs.getDouble(4)+"   Quantity: "+rs.getInt(5)+"  totalprice: "+rs.getDouble(6)+"  carttotal: "+ rs.getDouble(7));

			}
			
			
			
     	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				con.close();
				ps.close();
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			System.out.println("Thank you for visiting");
		}
		
    }

}
