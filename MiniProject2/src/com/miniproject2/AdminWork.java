package com.miniproject2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminWork implements AdminOpration{
	ConnectionDatabase connectiondatabase = new ConnectionDatabase();
	

	@Override
	public void addProductItem() {
		
		try {
			Connection con = connectiondatabase.getConnection();
			System.out.println("---------------Welcome to Admin Opration--------------");
			//con.prepareStatement("insert into product(product_id,pname,pdesc,aval_quant,price)(?,?,?,?,?)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void displayAmountToEndUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkQantity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkRegistredUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkParticulerRegisterHistory() {
		// TODO Auto-generated method stub
		
	}
	
	

}
