package org.crazycoder.exceptionhandler;
import java.io.FileNotFoundException;

public class UserAccounts {
	public static void getUserAccounts(String orderOwner) throws FileNotFoundException {
		// Check customer is SriLankan 
		SrilankaUsers.getSrilankaUsers();
	}
}
