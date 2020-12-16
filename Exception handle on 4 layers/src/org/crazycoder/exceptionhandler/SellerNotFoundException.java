package org.crazycoder.exceptionhandler;

public class SellerNotFoundException extends Exception {
	
	public SellerNotFoundException(){
		super("Seller information file is not found");
	}
	
	public SellerNotFoundException(String message){
		super(message);
	}

}
