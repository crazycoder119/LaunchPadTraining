package org.crazycoder.chainofresponsibilitydesignpattern;

public class Application {
	public static void main(String args[]) {
		Order order = new Order();
		Kitchen kitchen = new Kitchen();
		Table table = new Table();
		Bill bill = new Bill();
		Rate rate = new Rate();
		
		order.setSuccessor(kitchen);
		kitchen.setSuccessor(table);
		table.setSuccessor(bill);
		bill.setSuccessor(rate);
		
		Customer customer  = new Customer();
		order.processWork();
		
	}
}
