package org.crazycoder.factorydesignpattern;

public class RomanceNight extends Package{

	@Override
	protected void createPackage() {
		packageIncludes.add(new WelcomeDrink());
		packageIncludes.add(new Dinner());
		packageIncludes.add(new CoupleRoom());
		packageIncludes.add(new Breakfast());
		
	}

}
