package org.crazycoder.exceptionhandler;
import java.io.FileNotFoundException;

public class Customer {
	public void addCustomerDetails(String orderOwner) throws FileNotFoundException  {
		// Get the user accounts and add the detail to order
		UserAccounts.getUserAccounts(orderOwner);
	}
	
}

