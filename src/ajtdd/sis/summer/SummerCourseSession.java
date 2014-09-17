package ajtdd.sis.summer;

import java.util.Date;

import ajtdd.sis.studentinfo.Session;

public class SummerCourseSession extends Session {
	private static final int SUMMER_SESSION_LENGTH = 8;

	public static SummerCourseSession create(String departmentName,
			String courseNumber, Date startDate) {
		return new SummerCourseSession(departmentName, courseNumber, startDate);
	}

	private SummerCourseSession(String department, String number,
			Date startDate) {
		super(department, number, startDate);
	}
	
	@Override
	public int getSessionLength() {
		return SUMMER_SESSION_LENGTH;
	}
}
