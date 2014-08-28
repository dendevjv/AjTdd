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
	
}
