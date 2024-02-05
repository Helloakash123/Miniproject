package com.miniproject2;

import java.sql.SQLException;
import java.util.Scanner;

public class msgPrint {
	public void msgDisplay() throws SQLException {
		System.out.println("User Operation\r\n" + "1. User Registration\r\n" + "2. User Login\r\n"
				+ "3. User view Product item as Sorted Order\r\n" + "4. Buy Product\r\n" + "5. View Cart \r\n"
				+ "6. Purchase the item");
		System.out.println("Enter your choice");
		Scanner scanner = new Scanner(System.in);
		int no = scanner.nextInt();
		int choice = no;
		UserRegistration userRegistration = new UserRegistration();
		switch (choice) {
		case 1:

			userRegistration.userRegistration();
			break;
		case 2:

			userRegistration.userLogin();
			break;
		case 3:

			userRegistration.userviewProductItem();
			break;
		case 4:

			userRegistration.buyProduct();;
			break;

		default:
			System.out.println("Please Valid Enter no!!!!!!");
			break;
		}
	}
}
