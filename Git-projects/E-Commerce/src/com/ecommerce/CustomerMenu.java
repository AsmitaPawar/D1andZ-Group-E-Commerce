package com.ecommerce;

import com.dbconnection.AddToCart;
import com.dbconnection.ViewProducts;

public class CustomerMenu {
	
	public static void getCustomerMenu() {
		CustomerRegistration cr = new CustomerRegistration();
		String email = cr.registerCustomer();
		
		 ViewProducts.viewProducts();
		 AddToCart.addToCart(email);
		
		 
	}

}
