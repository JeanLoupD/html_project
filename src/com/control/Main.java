package com.control;

import com.model.Database;
import com.model.InventoryDatabase;
import com.model.OrderDatabase;
import com.model.StoreDatabase;
import com.view.CreateClient;
import com.view.Login;

public class Main {
	
	public static void main(String[] args) {
		//Calling the database page
		Database model = new Database();
		
		//Calling the Store Database
		StoreDatabase storeDb = new StoreDatabase();
		
		//Calling the Inventory Database
		InventoryDatabase inventoryDb = new InventoryDatabase();
		
		//Calling the order history Database
		OrderDatabase orderDb = new OrderDatabase();
		
		//Calling the login page with his controller
		Login loginView = new Login();
		LoginController controller = new LoginController(loginView, model);

	}

}
