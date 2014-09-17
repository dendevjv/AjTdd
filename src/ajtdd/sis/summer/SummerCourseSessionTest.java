package ajtdd.sis.summer;

import java.util.Date;

import ajtdd.sis.studentinfo.DateUtil;
import ajtdd.sis.studentinfo.Session;
import ajtdd.sis.studentinfo.SessionTest;

public class SummerCourseSessionTest extends SessionTest {
	public void testEndDate() {
		Date startDate = DateUtil.createDate(2003, 6, 9);
		Session session = createSession("ENGL", "200", startDate);
		Date eightWeekOut = DateUtil.createDate(2003, 8, 1);
		assertEquals(eightWeekOut, session.getEndDate());
	}

	@Override
	protected Session createSession(String departmentName, String courseNumber,
			Date startDate) {
		return SummerCourseSession.create(departmentName, courseNumber, startDate);
	}
}
