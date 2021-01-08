package org.crazycoder.momentodesignpattern;

public class Application {
	public static void main(String args[]) {
		CareTaker careTaker = new CareTaker();
		Pizza pizza  = new Pizza();
		
		pizza.addTopin(new Topin("cheese"));
		pizza.addTopin(new Topin("chicken"));
		pizza.addTopin(new Topin("pork"));
		
		careTaker.save(pizza);
		System.out.println(pizza);
		
		pizza.addTopin(new Topin("ginger"));
		careTaker.save(pizza);
		System.out.println(pizza);
		
		careTaker.revert(pizza);
		System.out.println(pizza);
		
		careTaker.revert(pizza);
		System.out.println(pizza);
		
	}
}
