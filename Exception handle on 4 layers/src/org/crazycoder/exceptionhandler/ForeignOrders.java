package org.crazycoder.exceptionhandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;

public class ForeignOrders {
	public BigDecimal addShipingCharges(String billAmount, int sellerID) {
		// Add shipping charges to last amount according to the order 
		BigDecimal bill = new BigDecimal(billAmount);
		BigDecimal interest = new BigDecimal("0");
		BigDecimal lastAmount = null;
		try {
			lastAmount = bill.divide(interest);
		} catch (ArithmeticException arithmeticException) {
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			arithmeticException.printStackTrace(printWriter);
			System.out.println(stringWriter.toString());
			// System.out.println("Arithmatic exception devide by zero "
			// +arithmeticException);
		}
		try {
			Ratings.updateSellerRatings(sellerID, lastAmount);
		} catch (SellerNotFoundException sellerNotFoundException) {
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			sellerNotFoundException.printStackTrace(printWriter);
			System.out.println(stringWriter.toString());
			// System.out.println("Seller not found in foreignorders" +
			// sellerNotFoundException);
		}
		return lastAmount;
	}
}
