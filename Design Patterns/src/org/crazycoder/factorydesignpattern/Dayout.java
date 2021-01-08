package org.crazycoder.factorydesignpattern;

public class Dayout extends Package{

	@Override
	protected void createPackage() {
		packageIncludes.add(new WelcomeDrink());
		packageIncludes.add(new SwimingPool());
		packageIncludes.add(new Lunch());
		packageIncludes.add(new ChangingRoom());
		
	}

}
