package org.crazycoder.momentodesignpattern;

import java.util.Stack;

public class CareTaker {
	/**
	 * use stack for getting last in first out better for revert
	 */
	Stack<Pizza.PizzaMomento> history = new Stack<>();
	
	public void save(Pizza pizza) {
		history.push(pizza.save());
	}
	
	public void revert(Pizza pizza) {
		if(!history.isEmpty()) {
			pizza.revert(history.pop());  
		} else {
			System.out.println("Cannot undo cart is empty");
		}
	}
	
}
