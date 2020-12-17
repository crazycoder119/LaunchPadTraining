package org.crazycoder.exceptionhandler;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;

public class Payment {

	public void payBill(String orderOwner, boolean foreignOrder, String billAmount, int pieces, int sellerID) {
		try {
			// Add customer details to customer files
			Customer customer = new Customer();
			customer.addCustomerDetails(orderOwner);
		} catch (FileNotFoundException fileNotFoundException) {
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			fileNotFoundException.printStackTrace(printWriter);
			System.out.println(stringWriter.toString());
		}

		if (foreignOrder) {
			// Add shipping charges and others for foreign orders
			ForeignOrders foreignOrders = new ForeignOrders();
			BigDecimal lastAmount = foreignOrders.addShipingCharges(billAmount, sellerID);
		}
	}

}
