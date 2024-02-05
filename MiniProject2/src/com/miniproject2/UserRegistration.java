package com.miniproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;import com.mysql.cj.exceptions.RSAException;
import com.mysql.cj.protocol.Resultset;

public class UserRegistration implements UserOpration{
	msgPrint msgPrint = new msgPrint();
	ConnectionDatabase connectionDatabase = new ConnectionDatabase();
	Scanner scanner = new Scanner(System.in);

@Override
public void userRegistration() throws SQLException {
	//msgPrint msgPrint = new msgPrint();
//	Scanner scanner = new Scanner(System.in);
	System.out.println("------------Welcome to New Registration  Mode---------------");
	System.out.println("Enter the first name:-");
	String name = scanner.next();
	System.out.println("Enter the last name:-");
	String lname = scanner.next();
	System.out.println("Enter the username :-");
	String uname = scanner.next();
	System.out.println("Enter the password:-");
	String pass = scanner.next();
	System.out.println("Enter city");
	String city = scanner.next();
	System.out.println("Enter Mail Id");
	String mail = scanner.next();
	System.out.println("Enter mob no");
	String mob = scanner.next();
		Connection con=null;
		PreparedStatement ps=null;
		try {
			//ConnectionDatabase connectionDatabase = new ConnectionDatabase();
			con = connectionDatabase.getConnection();
			ps=con.prepareStatement("insert into userdetails(Fname,lname,username,pass,city,mailId,mobNo)values(?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, lname);
			ps.setString(3, uname);
			ps.setString(4, pass);
			ps.setString(5, city);
			ps.setString(6, mail);
			ps.setString(7, mob);
			int a=ps.executeUpdate();
			System.out.println("-----------------Insertion Successfully------------"+1);
			System.out.println("Please Enter no according your choice...");
			msgPrint.msgDisplay();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			ps.close();
		}
		//Printdata(name,lname,uname,pass,city,mail,mob);
		
		
	}


//private static void Printdata(String name, String lname, String uname, String pass, String city, String mail,
//		int mob) {
//	System.out.println("user name is"+name+" "+"& last name is"+lname);
//	System.out.println("username is"+uname+" "+"& Password is"+pass);
//	System.out.println("user city name is"+city);
//	System.out.println("mail is "+mail);
//	System.out.println("Mob no is"+mob);
//	
//}
	


@Override
public void userLogin() {
	//msgPrint msgPrint = new msgPrint();
	System.out.println("------------Welcome to login Mode---------------");
	//ConnectionDatabase connectionDatabase = new ConnectionDatabase();
	try {
		System.out.println("Enter your Username");
		//Scanner scanner = new Scanner(System.in);
		String uname=scanner.next();
		System.out.println("Enter your password");
		String password=scanner.next();
		Connection con = connectionDatabase.getConnection();
		PreparedStatement ps=con.prepareStatement("select username,pass from userdetails");
			ResultSet rs=ps.executeQuery();
			Map<String, String> logindata = new HashMap<String, String>();
			boolean i=false;
//			while(rs.next()) {
//				logindata.put(rs.getString("username"),rs.getString("pass"));
//				Set s=logindata.keySet();
				while(rs.next()) {
					logindata.put(rs.getString("username"),rs.getString("pass")); // putting data into key value pair 
					if (rs.getString("username").equals(uname)&&rs.getString("pass").equals(password)) {
						i=true;
					}
//				}
//				for(Map.Entry<String,String> map : logindata.entrySet()) {
//					//if(map.getKey().equals(uname) && map.getValue().equals(password)) {
//					if(map.getKey().equals(uname)&& map.getValue().equals(password)) {
//						i = true;
//					}
				}
				if(i==true) {
					System.out.println("-----------------Login Successful------------...!!!");
				}else {
					System.out.println("INVALID USERNAME OR PASSWORD");
				}
				System.out.println("Please Enter no according your choice...");
				msgPrint.msgDisplay();

		con.close();
		ps.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}

@Override
public void userviewProductItem() {
		
	//ConnectionDatabase connectionDatabase = new ConnectionDatabase();
	
	try {
		Connection con = connectionDatabase.getConnection();
		System.out.println("----------------Welcome to userviewProductItem --------------- ");
		PreparedStatement ps=con.prepareStatement("select * from product order by product_id");
			ResultSet rs=ps.executeQuery();
			//TreeMap<Integer, String> treeMap = new TreeMap<>();
			//ArrayList al = new ArrayList();
			while(rs.next()) {
//				treeMap.put(rs.getInt("product_id"), rs.getString("pname"));
//				Set<Integer>s=treeMap.keySet();
//				System.out.println(treeMap);
				System.out.println("id-->"+rs.getString("id"));
				System.out.println("Product Id>>"+rs.getString("product_id"));
				System.out.println("Product Name>>"+rs.getString("pname"));
				System.out.println("Product Description>>"+rs.getString("pdesc"));
				System.out.println("Available Quantity>>"+rs.getString("aval_quant"));
				System.out.println("Price>>"+rs.getString("price"));				
			}
			System.out.println("---------------------------------------------------------------");
			msgPrint.msgDisplay();
			con.close();
			ps.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
}

@Override
public void buyProduct() {
	try {
		
		Connection con=connectionDatabase.getConnection();
		PreparedStatement ps=con.prepareStatement("select product_id,aval_quant from product");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int quantity=0;
			System.out.println("Product id-->"+rs.getString("product_id"));
			System.out.println("Available Quantity"+rs.getString("aval_quant"));
			System.out.println("------------------------------------------------");
//			System.out.println("Enter the product id to buy product>>");
//			int productId = scanner.nextInt();
//			System.out.println("Enter the Quantity");
//			quantity = scanner.nextInt();
////			quantity=rs.getString("aval_quant")-quantity;
//			con.prepareStatement("UPDATE product SET aval_quant =? WHERE product_id = ?");
//			ps.setInt(1, quantity);
//	        ps.setString(2, "101");
				
			
		}
		

//		System.out.println("Do you want to view cart (Yes/No)\r\n" + "");
//		if (quantity!=0 ) {
//			avl=quantity-avl;
//			
//		}
//		else {
//			System.out.println("Quantity should be greater than Zero(0)");
//		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
}

@Override
public void viewCart() {
	// TODO Auto-generated method stub
	
}

@Override
public void purchaseItem() {
	// TODO Auto-generated method stub
	
}
}
