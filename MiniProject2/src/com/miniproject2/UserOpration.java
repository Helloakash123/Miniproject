package com.miniproject2;

import java.sql.SQLException;

public interface UserOpration {
	public void userRegistration() throws SQLException;
	public void userLogin();
	public void userviewProductItem();
	public void buyProduct();
	public void  viewCart();
	public void purchaseItem();


}
