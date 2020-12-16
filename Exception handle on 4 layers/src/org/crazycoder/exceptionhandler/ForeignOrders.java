package org.crazycoder.exceptionhandler;
import java.math.BigDecimal;

public class ForeignOrders {
	public BigDecimal addShipingCharges(String billAmount,int sellerID) {
		BigDecimal bill = new BigDecimal(billAmount);
		BigDecimal interest = new BigDecimal("0");
		BigDecimal lastAmount = null ;
		try {
			 lastAmount = bill.divide(interest);
		} 
		catch (ArithmeticException arithmeticException) {
			System.out.println("Arithmatic exception devide by zero " +arithmeticException);
		}
		try {
		Ratings.updateSellerRatings(sellerID, lastAmount);
		} catch(SellerNotFoundException sellerNotFoundException){
			System.out.println("Seller not found in foreignorders" +sellerNotFoundException);
		}
		return lastAmount;
	}
}
