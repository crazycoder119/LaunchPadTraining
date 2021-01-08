package org.crazycoder.factorydesignpattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Package {
	
	protected List<Hotel> packageIncludes = new ArrayList<>();
	
	public Package() {
		createPackage();
	}

	protected abstract void createPackage();
	
	@Override
	public String toString() {return "Package(" +"includes" +packageIncludes +")";}
}
