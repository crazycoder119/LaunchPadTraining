package org.crazycoder.factorydesignpattern;

public class PackageFactory {
	public static Package getPackage(PackageCode packageCode) {
		switch (packageCode) {
		case DAYOUT:
			return new Dayout();
		case ROMANCENIGHT:
			return new RomanceNight();
		default:
			return null;
		}
	}
	
}
