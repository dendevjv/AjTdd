package ajtdd.sis.studentinfo;

import java.util.Date;

import junit.framework.TestCase;

public class CourseSessionTest extends TestCase {
	private static final int CREDITS = 3;
	private static final String COURSE_NUMBER = "101";
	private static final String DEPARTMENT_NAME = "ENGL";

	private CourseSession session;
	private Date startDate;

	public void setUp() {
		startDate = DateUtil.createDate(2003, 1, 6);
		session = createCourceSession();
	}

	public void testCount() {
		CourseSession.resetCount();
		createCourceSession();
		assertEquals(1, CourseSession.getCount());
		createCourceSession();
		assertEquals(2, CourseSession.getCount());
	}
	
	public void testCourseDates() {
		Date sexteenWeekOut = DateUtil.createDate(2003, 4, 25);
		assertEquals(sexteenWeekOut, session.getEndDate());
	}

	public void testCreate() {
		assertEquals(DEPARTMENT_NAME, session.getDepartment());
		assertEquals(COURSE_NUMBER, session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
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

	private CourseSession createCourceSession() {
		CourseSession session = CourseSession.create(DEPARTMENT_NAME, COURSE_NUMBER, startDate);
		session.setNumberOfCredits(CourseSessionTest.CREDITS);
		return session;
	}
}
