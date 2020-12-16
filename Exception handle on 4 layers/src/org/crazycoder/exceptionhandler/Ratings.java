package org.crazycoder.exceptionhandler;
import java.math.BigDecimal;

public class Ratings {
	public static void  updateSellerRatings(int sellerID, BigDecimal amount) throws SellerNotFoundException {
		throw new SellerNotFoundException();
	}
}
