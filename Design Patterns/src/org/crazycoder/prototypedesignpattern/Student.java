package org.crazycoder.prototypedesignpattern;

public class Student extends UniversityMember implements Cloneable {
	private Course enrolledCourses;

	public Course getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(Course enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	@Override
	public String toString() {
		return "Student [enrolledCourses=" + enrolledCourses.getSubject1() + ", " + enrolledCourses.getSubject2() + ", "
				+ enrolledCourses.getSubject3() + ", getName()=" + getName() + ", getAge()=" + getAge()
				+ ", getGender()=" + getGender() + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// Each student have their own course module
		Student student = (Student) super.clone();
		student.enrolledCourses = (Course) enrolledCourses.clone();
		return student;
	}
	
	
	
}
