package org.crazycoder.exceptionhandler;
import java.io.FileNotFoundException;

public class UserAccounts {
	public static void getUserAccounts(String orderOwner) throws FileNotFoundException {
		SrilankaUsers.getSrilankaUsers();
	}
}
