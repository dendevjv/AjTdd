package ajtdd.sis.studentinfo;

import java.util.Date;

public class CourseSessionTest extends SessionTest {

	public void testCount() {
		CourseSession.resetCount();
		createSession("", "", new Date());
		assertEquals(1, CourseSession.getCount());
		createSession("", "", new Date());
		assertEquals(2, CourseSession.getCount());
	}

	public void testCourseDates() {
		Date startDate = DateUtil.createDate(2003, 1, 6);
		Session session = createSession(DEPARTMENT_NAME, COURSE_NUMBER,
				startDate);
		Date sexteenWeekOut = DateUtil.createDate(2003, 4, 25);
		assertEquals(sexteenWeekOut, session.getEndDate());
	}

	protected Session createSession(String departmentName, String courseNumber,
			Date startDate) {
		return CourseSession.create(departmentName, courseNumber, startDate);
	}
}
