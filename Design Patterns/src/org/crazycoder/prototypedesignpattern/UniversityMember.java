package org.crazycoder.prototypedesignpattern;

public abstract class UniversityMember implements Cloneable{
	private String name;
	private int age;
	private GenderCode gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public GenderCode getGender() {
		return gender;
	}
	public void setGender(GenderCode gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "UniversityMember [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
