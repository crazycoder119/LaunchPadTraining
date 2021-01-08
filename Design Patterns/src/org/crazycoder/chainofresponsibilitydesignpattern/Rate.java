package org.crazycoder.chainofresponsibilitydesignpattern;

public class Rate extends Handler{
	@Override
	public Handler processWork() {
		System.out.println("Process is over : wait for ratings - "+this.getClass());
		return null;
	}
}
