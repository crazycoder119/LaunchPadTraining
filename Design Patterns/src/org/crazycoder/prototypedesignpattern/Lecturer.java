package org.crazycoder.prototypedesignpattern;

public class Lecturer extends UniversityMember implements Cloneable{
	private String module;

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return "Lecturer [module=" + module + ", Name=" + getName() + ", Age=" + getAge() + ", Gender="
				+ getGender()+ "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
