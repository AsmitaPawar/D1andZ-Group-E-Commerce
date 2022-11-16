package com.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.dbconnection.DBUtil;

public class CustomerRegistration {
	
	private String cust_Name;
	private String gender;
	private String Email;
	private long MobileNo;
	private String password;
	
	public String getCust_Name() {
		return cust_Name;
	}
	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(long mobileNo) {
		MobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
public String registerCustomer() {
	    System.out.println("First register yourself.......\n"); 
	    Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		System.out.println("Enter your gender(F/M): ");
		String gender = sc.next();
		System.out.println("Enter email: ");
		String email= sc.next();
		System.out.println("Enter moblile no.: ");
		long mobileNo = sc.nextLong();
		System.out.println("Enter password: ");
		String passwd = sc.next();
		
		CustomerRegistration user = new CustomerRegistration();
		user.setCust_Name(name);
		user.setGender(gender);
		user.setEmail(email);
		user.setMobileNo(mobileNo);
		user.setPassword(passwd);
		
		System.out.println("-------------------------------");
		//System.out.println("Your name is: "+user.getCust_Name());
		//System.out.println("Your email is: "+user.getEmail());
		
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		String query = "insert into customers(name, gender, email, mobileno, password) values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(query );
			ps.setString(1, user.getCust_Name());
			ps.setString(2, user.getGender());
			ps.setString(3, user.getEmail());
			ps.setLong(4, user.getMobileNo());
			ps.setString(5, user.getPassword());
			
			
			int record = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
				ps.close();
				System.out.println("Registration process is successful......");
				System.out.println("-------------------------------");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return email;
}


}
