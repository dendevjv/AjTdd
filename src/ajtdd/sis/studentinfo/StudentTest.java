package ajtdd.sis.studentinfo;

import ajtdd.sis.studentinfo.Student.Grade;

public class StudentTest extends junit.framework.TestCase {
	private static final double GRADE_TOLERANCE = 0.05;
	private static final String STUDENT_NAME_1 = "Jane Doe";
	private static final String STUDENT_NAME_2 = "Joe Blow";

	public void testCalculateGpa() {
		Student student = new Student("a");
		assertGpa(student, 0.0);
		student.addGrade(Grade.A);
		assertGpa(student, 4.0);
		student.addGrade(Grade.B);
		assertGpa(student, 3.5);
		student.addGrade(Grade.C);
		assertGpa(student, 3.0);
		student.addGrade(Grade.D);
		assertGpa(student, 2.5);
		student.addGrade(Grade.F);
		assertGpa(student, 2.0);
	}
	
	public void testCalculateHonorsStudentGpa() {
		assertGpa(createHonorsStudent(), 0.0);
		assertGpa(createHonorsStudent(Grade.A), 5.0);
		assertGpa(createHonorsStudent(Grade.B), 4.0);
		assertGpa(createHonorsStudent(Grade.C), 3.0);
		assertGpa(createHonorsStudent(Grade.D), 2.0);
		assertGpa(createHonorsStudent(Grade.F), 0.0);
	}
	
	public void testCreate() {
		Student student1 = new Student(STUDENT_NAME_1);
		assertEquals(STUDENT_NAME_1, student1.getName());

		Student student2 = new Student(STUDENT_NAME_2);
		assertEquals(STUDENT_NAME_2, student2.getName());

		assertEquals(STUDENT_NAME_1, student1.getName());
	}

	public void testInState() {
		Student st = new Student("a");
		assertFalse(st.isInState());
		st.setState(Student.IN_STATE);
		assertTrue(st.isInState());
		st.setState("MD");
		assertFalse(st.isInState());
	}

	public void testStudentsStatus() {
		Student st = new Student("a");
		assertEquals(0, st.getCredits());
		assertFalse(st.isFullTime());

		st.addCredits(3);
		assertEquals(3, st.getCredits());
		assertFalse(st.isFullTime());

		st.addCredits(4);
		assertEquals(7, st.getCredits());
		assertFalse(st.isFullTime());

		st.addCredits(5);
		assertTrue(Student.CREDITS_REQUIRED_FOR_FULL_TIME <= st.getCredits());
		assertTrue("not enough credits for FT status", st.isFullTime());
	}

	private void assertGpa(Student student, double gpa) {
		assertEquals(student.getGpa(), gpa, GRADE_TOLERANCE);
	}

	private Student createHonorsStudent() {
		Student st = new Student("a");
		st.setGradingStrategy(new HonorsGradingStrategy());
		return st;
	}

	private Student createHonorsStudent(Grade grade) {
		Student st = createHonorsStudent();
		st.addGrade(grade);
		return st;
	}
}
