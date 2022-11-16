package com.ecommerce;

import java.util.Scanner;

import com.dbconnection.AddProducts;
import com.dbconnection.CheckQuantityOfProducts;
import com.dbconnection.DeleteProducts;
import com.dbconnection.UpdateProducts;
import com.dbconnection.ViewCustomerList;
import com.dbconnection.ViewProducts;
import com.dbconnection.ViewPurchaseList;

public class AdminMenu {
	public static boolean LoginAdmin() {
		boolean flag=false;
		System.out.println("Admin Log-In");
        System.out.println("--------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name:");
		String name=sc.next();
		System.out.println("Enter password:");
		String passwd=sc.next();
		if(name.equals("Admin") && passwd.equals("admin1234")) {
			System.out.println("Login successful.....");
			getAdminMenu();
		}

		return flag;

		
	}
	
	public static void getAdminMenu() {
		int choice;
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("Enter 1 for Add Products");
			System.out.println("Enter 2 for Delete products");
			System.out.println("Enter 3 for Update products");
			System.out.println("Enter 4 for View products");
			System.out.println("Enter 5 for View customer list");
			System.out.println("Enter 6 for check quantity of products");
			System.out.println("Enter 7 for view purchase histrory");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				AddProducts.addProducts();
				break;
			case 2: 
				DeleteProducts.deleteProducts();
				break;
			case 3:
				UpdateProducts.updateProducts();
				break;
			case 4:
				ViewProducts.viewProducts();
				break;
			case 5:
				ViewCustomerList.viewCustomerList();
			    break;
			case 6:
				CheckQuantityOfProducts.checkQuantityOfProducts();
				break;
				
			case 7:
				ViewPurchaseList.viewPurchaseList();
				break;
			
			default:
				Main.mainMenu();
			}
		}
		
	}


}
