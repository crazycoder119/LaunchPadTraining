package org.crazycoder.momentodesignpattern;

import java.util.ArrayList;

public class Pizza {
	ArrayList<Topin> topins = new ArrayList<>();
	
	public void addTopin(Topin topin) {
		topins.add(topin);
	}
	
	public ArrayList<Topin> getTopins() {
		return (ArrayList<Topin>) topins.clone();
	}
	
	public PizzaMomento save() {
		return new PizzaMomento(getTopins());
	}
	
	@Override
	public String toString() {
		return "Pizza [topins=" + topins + "]";
	}

	public void revert(PizzaMomento pizzamomento) {
		topins = pizzamomento.getTopins();
	}

	static class PizzaMomento{
		ArrayList<Topin> topins;
		
		public PizzaMomento(ArrayList<Topin> topins) {
			this.topins = topins;
		}

		private ArrayList<Topin> getTopins() {
			return topins;
		}
		
	}
	
	
}
