package com.ecommerce;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		System.out.println(" \t\t\t XYZ SHOP \t\t\t  ");
		System.out.println(" \t\t HEARTLY WELCOME \t\t\t \n ");
		mainMenu();
	}
	
    public static void exit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("if you want to  continue (y/n)");
		
		char process=sc.next().charAt(0);
		if (process=='y') {
			mainMenu();
		}
		else {
			System.out.println("Thank you for visiting");
		}
	}
	
    public static void mainMenu() {
		
		int choice;
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\t\t\tMAIN MENU");
			System.out.println("\t\tPress 1 for customer");
			System.out.println("\t\tPress 2 for Admin");
			System.out.println("\t\tPress 3 for Exit");
			System.out.println("\t\tEnter your choice");
			choice = sc.nextInt();
			switch(choice) {
			case 1: 
				CustomerMenu.getCustomerMenu();
				break;
				
			case 2: 
				AdminMenu.LoginAdmin();
				break;
				
			case 3:
		        exit();
		        break;
				
			default:
				System.out.println("Invalid input....");
			}
		}
		
		
	}

}
