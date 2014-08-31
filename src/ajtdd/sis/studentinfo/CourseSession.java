package ajtdd.sis.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Provides a representation of a single semester session of a specific
 * university course.
 */
public class CourseSession {
	private static int count;

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

	private String department;
	private String number;
	private int numberOfCredits;
	private Date startDate;
	private ArrayList<Student> students = new ArrayList<Student>();

	/**
	 * Constructs a CourseSession starting on a specific date.
	 * 
	 * @param department
	 * @param number
	 * @param startDate
	 */
	private CourseSession(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}

	public void enroll(Student student) {
		student.addCredits(numberOfCredits);
		students.add(student);
	}

	public ArrayList<Student> getAllStudents() {
		return students;
	}

	public int getNumberOfStudents() {
		return students.size();
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setNumberOfCredits(int credits) {
		this.numberOfCredits = credits;
	}

	Student get(int i) {
		return students.get(i);
	}

	String getDepartment() {
		return department;
	}

	/**
	 * Get the last date of the course session
	 * 
	 * @return the last date of the course session
	 */
	Object getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		final int sessionLengthInWeeks = 16;
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		final int numberOfDays = sessionLengthInWeeks * daysInWeek
				- daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}

	String getNumber() {
		return number;
	}

}
