package org.crazycoder.builderdesignpattern;


public class Application {
	public static void main(String args[]) {
		PC.Builder builder = new PC.Builder();
		PC customPC1 = builder.ram("64gb").processor("corei7").build();
		System.out.println(customPC1);
	}
}
