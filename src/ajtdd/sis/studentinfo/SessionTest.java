package ajtdd.sis.studentinfo;

import java.util.Date;

import junit.framework.TestCase;

public abstract class SessionTest extends TestCase {
	private static final int CREDITS = 3;
	protected static final String COURSE_NUMBER = "101";
	protected static final String DEPARTMENT_NAME = "ENGL";
	
	private Session session;
	private Date startDate;
	
	public void setUp() {
		startDate = DateUtil.createDate(2003, 1, 6);
		session = createSession(DEPARTMENT_NAME, COURSE_NUMBER, startDate);
		session.setNumberOfCredits(CREDITS);
	}
	
	abstract protected Session createSession(String departmentName,
			String courseNumber, Date startDate);
	
	public void testCreate() {
		assertEquals(DEPARTMENT_NAME, session.getDepartment());
		assertEquals(COURSE_NUMBER, session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
	}
	
	public void testCompareTo() {
		final  Date date = new Date();
		Session sessionA = createSession("CMSC", "101", date);
		
		Session sessionB = createSession("ENGL", "101", date);
		assertTrue(sessionA.compareTo(sessionB) < 0);
		assertTrue(sessionB.compareTo(sessionA) > 0);
		
		CourseSession sessionC = CourseSession.create("CMSC", "101", date);
		assertTrue(sessionA.compareTo(sessionC) == 0);
		
		CourseSession sessionD = CourseSession.create("CMSC", "210", date);
		assertTrue(sessionD.compareTo(sessionC) > 0);
		assertTrue(sessionC.compareTo(sessionD) < 0);
	}

	public void testEnrollStudents() {
		final Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(CREDITS, student1.getCredits());
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));

		final Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		assertEquals(CREDITS, student2.getCredits());
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}
}
