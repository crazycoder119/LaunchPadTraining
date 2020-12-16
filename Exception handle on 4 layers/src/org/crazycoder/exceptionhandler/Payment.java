package org.crazycoder.exceptionhandler;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class Payment {

	public void payBill(String orderOwner, boolean foreignOrder, String billAmount, int pieces, int sellerID) {
		try {
			// Add customer details to customer files
			Customer customer = new Customer();
			customer.addCustomerDetails(orderOwner);
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("Customer details not updated fileNotFoundException" +fileNotFoundException);
		}

		if (foreignOrder) {
			ForeignOrders foreignOrders = new ForeignOrders();
			BigDecimal lastAmount = foreignOrders.addShipingCharges(billAmount, sellerID);
		}
	}

}
