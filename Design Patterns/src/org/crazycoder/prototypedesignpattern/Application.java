package org.crazycoder.prototypedesignpattern;

public class Application {
	public static void main(String args[]) {
		UniversityRegistry registry = new UniversityRegistry();
		
		Lecturer lecture = (Lecturer) registry.register(UniversityMemberType.LECTURER);
		System.out.println(lecture);
		
		Student student1 = (Student) registry.register(UniversityMemberType.STUDENT);
		System.out.println(student1);
		Student student2 = (Student) registry.register(UniversityMemberType.STUDENT);
		System.out.println(student2);
		student2.getEnrolledCourses().setSubject1("english");
		System.out.println(student1);
		System.out.println(student2);
		
	}
}
