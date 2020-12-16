package org.crazycoder.exceptionhandler;
public class Application {

	public static void main(String[] args)  {
		Payment payment =new Payment();
		/**
		 * Process of payement
		 * String customer, boolean foreignOrder, String billAmount, int pieces, int sellerID
		 */
		payment.payBill("Chandima", true, "100", 2, -1223);
	}
}
