package org.crazycoder.factorydesignpattern;

public class Application {
	public static void main(String args[]) {
		Package offer1 = PackageFactory.getPackage(PackageCode.DAYOUT);
		System.out.println(offer1);
		Package offer2 = PackageFactory.getPackage(PackageCode.ROMANCENIGHT);
		System.out.println(offer2);
		
	}
}
