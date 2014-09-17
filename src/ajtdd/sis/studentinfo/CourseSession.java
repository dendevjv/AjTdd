package ajtdd.sis.studentinfo;

import java.util.Date;

/**
 * Provides a representation of a single semester session of a specific
 * university course.
 */
public class CourseSession extends Session  {
	private static int count;
	private static final int SESSION_LENGTH = 16;

	public static CourseSession create(String departmentName,
			String courseNumber, Date startDate) {
		incrementCount();
		return new CourseSession(departmentName, courseNumber, startDate);
	}

	public static int getCount() {
		return count;
	}

	public static void resetCount() {
		count = 0;
	}

	private static void incrementCount() {
		++count;
	}

	/**
	 * Constructs a CourseSession starting on a specific date.
	 * 
	 * @param department
	 * @param number
	 * @param startDate
	 */
	protected CourseSession(String department, String number, Date startDate) {
		super(department, number, startDate);
	}

	public int getSessionLength() {
		return SESSION_LENGTH;
	}

}
