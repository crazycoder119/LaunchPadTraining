package org.crazycoder.prototypedesignpattern;

import java.util.HashMap;

public class UniversityRegistry {
	private HashMap<UniversityMemberType, UniversityMember> member = new HashMap<>();

	public UniversityRegistry() {
		this.initialize();
	}

	private void initialize() {

		Student student = new Student();
		student.setName("Amila");
		Course course = new Course();
		course.setSubject1("maths");
		course.setSubject2("chemistry");
		course.setSubject3("physics");
		student.setEnrolledCourses(course);

		Lecturer lecture = new Lecturer();
		lecture.setName("Mr.Saman");
		lecture.setModule("maths");

		member.put(UniversityMemberType.STUDENT, student);
		member.put(UniversityMemberType.LECTURER, lecture);
	}

	public UniversityMember register(UniversityMemberType memberType) {
		UniversityMember uniMember = null;
		try {
			switch (memberType) {
			case STUDENT:
				uniMember = (Student) member.get(memberType).clone();
				break;
			case LECTURER:
				uniMember = (Lecturer) member.get(memberType).clone();
				break;
			default:
				break;
			}
		} catch (CloneNotSupportedException cloneNotSupportedException) {
			System.out.println("Clone not supported exception occured : " + cloneNotSupportedException);
		}
		return uniMember;
	}

}
