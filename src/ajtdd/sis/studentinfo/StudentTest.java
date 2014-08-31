package ajtdd.sis.studentinfo;

public class StudentTest extends junit.framework.TestCase {
	private static final String STUDENT_NAME_2 = "Joe Blow";
	private static final String STUDENT_NAME_1 = "Jane Doe";

	public void testCreate() {
		Student student1 = new Student(STUDENT_NAME_1);
		assertEquals(STUDENT_NAME_1, student1.getName());

		Student student2 = new Student(STUDENT_NAME_2);
		assertEquals(STUDENT_NAME_2, student2.getName());

		assertEquals(STUDENT_NAME_1, student1.getName());
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

	public void testInState() {
		Student st = new Student("a");
		assertFalse(st.isInState());
		st.setState(Student.IN_STATE);
		assertTrue(st.isInState());
		st.setState("MD");
		assertFalse(st.isInState());
	}
}
