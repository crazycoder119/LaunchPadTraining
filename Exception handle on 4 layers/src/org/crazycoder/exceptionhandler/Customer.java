package org.crazycoder.exceptionhandler;
import java.io.FileNotFoundException;

public class Customer {
	public void addCustomerDetails(String orderOwner) throws FileNotFoundException  {
		
		UserAccounts.getUserAccounts(orderOwner);
	}
	
}

